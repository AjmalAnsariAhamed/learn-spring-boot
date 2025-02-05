package com.practice.springBasics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringBasicsApplication {

	public static void main(String[] args) {


		var context= new AnnotationConfigApplicationContext(Config.class);

		Earth earth=context.getBean("earth",Earth.class);
		earth.name();

		Earth earth2 = context.getBean("earth2", Earth.class);

		earth2.name();
	}

}
