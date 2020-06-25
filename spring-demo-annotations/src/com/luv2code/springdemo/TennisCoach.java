package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
@Autowired
@Qualifier("randomFortuneService")
private FortuneService fortuneService;

//define my init method
/*@PostConstruct
public void doMyStartupStuff() {
	System.out.println(">>TennisCoach : inside of doMyStartupStuff()");
}

//define my destroy method
@PreDestroy
public void doMyCleanupStuff() {
	System.out.println(">>TennisCoach : inside of doMyCleanupStuff()");
}
*/
/*
@Autowired
public TennisCoach(FortuneService theFortuneService)
{
	fortuneService=theFortuneService;
}
    //define a setter method
    @Autowired
    public void setFortuneService(FortuneService theFortuneService)
    {
    	System.out.println(">>inside TennisCoach's setFortuneService() method");
    	fortuneService=theFortuneService;
    }
    */

//default constructor
public TennisCoach()
{
	System.out.println(">>inside TennisCoach's defautl constructor");
}
	@Override
	public String getDailyWorkout() {
		
		return "practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
