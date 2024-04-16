package co.com.exampleSpringRetry.adapter.router.config;

import co.com.exampleSpringRetry.utils.listeners.ExampleListenerSpringRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.retry.RetryListener;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("co.com.exampleSpringRetry")
public class AppConfig {

    @Bean
    RestTemplate restTemplate() {return new RestTemplate(new HttpComponentsClientHttpRequestFactory());}

    @Bean
    public RetryListener exampleListenerSpringRetry() { return new ExampleListenerSpringRetry(); }
}
