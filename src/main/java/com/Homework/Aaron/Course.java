package com.Homework.Aaron;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Course {
    public String insertCourse(Map<String,String> params){
        return "Insert Course with :" + params;
    }
    public String selectCourse(Map<String,String> params){
        return "select Course with :" + params;
    }
    public String updateCourse(Map<String,String> params){
        return "update Course with :" + params;
    }
    public String deleteCourse(Map<String,String> params){
        return "delete Course with :" + params;
    }

}
