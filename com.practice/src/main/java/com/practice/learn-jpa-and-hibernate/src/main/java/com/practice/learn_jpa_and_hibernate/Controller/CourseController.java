package com.practice.learn_jpa_and_hibernate.Controller;

import com.practice.learn_jpa_and_hibernate.Entity.Course;
import com.practice.learn_jpa_and_hibernate.springDataJpa.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    CourseRepository repo;

    @GetMapping("/courses")
    public List<Course> getAll() {
        return repo.findAll();

    }

    @GetMapping("/course/{id}")
    public Course getById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());

    }

    @PostMapping("/course")
    public ResponseEntity<Course> post(@RequestBody Course course) {
        Course addedCourse = repo.save(course);
        return new ResponseEntity<>(addedCourse, HttpStatus.OK);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Course updatedCourse) {
        Optional<Course> existing = repo.findById(id);
        if (existing.isPresent()) {
            Course course = existing.get();
            course.setAuthor(updatedCourse.getAuthor());
            course.setName(updatedCourse.getName());
            repo.save(course);
            return ResponseEntity.ok("updated");
        }
        return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course with ID " + id + " not found.");
        }

        repo.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Course with ID " + id + " deleted successfully.");
    }
}
