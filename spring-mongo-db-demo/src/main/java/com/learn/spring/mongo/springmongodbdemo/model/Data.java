package com.learn.spring.mongo.springmongodbdemo.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Data {
    @Id
    private String Id;
    private String fname;
    private String lname;
    private String username;
	public Data(String fname, String lname, String username) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
    }
}
