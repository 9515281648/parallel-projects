package com.jsfsfeb.homeloanprocessingwithspringboot.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jsfsfeb.homeloanprocessingwithspringboot.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessingwithspringboot.exceptions.DataNotFoundException;

 

 @Repository
public class CustomerDAOImplementation implements CustomerDAO {@Override
	public boolean customerApplication(CustomerInfoBeans bean)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean customerApplicationUpdate(CustomerInfoBeans bean)
			throws SQLException {
		 
		
		
		
		 EntityManagerFactory  entityManagerFactory = null;
		 	EntityManager manager = null;
	 	EntityTransaction transaction = null;
		
		try {
			entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
			 manager=entityManagerFactory.createEntityManager();
				  transaction =manager.getTransaction();
				 transaction.begin();
				 String jpql = "update CustomerInfoBeans e  set e.appId=:aaid ,e.email=:mail,e.loanId=:id ,e.adhaarNumber=:adhaar , e.panNumber=:pan  where   e.customerName = :name   ";
				 Query query = manager.createQuery(jpql);
				 
				 query.setParameter("aaid", bean.getAppId());
				 query.setParameter("mail", bean.getEmail());
				 query.setParameter("id", bean.getLoanId());
				 query.setParameter("adhaar", bean.getAdhaarNumber());
				 query.setParameter("pan", bean.getPanNumber());
				 query.setParameter("name", bean.getCustomerName());
					
				 
				 int record = query.executeUpdate();
				 
				 if(record==0) {
					 throw new DataNotFoundException("invalid name");
				 }else {
					 return true;
				 }
				 
				 
				 
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		
		 manager.close();
		 entityManagerFactory.close();
		
		
		return false;
	}

	@Override
	public boolean customerApplicationUpdateById(CustomerInfoBeans bean) throws SQLException {
	 
CustomerInfoBeans beans=new CustomerInfoBeans();
		 
		 
		 EntityManagerFactory  entityManagerFactory = null;
		 	EntityManager manager = null;
	 	EntityTransaction transaction = null;
		
		try {
			entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
			 manager=entityManagerFactory.createEntityManager();
				  transaction =manager.getTransaction();
				 transaction.begin();
				 String jpql = "update customer_application e  set e.customerName = :name,e.email=:mail,e.loanId=:id ,e.adhaarNumber=:adhaar , e.panNumber=:pan  where e.appId=:aaid   ";
				 Query query = manager.createQuery(jpql);
				 query.setParameter("name", bean.getCustomerName());
				 query.setParameter("mail", bean.getEmail());
				 query.setParameter("id", bean.getLoanId());
				 query.setParameter("adhaar", bean.getAdhaarNumber());
				 query.setParameter("pan", bean.getPanNumber());
				 query.setParameter("aaid", bean.getAppId());
				 
				 int record = query.executeUpdate();
				 
				 System.out.println("record updated :"+ record);
				transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		
		 manager.close();
		 entityManagerFactory.close();
		 
		 
	
		return false;
	} }
