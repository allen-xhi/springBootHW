package com.Homework.Aaron;

import org.springframework.stereotype.Component;

@Component
public class BookCourseEvent implements Event {
    @Override
    public String getContent(String message) {
        return "Book course :" + message;
    }
}
