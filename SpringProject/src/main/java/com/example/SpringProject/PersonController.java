package com.example.SpringProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonController {

    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello , %s!";

    @GetMapping("/person")
    public Person person(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Person(counter.incrementAndGet(),String.format(template,name));
    }
}
