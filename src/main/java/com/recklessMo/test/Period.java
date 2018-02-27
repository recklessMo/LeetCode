package com.recklessMo.test;

import lombok.Data;

@Data
public class Period {

    private long id;
    private String name;
    private int val;
    private int flag;

    public Period(long id, String name, int val, int flag){
        this.id = id;
        this.name = name;
        this.val = val;
        this.flag = flag;
    }

}
