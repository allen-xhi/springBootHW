package com.Homework.Aaron;

import org.springframework.stereotype.Component;

@Component
public class RegisterSuccessEvent implements Event {
    @Override
    public String getContent(String message) {
        return "Register Success :" + message;
    }
}
