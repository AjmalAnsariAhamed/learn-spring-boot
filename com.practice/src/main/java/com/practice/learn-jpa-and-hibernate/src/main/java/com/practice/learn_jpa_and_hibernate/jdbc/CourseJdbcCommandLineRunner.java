package com.practice.learn_jpa_and_hibernate.jdbc;

import com.practice.learn_jpa_and_hibernate.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1,"in28Minutes","Ranga"));
        repository.insert(new Course(2,"learnAws","Ranga"));
        repository.insert(new Course(3,"learn python","Ranga"));
        repository.deleteById(3l);
        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(2l));


    }

}
