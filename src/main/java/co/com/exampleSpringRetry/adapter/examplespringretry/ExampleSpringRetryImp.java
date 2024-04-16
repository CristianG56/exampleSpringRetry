package co.com.exampleSpringRetry.adapter.examplespringretry;

import co.com.exampleSpringRetry.adapter.examplespringretry.exception.ExampleCustomException;
import co.com.exampleSpringRetry.domain.ExampleSpringRetryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class ExampleSpringRetryImp implements ExampleSpringRetryRepository {

    String uri = "http://localhost:8088/EjemploSpringRetry/AnotherMicroservice";

    RestTemplate restTemplate;

    @Autowired
    public ExampleSpringRetryImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Retryable(retryFor = ExampleCustomException.class, maxAttempts = 2, backoff = @Backoff(delay = 500), listeners = "exampleListenerSpringRetry")
    public String callMicroserviceResponse(String data) throws ExampleCustomException {
        HttpEntity<String> entity = new HttpEntity<>(null);
        try {
            ResponseEntity<String> responseExample = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
            return responseExample.getBody();
        } catch (HttpServerErrorException e) {
            if (e.getMessage().contains("Error during execution")) throw new ExampleCustomException("Catch error during execution");
            throw new HttpServerErrorException(e.getStatusCode(), e.getMessage());
        }
    }

    @Recover
    public String recoverMicroservice(ExampleCustomException e, String data) {
        String exampleText = "Here can you put call to a emergency service if you request is too very important";
        if (data.equals("1")) return exampleText;
        throw new ExampleCustomException(e.getMessage());
    }
}
