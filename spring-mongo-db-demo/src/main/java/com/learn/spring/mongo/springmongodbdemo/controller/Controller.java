package com.learn.spring.mongo.springmongodbdemo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {

    @GetMapping(value="/v1/resource")
    public String getMethodName() {
        return "Hello World";
    }
}
