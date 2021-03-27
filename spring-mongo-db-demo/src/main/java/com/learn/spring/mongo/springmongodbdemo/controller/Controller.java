package com.learn.spring.mongo.springmongodbdemo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.learn.spring.mongo.springmongodbdemo.model.Data;
import com.learn.spring.mongo.springmongodbdemo.service.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controller {

    @Autowired
    private DataService dataService;

    @PostMapping(value="/v1/resource", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Data> getMethodName(@RequestBody Data data) {
        return new ResponseEntity<>(dataService.saveData(data), HttpStatus.CREATED);
    }

    @GetMapping(value="/v1/resource")
    public ResponseEntity<List<Data>> getMethodName() {
        return new ResponseEntity<>(dataService.getData(), HttpStatus.OK);
    }

    @DeleteMapping(value="/v1/resource/{username}")
    public ResponseEntity<Boolean> deleteData(@PathVariable String username) {
        return new ResponseEntity<>(dataService.deleteData(username), HttpStatus.ACCEPTED);
    }
}
