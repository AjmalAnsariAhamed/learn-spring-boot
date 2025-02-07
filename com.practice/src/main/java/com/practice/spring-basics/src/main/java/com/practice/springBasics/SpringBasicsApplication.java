package com.practice.springBasics;

import com.practice.springBasics.BusinessCalculationService.BusinessCalculationServiceRunner;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class PostConstruction{
	PostConstruction(){
		System.out.println("post Construction has been initialized");
	}
	@PostConstruct
	void construct(){
		System.out.println("Post construct methods has been called");
	}
}
@Component
class PreDestruction{
	PreDestruction(){
		System.out.println("pre destruction has been initialized");
	}
	@PreDestroy
	void destroy(){
		System.out.println("destruction method has been called");
	}
}

@Configuration
@ComponentScan
public class SpringBasicsApplication {

	public static void main(String[] args) {
try(var context= new AnnotationConfigApplicationContext(SpringBasicsApplication.class)){
	context.getBeanDefinitionNames();
}


	}

}
