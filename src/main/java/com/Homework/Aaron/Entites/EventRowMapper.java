package com.Homework.Aaron.Entites;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setId(rs.getLong("id"));
        event.setName(rs.getString("name"));
        event.setTriggerTime(rs.getTime("trigger_time"));
        event.setCreateAt(rs.getTime("created_at"));
        return event;
    }
}
