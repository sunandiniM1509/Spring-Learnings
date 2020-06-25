package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	//define a private field for the dependency
	private FortuneService fortuneService;
	@Override
    public String getDailyWorkout()
    {
	return "Spend 30 min on batting practice";
    }
	public BaseballCoach(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
}
