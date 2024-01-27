package com.Homework.Aaron;

import com.Homework.Aaron.Entites.Event;
import com.Homework.Aaron.Entites.EventRowMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EventJDBCController {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/jdbc/events")
    public String insert(@RequestBody Event event) {
        String sql = "INSERT INTO events(name, trigger_time, created_at) VALUES (:name, :triggerTime, :createdAt)";
        Map<String, Object> map = new HashMap<>();
        map.put("name", event.getName());
        map.put("triggerTime", event.getTriggerTime());
        map.put("createdAt", new Timestamp(System.currentTimeMillis()));

        System.out.println("debug map=" + map.get("name"));
        System.out.println("debug input=" + event.getName());
        namedParameterJdbcTemplate.update(sql, map);
        return "create Event";
    }

    @GetMapping("jdbc/events/{id}")
    public Event select(@PathVariable Integer id) {
        String sql = "SELECT * FROM events WHERE id=:id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<Event> list = namedParameterJdbcTemplate.query(sql, map, new EventRowMapper());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @GetMapping("jdbc/events")
    public List<Event> selectAll() {
        String sql = "SELECT * FROM events ";
        List<Event> list = namedParameterJdbcTemplate.query(sql, new EventRowMapper());
        System.out.println("selsectAll, ==>" + list);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @PutMapping("jdbc/events")
    public String update(@RequestBody Event updatedEvent) {
        String sql = "UPDATE events " +
                "SET name = :name, trigger_time = :trigger_time, created_at = :createdAt" +
                " WHERE id = :id; ";
        Map<String, Object> map = new HashMap<>();
        map.put("id", updatedEvent.getId());
        map.put("name", updatedEvent.getName());
        map.put("trigger_time", updatedEvent.getTriggerTime());
        map.put("createdAt", updatedEvent.getCreateAt());
        System.out.println("created AT ==>" + updatedEvent.getCreateAt());
        int result = namedParameterJdbcTemplate.update(sql, map);
        if (result > 0) {
            return "update Event success";
        } else {
            return "update Event fail";
        }
    }

    @DeleteMapping("jdbc/events/{id}")
    public String Delete(@PathVariable Integer id) {
        String sql = "DELETE  FROM events WHERE id=:id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        int result = namedParameterJdbcTemplate.update(sql, map);
        if (result > 0) {
            return "delete Event success";
        } else {
            return "delete Event fail";
        }
    }
}
