package com.practice.learn_jpa_and_hibernate;

import com.practice.learn_jpa_and_hibernate.Entity.Course;
import com.practice.learn_jpa_and_hibernate.jdbc.CourseJdbcRepository;
import com.practice.learn_jpa_and_hibernate.jpaRepository.CourseJpaRepository;
import com.practice.learn_jpa_and_hibernate.springDataJpa.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    CourseJdbcRepository repository;
//    @Autowired
//    CourseJpaRepository repository;
    @Autowired
    CourseRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"in28Minutes","Ranga"));
        repository.save(new Course(2,"learnAws","Ranga"));
        repository.save(new Course(3,"learn python","Ranga"));
        repository.save(new Course(4,"Spring boot","Faisal memon"));
        repository.save(new Course(5,"React js","Faisal memon"));
        //update
        repository.save(new Course(1,"in28Minutes","Ranga karunam"));
        repository.deleteById(3l);
        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(2l));
        System.out.println(repository.findAll());
        System.out.println(repository.findByAuthor("Faisal memon"));



    }

}
