package com.practice.learn_jpa_and_hibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert();

    }
}
