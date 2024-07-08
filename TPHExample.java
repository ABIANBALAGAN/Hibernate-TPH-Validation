package com.model;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.PersistenceException;



public class TPHExample {
	public static void main(String[] args)
	{
		Transaction tr=null;
		try(Session session=HBUtil.getSesFactory().openSession())
		{
			tr=session.beginTransaction();
			Person p1=new Person("Sunil","Theni");
			Employee p2=new Employee("kumar", 50000f, "CEO","364521","kumarsunil");
			Customer p3=new Customer("kumar","kumarsunil@gmail.com" ,79046142,"regular","g");
			
			
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	        Validator validator = factory.getValidator();
	        Set<ConstraintViolation<Person>> violation = validator.validate(p1);
	        Set<ConstraintViolation<Employee>> violation2 = validator.validate(p2);
	        Set<ConstraintViolation<Customer>> violation3 = validator.validate(p3);
	        
	        
            
	        if (!violation.isEmpty() ){
	            for (ConstraintViolation<Person> violation1 : violation) {
	                System.out.println(violation1.getMessage());
	                
	            }
	        }
	            else {
	            	session.merge(p1);
		           // tr.commit();
	            }
	            
	 
	        
	         if(!violation2.isEmpty())
	         { 
	        	 for (ConstraintViolation<Employee> violation4 : violation2) {
	                System.out.println(violation4.getMessage());
	                
	            }
	         }
	         else
		        {
		            
		            session.merge(p2);
					//tr.commit();
		           
		        }
	         
	                 
	            if(!violation3.isEmpty())
	            {
	            for (ConstraintViolation<Customer> violation5 : violation3) {
	                System.out.println(violation5.getMessage());
	                
	            }
	            }
	            else
		        {
		          
					session.merge(p3);
		            
		        }
	            
	            
	           tr.commit();
	            session.close();
	            
	            
	            
	         }
	            
	            
	  
		catch (PersistenceException e) {
		    
		    e.printStackTrace();
		    if (tr != null) tr.rollback();
		    
		}
		catch(Exception e) {
			e.printStackTrace();
			if (tr != null) tr.rollback();
		}
	}
}
	
