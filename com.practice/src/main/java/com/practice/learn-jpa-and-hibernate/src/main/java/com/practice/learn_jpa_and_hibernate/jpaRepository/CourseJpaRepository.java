package com.practice.learn_jpa_and_hibernate.jpaRepository;

import com.practice.learn_jpa_and_hibernate.Entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Course insert(Course course) {
        return entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public Course update(Course course) {
        return entityManager.merge(course);

    }

    public void deleteById(long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }
}
