package com.Homework.Aaron.Entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import  java.util.Date;
public class Event {
    private  Long id;
    private  String name;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date triggerTime;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString(){
        return "Event{" +
                "id=" + id +
                ",name=" + name +
                ",triggerTime=" + triggerTime +
                ",createAt=" + createAt +
                '}';


    }
}
