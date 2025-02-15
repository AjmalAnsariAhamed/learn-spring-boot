package com.practice.learn_jpa_and_hibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static String insertQ= """
            insert into course(id,name,author)
            values(1,'java','james Gosling')
            """;
    public void insert(){
        jdbcTemplate.update(insertQ);
    }
}
