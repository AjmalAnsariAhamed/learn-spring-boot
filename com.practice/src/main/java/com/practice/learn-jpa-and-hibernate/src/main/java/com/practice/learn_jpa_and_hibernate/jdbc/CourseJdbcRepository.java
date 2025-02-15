package com.practice.learn_jpa_and_hibernate.jdbc;

import com.practice.learn_jpa_and_hibernate.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static String insertQ = """
            insert into course(id,name,author)
            values(?,?,?)
            """;
    private static String deleteQ = """
            DELETE FROM course WHERE id=?
            """;
    private static String selectQ = """
            select * from course where id=?
            """;
    private static String updateQ = """
            update course set name=?, author=? where id=?
            """;

    public int insert(Course course) {
        return jdbcTemplate.update(insertQ, course.getId(), course.getName(), course.getAuthor());


    }

    public int deleteById(Long id) {
        return jdbcTemplate.update(deleteQ, id);
    }

    public Course findById(long id) {
        return jdbcTemplate.queryForObject(selectQ, new BeanPropertyRowMapper<>(Course.class), id);
    }

    public void update(Course course) {
        jdbcTemplate.update(updateQ, course.getName(), course.getAuthor(), course.getId());
    }
}
