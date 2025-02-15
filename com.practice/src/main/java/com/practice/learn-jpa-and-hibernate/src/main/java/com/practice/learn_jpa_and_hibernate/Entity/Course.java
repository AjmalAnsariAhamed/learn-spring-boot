package com.practice.learn_jpa_and_hibernate.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private long id;
    private String name;
    private String author;
}
