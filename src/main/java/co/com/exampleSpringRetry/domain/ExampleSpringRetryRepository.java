package co.com.exampleSpringRetry.domain;

@FunctionalInterface
public interface ExampleSpringRetryRepository {

    String callMicroserviceResponse (String data);
}
