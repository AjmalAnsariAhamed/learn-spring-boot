package com.practice.springBasics;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class NonLazy{
    NonLazy(){
        System.out.println("Non-Lazy class has been initializing");
    }
}
@Component
@org.springframework.context.annotation.Lazy
class Lazy{
    Lazy(){
        System.out.println("Lazy class has been initializing");
    }
}
@Configuration
@ComponentScan
public class LazyDemo {
    public static void main(String[] args) {
        try(var context= new AnnotationConfigApplicationContext(LazyDemo.class)){
            System.out.println("context has been settled ");
            context.getBean(Lazy.class);
        }
    }
}
