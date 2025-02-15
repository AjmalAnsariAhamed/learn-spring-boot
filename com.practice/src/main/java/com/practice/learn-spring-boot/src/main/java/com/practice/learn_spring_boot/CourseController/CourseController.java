package com.practice.learn_spring_boot.CourseController;

import com.practice.learn_spring_boot.Entity.Courses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    private List<Courses>courses= new ArrayList<>();
    @GetMapping("/health-check")
    public String healthCheck(){

        return "all Okay and all happy and enjoy it mre and more";
    }
    @GetMapping(path = "/courses")
    public List<Courses> getAllCourses(){
        courses.addAll(Arrays.asList(new Courses(1,"Dragon ball z","Akira toriyama"),
                new Courses(2,"Naruto","Masashi Kishimoto"),new Courses(3,"OnePiece","Eiichiro Oda"),new Courses(5,"Gintama","Sorachi Hideaki"),new Courses(6,"HxH","Togashi")));
        return courses;
    }
    @PostMapping("/add")
    public void post(@RequestBody Courses course) {
        courses.add(course);
        System.out.println(courses);

    }
}
