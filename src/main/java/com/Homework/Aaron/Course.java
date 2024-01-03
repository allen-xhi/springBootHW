package com.Homework.Aaron;

import org.springframework.stereotype.Component;

@Component
public class Course {
    public String insertCourse(){
        return "Insert Course!";
    }
    public String selectCourse(){
        return "select Course!";
    }
    public String updateCourse(){
        return "update Course!";
    }
    public String deleteCourse(){
        return "delete Course!";
    }

}
