package com.learning.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class AppControllers {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }
}
