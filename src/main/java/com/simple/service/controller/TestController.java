package com.simple.service.controller;

import com.simple.service.properties.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ProjectProperties projectProperties;
    @RequestMapping("/")
    public String say()
    {
        return "our project name is " + projectProperties.getName() + ", owner is " + projectProperties.getOwner();
    }
}
