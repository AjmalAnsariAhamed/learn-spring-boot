package com.practice.springBasics;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class Singleton{

}
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class Prototype{

}
@Configuration
@ComponentScan
public class ScopeDemo {
    public static void main(String[] args) {
        try(var context=new AnnotationConfigApplicationContext(ScopeDemo.class)){
            //Singleton
            System.out.println(context.getBean("singleton"));
            //com.practice.springBasics.Singleton@563f38c4
            System.out.println(context.getBean("singleton"));
            //com.practice.springBasics.Singleton@563f38c4
            System.out.println(context.getBean("singleton"));
            //com.practice.springBasics.Singleton@563f38c4
            // same Object is returning
            System.out.println();
            //Prototype
            System.out.println(context.getBean("prototype"));
            //com.practice.springBasics.Prototype@543295b0
            System.out.println(context.getBean("prototype"));
            //com.practice.springBasics.Prototype@54422e18
            System.out.println(context.getBean("prototype"));
            //com.practice.springBasics.Prototype@117159c0

            // fr-singleton same Object is returning
            //          BUT
            //fr-Prototype each time a new Object will be created

        }
    }
}
