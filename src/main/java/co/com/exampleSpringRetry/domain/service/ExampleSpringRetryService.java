package co.com.exampleSpringRetry.domain.service;

import co.com.exampleSpringRetry.domain.ExampleSpringRetryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExampleSpringRetryService {

    @Autowired
    private ExampleSpringRetryRepository ejemploSpringRetryRepository;


    public String CallAnotherMicroServiceExample(String data) {
        log.info("Calling AnotherMicroServiceExample");
        return ejemploSpringRetryRepository.callMicroserviceResponse(data);
    }
}
