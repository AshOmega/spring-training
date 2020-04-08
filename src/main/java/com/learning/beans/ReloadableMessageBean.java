package com.learning.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ReloadableMessageBean{

    @Bean(name= "messageSource")
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.addBasenames("/WEB-INF/resourcebundles/reloadablemessages");
        messageSource.setCacheSeconds(10);  //set this to check for reload every 10 seconds
        return messageSource;
    }


}
