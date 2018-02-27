package com.recklessMo.test;

import lombok.Data;

@Data
public class Course {
    private long id;
    private String name;

    public Course(long id, String name){
        this.id = id;
        this.name = name;
    }
}
