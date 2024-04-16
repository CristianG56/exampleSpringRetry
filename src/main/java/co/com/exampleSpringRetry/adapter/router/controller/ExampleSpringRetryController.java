package co.com.exampleSpringRetry.adapter.router.controller;

import co.com.exampleSpringRetry.domain.service.ExampleSpringRetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exampleSpringRetry")
public class ExampleSpringRetryController {

    @Autowired
    private ExampleSpringRetryService exampleSpringRetryService;

    @GetMapping("/{data}")
    public String callExampleSpringRetry(
            @PathVariable("data") String data) {
        return exampleSpringRetryService.CallAnotherMicroServiceExample(data);
    }
}
