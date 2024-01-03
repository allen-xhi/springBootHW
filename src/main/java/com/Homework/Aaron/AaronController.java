package com.Homework.Aaron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class AaronController {
    @Autowired
    Course course;
    @Qualifier("bookCourseEvent")
    @Autowired
    Event event;

    @RequestMapping("/")
    public String index(){
        return "Greeting from Spring Boot!";
    }

    @GetMapping("/register-success")
    public String registerSuccess() {
        String content = event.getContent("Allen");
        return content;
    }
    @GetMapping("/book-course")
    public String bookCourse(){
        String content = event.getContent("Allen");
        return content;
    }
    @GetMapping ("/Course")
    public String select(){
        return course.selectCourse();
    }
    @PostMapping("/Course")
    public String Insert(){
        return course.insertCourse();
    }
    @PutMapping("/Course")
    public String update(){
        return course.updateCourse();
    }
    @DeleteMapping("/Course")
    public String delete(){
        return course.deleteCourse();
    }
}
