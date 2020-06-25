package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
public class CreateDemo {

	public static void main(String[] args) {
	// create session factory
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
    		.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		//create session
    Session session = factory.getCurrentSession();
    try
    {
        
    	//create the objects
    	
    	/*Instructor tempInstructor = new Instructor("Mike","Ross","pearsonHardman@gmail.com");
    	
    	InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.pearsonHardman.com/youtube","Practicing Law");*/
    	
        Instructor tempInstructor = new Instructor("Jessica","Pearson","pearsonnow22@gmail.com");
    	
    	InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.BusinessBugs.com/youtube","Acting in Suits");
    	
    	//associate the objects
    	
    	tempInstructor.setInstructorDetail(tempInstructorDetail);
    	
    	
    	
    	//start a transaction
    	session.beginTransaction();
    	
    	
    	//save the instructor
    	//...this will also save instructor detail object as we cascaded all
    	
    	 System.out.println("Saving instructor: "+ tempInstructor);
    	 session.save(tempInstructor);
    	
    	//commit transaction
        session.getTransaction().commit();
        System.out.println("Done!");
    }
    finally
    {
    	factory.close();
    }
	}

}
