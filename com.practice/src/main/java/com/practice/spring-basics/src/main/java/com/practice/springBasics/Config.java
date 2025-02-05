package com.practice.springBasics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {
    @Bean
    public String string(){
        return new String("hello");
    }
    @Bean

    public Earth earth(){
        return new Earth(new Person("suhel",20));
    }
    @Bean(name="earth2")
    public Earth earth2(Person person){
        return new Earth(person);
    }

    @Bean
    public Person person(){
        return new Person("zayn",26);
    }
}
