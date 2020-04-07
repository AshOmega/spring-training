package com.learning.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeans {

    @Bean(name = "sampleBean1")
    public String sampleBean1(){
        return "SampleBean1";
    }

    @Bean(name = "sampleBean2")
    public String sampleBean2(){
        return "SampleBean2";
    }
}
