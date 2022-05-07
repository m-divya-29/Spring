package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * STEP:2
 * HTTP requests are handled by a controller. These components are identified by the @RestController annotation
 */
// @RestController annotation marks the class as a controller where every method returns a domain object
@RestController
public class GreetingController {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();
    /*
    @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
    @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method.
    If the name parameter is absent in the request, the defaultValue of World is used.
    Both of the below GET are handled:
    http://localhost:8080/greeting?name=User
    http://localhost:8080/greeting
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World!")String name){
        return  new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}