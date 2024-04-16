package co.com.exampleSpringRetry.utils.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

@Slf4j
public class ExampleListenerSpringRetry implements RetryListener {

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        if (context.getRetryCount() == 1) log.info("Retrying Call...");
    }
}
