package com.recklessMo.test;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Lecture {

    private long id;
    private Teacher teacher;
    private List<SubClass> groupList = new LinkedList<>();
    private int totalCount;
    private int timeValue;
    private Course course;

    public Lecture(long id, Teacher teacher, Course course, int timeValue){
        this.id = id;
        this.teacher = teacher;
        this.course = course;
        this.timeValue = timeValue;
    }

    public void addGroup(SubClass subClass){
        groupList.add(subClass);
        totalCount = groupList.stream().mapToInt((o)->o.getTotalCount()).sum();
    }



}
