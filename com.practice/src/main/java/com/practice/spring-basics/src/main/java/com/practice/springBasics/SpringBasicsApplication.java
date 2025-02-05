package com.practice.springBasics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringBasicsApplication {

	public static void main(String[] args) {


		ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
		Earth earth = context.getBean(Earth.class);
		earth.name();
	}

}
