package com.practice.learn_jpa_and_hibernate.jdbc;

import com.practice.learn_jpa_and_hibernate.Entity.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseJdbcRepositoryTest {
    @Mock
    JdbcTemplate template;
    @InjectMocks
    CourseJdbcRepository repository;


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

    private Course course;

    @BeforeEach
    void setup() {
        course = new Course(1L, "in28Minutes", "Ranga");
    }

    @Test
    void findByIdTest() {
        Course expectedCourse = course;
//        when(template.queryForObject(selectQ, new BeanPropertyRowMapper<>(Course.class),1l)).thenReturn(new Course(1,"I28Minutes","Ranga"));
        when(template.queryForObject(eq(selectQ), any(BeanPropertyRowMapper.class), eq(1l)))
                .thenReturn(new Course(1l, "in28Minutes", "Ranga"));
        Course actualCourse = repository.findById(1l);

        assertEquals(expectedCourse.getName(), actualCourse.getName());
        assertEquals(expectedCourse.getAuthor(), actualCourse.getAuthor());
        assertEquals(expectedCourse.getId(), actualCourse.getId());
    }

    @Test
    void insert() {

        doReturn(1).when(template).update(insertQ, course.getId(), course.getName(), course.getAuthor());

        int result = repository.insert(new Course(1l, "in28Minutes", "Ranga"));
        assertEquals(1, result);
        verify(template).update(insertQ, course.getId(), course.getName(), course.getAuthor());
    }

    @Test
    void deleteByIdTest() {
        when(template.update(deleteQ, 1l)).thenReturn(1);
        int result = repository.deleteById(1L);
        assertEquals(1, result);
    }

    @Test
    void updateTest() {

        when(template.update(updateQ, course.getName(), course.getAuthor(), course.getId())).thenReturn(1);
        repository.update(course);
        verify(template).update(updateQ, course.getName(), course.getAuthor(), course.getId());
    }


}