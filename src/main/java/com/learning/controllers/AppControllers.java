package com.learning.controllers;

import com.learning.beans.ComponentInjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class AppControllers {

    @Autowired
    String sampleBean1;

    @Autowired
    @Qualifier("sampleBean2")  // use @Qualifier in case we want to create an object that doesnt have the same name as the bean name
    String SampleBean2;

    @Autowired
    ComponentInjection componentInjection;

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/samplebean1")
    public String samplebean1(){
        return sampleBean1;
    }

    @GetMapping("/samplebean2")
    public String samplebean2(){
        return SampleBean2;
    }

    @GetMapping("/componentInjection")   //injected via component scanning of classpath
    public String componentInjection(){
        return componentInjection.componentName();
    }
}
