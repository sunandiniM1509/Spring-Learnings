package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		// create session factory
	    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
	    		.addAnnotatedClass(Student.class).buildSessionFactory();
			//create session
	    Session session = factory.getCurrentSession();
	    try
	    {
	    	//use the session obj to save java obj
	    	//create student obj
	    	System.out.println("create new student obj");
	    	Student tempStudent1 = new Student("harvey","spector","harvey123@gmail.com");
	    	Student tempStudent2 = new Student("Polly","dweill","paster23@gmail.com");
	    	Student tempStudent3 = new Student("rimmy","ritzzirr","rihsaidn@gmail.com");
	    	
	    	//start a transaction
	    	session.beginTransaction();
	    	
	    	//save the student object
	        System.out.println("Saving the student...");
	        session.save(tempStudent1);
	        session.save(tempStudent2);
	        session.save(tempStudent3);

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
