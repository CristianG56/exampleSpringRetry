package co.com.exampleSpringRetry.adapter.router.error.handler;

import co.com.exampleSpringRetry.adapter.examplespringretry.exception.ExampleCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(ExampleCustomException.class)
    public ResponseEntity<Object> handleExampleCustomException(ExampleCustomException ex) {
        String msg = ex.getMessage().concat(" - Max Attempts for retry exception");
        log.error("Custom Exceptiom: {}", ex.getMessage());
        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}