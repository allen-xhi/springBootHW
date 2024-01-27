package com.Homework.Aaron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;
import java.util.Map;

@RestController
public class AaronController {
    @Autowired
    Course course;
    @Qualifier("bookCourseEvent")
    @Autowired
    Event event;

    @RequestMapping("/")
    public String index() {
        return "Greeting from Spring Boot!";
    }

    @GetMapping("/register-success")
    public String registerSuccess() {
        String content = event.getContent("Allen");
        return content;
    }

    @GetMapping("/book-course")
    public String bookCourse() {
        String content = event.getContent("Allen");
        return content;
    }

    @GetMapping("/Course")
    public String select(@RequestParam Map<String, String> params) {
        return course.selectCourse(params);
    }

    @PostMapping("/Course")
    public String Insert(@RequestParam Map<String, String> params) {
        return course.insertCourse(params);
    }

    @PutMapping("/Course")
    public String update(@RequestParam Map<String, String> params) {
        return course.updateCourse(params);
    }

    @DeleteMapping("/Course")
    public String delete(@RequestParam Map<String, String> params) {
        return course.deleteCourse(params);
    }
}
