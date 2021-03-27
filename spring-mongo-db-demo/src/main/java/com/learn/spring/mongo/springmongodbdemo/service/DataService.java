package com.learn.spring.mongo.springmongodbdemo.service;

import java.util.Collections;
import java.util.List;

import com.learn.spring.mongo.springmongodbdemo.model.Data;
import com.learn.spring.mongo.springmongodbdemo.repository.DataRepository;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class DataService {
    
    @Autowired
    private DataRepository dataRepository;

    public List<Data> getData() {
        List<Data> listOfAllData = dataRepository.findAll();
        if (CollectionUtils.isEmpty(listOfAllData)) {
            return Collections.emptyList();
        }
        return listOfAllData;
    }

    public Data saveData(Data data) {
        Data savedData = dataRepository.save(data);
        return savedData;
    }

    public boolean deleteData(String username) {
        Data dataToBeDeleted = dataRepository.findByUsername(username);
        if (ObjectUtils.isEmpty(dataToBeDeleted)) {
            return false;
        }
        dataRepository.delete(dataToBeDeleted);
        return true;
    }
}