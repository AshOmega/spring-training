package com.learning.beans;

import org.springframework.stereotype.Component;

@Component
public class ComponentInjection {

    public String componentName(){
        return "Object created via Component Injection";
    }
}
