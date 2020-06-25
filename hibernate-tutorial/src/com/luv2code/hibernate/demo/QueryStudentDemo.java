package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	         // create session factory
             SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
    		.addAnnotatedClass(Student.class).buildSessionFactory();
		    //create session
    Session session = factory.getCurrentSession();
    try
    {
    	//start a transaction
    	session.beginTransaction();
    //query students
    	List<Student> theStudents = session.createQuery("from Student").getResultList();
    	//display the students
    	for( Student tempStudent :theStudents)
    	{
    		System.out.println(tempStudent);
    	}
    	//query students last name
        
    	theStudents =session.createQuery("from Student s where s.lastName='spector'").getResultList();
    	//display the students
    	for( Student tempStudent :theStudents)
    	{
    		System.out.println(tempStudent);
    	}
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
