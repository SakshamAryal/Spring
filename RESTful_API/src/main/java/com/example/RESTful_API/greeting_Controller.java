package com.example.RESTful_API;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greeting_Controller {
    public static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template,
                name));
    }

    @GetMapping("applicant")
    public Applicant applicant(@RequestParam(defaultValue = "Enter a name") String name) {
        String app = "Name: %s";
        return new Applicant(counter.incrementAndGet(), String.format(app, name));
    }

}
