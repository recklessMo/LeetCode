package com.recklessMo.test;

import lombok.Data;

@Data
public class Teacher {
    private long id;
    private String name;
    public Teacher(long id, String name){
        this.id = id;
        this.name = name;
    }
}
