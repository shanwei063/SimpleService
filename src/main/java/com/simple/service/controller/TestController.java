package com.simple.service.controller;

import com.simple.service.mapper.AdministratorMapper;
import com.simple.service.properties.ProjectProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private ProjectProperties projectProperties;

    @Autowired
    private AdministratorMapper administratorMapper;

    @GetMapping("/")
    public String say()
    {
        logger.info("begin to exec say()");
        return "our project name is " + projectProperties.getName() + ", owner is " + projectProperties.getOwner();
        //return administratorMapper.getAllAdministrator().get(0).getAccount();
    }
}
