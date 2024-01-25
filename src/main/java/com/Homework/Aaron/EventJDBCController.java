package com.Homework.Aaron;

import com.Homework.Aaron.Entites.Event;
import com.Homework.Aaron.Entites.EventRowMapper;
import org.springframework.beans.factory.annotation.Autowired;

import  org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import  org.springframework.web.bind.annotation.*;

import  java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EventJDBCController {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/jdbc/events")
    public String insert(@RequestBody Event event){
        String sql = "INSERT INTO events(name, trigger_time, created_at) VALUES (:name, :triggerTime, :createdAt)";
        Map<String, Object> map = new HashMap<>();
        map.put("name", event.getName());
        map.put("triggerTime", event.getTriggerTime());
        map.put("createdAt", new Timestamp(System.currentTimeMillis()));

        namedParameterJdbcTemplate.update(sql, map);
        return "create Event";
    }

    @GetMapping("jdbc/events/{id}")
    public Event select(@PathVariable Integer id){
        String sql = "SELECT * FROM events WHERE id=:id";
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);

        List<Event> list = namedParameterJdbcTemplate.query(sql,map,new EventRowMapper());
        if(list.isEmpty()){
            return null;
        }
        return  list.get(0);
    }

    @GetMapping("jdbc/events")
    public List<Event> selectAll(){
        String sql = "SELECT * FROM events ";
        List<Event> list = namedParameterJdbcTemplate.query(sql,new EventRowMapper());

        if(list.isEmpty()){
            return null;
        }
        return  list;
    }

    @PutMapping("jdbc/events")
    public Event update(@RequestBody Event updatedEvent){

        Optional<String> id = Optional.ofNullable(updatedEvent.getName());
        if (id.isPresent()) {
            // 提供了column1参数，可以进行相应的处理
        } else {
            // 没有提供column1参数，可以返回错误响应或采取其他措施
            return ResponseEntity.badRequest().body("column1 parameter is required");
        }


        String sql = "UPDATE events " +
                "SET column1 = value1, column2 = value2" +
                "WHERE condition; ";


        return event;
    }
    @DeleteMapping("jdbc/events")
    public String Delete(@RequestBody Event DeleteEvent){
        String sql = "DELETE * FROM events WHERE id=:id";
        Map<String,Object> map = new HashMap<>();
        map.put("id",DeleteEvent.getId());
        namedParameterJdbcTemplate.update(sql,map);
        return "Delete Success";
    }
}
