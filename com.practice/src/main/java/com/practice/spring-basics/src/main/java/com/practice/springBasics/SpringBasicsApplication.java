package com.practice.springBasics;

import com.practice.springBasics.BusinessCalculationService.BusinessCalculationServiceRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class SpringBasicsApplication {

	public static void main(String[] args) {
try(var context= new AnnotationConfigApplicationContext(SpringBasicsApplication.class)){
	System.out.println(Arrays.toString( context.getBeanDefinitionNames()));
	BusinessCalculationServiceRunner object= context.getBean(BusinessCalculationServiceRunner.class);
	System.out.println(object.findMax());
}


	}

}
