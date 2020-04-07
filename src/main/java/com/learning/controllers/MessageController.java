package com.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@ComponentScan
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/name")
    public String getName(Locale locale){
        return messageSource.getMessage("getName",null, locale);
    }

    @GetMapping("/nameWithArgs")
    public String getNameWithArgs(Locale locale){
        return messageSource.getMessage("getNameWithArgs",new String[]{"Arg1", "Arg2"}, locale);
    }
}
