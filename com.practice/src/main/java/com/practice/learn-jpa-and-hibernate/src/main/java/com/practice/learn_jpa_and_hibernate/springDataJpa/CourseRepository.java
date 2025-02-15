package com.practice.learn_jpa_and_hibernate.springDataJpa;

import com.practice.learn_jpa_and_hibernate.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
