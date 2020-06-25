package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
	//read spring config file
		AnnotationConfigApplicationContext context =
	new AnnotationConfigApplicationContext(SportConfig.class);
		
//get bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		//call a method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call a method to get daily fortune
				System.out.println(theCoach.getDailyFortune());
		//close the context
		context.close();
	}

}
