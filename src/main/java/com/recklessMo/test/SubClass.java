package com.recklessMo.test;

import lombok.Data;

@Data
public class SubClass {

    private long classId;
    private String className;
    private int totalCount;

    public SubClass(long classId, String className, int totalCount){
        this.classId = classId;
        this.className = className;
        this.totalCount = totalCount;
    }

}
