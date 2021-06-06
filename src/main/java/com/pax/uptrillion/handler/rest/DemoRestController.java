package com.pax.uptrillion.handler.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DemoRestController {
    @Value("${fdrc.name}")
    private String fdrcName;

    //expose "/demo" that return greeting words
    @GetMapping("/demoRest")
    public String sayHello() {
        return "Welcom to Uptrillion's Handler Page. Time on the server is: " + LocalDateTime.now();
    }
}
