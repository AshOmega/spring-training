package com.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@ComponentScan
@RequestMapping("/messages")
public class ReloadableMessageController {

    @Autowired
    ReloadableResourceBundleMessageSource resourceBundleMessageSource;

    @GetMapping("/reloadableMessages")
    public String reloadableMessages(Locale locale) {
        return resourceBundleMessageSource.getMessage("getNameWithArgs", new String[]{"Arg1", "Arg2"}, locale);
    }
}

