package com.learn.spring.mongo.springmongodbdemo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.learn.spring.mongo.springmongodbdemo.model.Data;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controller {

    @PostMapping(value="/v1/resource", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Data> getMethodName(@RequestBody Data data) {
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping(value="/v1/resource")
    public ResponseEntity<String> getMethodName() {
        return new ResponseEntity<>("Hello World", HttpStatus.ACCEPTED);
    }
}
