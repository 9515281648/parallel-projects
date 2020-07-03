package com.jsfsfeb.homeloanprocessingjpawithhibernates.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.exceptions.DataNotFoundException;

 

 
public class CustomerDAOImplementation implements CustomerDAO {@Override
	public boolean customerApplication(CustomerInfoBeans bean)
			throws SQLException {
	 	EntityManagerFactory  EntityManagerFactory = null;
	 	EntityManager Manager = null;
	 	EntityTransaction Transaction = null;
	
	try {
		  EntityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		  Manager = EntityManagerFactory.createEntityManager();
		 Transaction = Manager.getTransaction();
		 Transaction.begin();
			Manager.persist(bean);
			System.out.println("record saved");
			Transaction.commit();
		
	} catch (Exception e) {
		Transaction.rollback();
	}


Manager.close();
EntityManagerFactory.close();

	 
	

		return true;
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
	 int record =0;
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
				 String jpql = "update CustomerInfoBeans  e  set e.customerName = :name,e.email=:mail,e.loanId=:id ,e.adhaarNumber=:adhaar , e.panNumber=:pan  where e.appId=:aaid   ";
				 Query query = manager.createQuery(jpql);
				 query.setParameter("name", bean.getCustomerName());
				 query.setParameter("mail", bean.getEmail());
				 query.setParameter("id", bean.getLoanId());
				 query.setParameter("adhaar", bean.getAdhaarNumber());
				 query.setParameter("pan", bean.getPanNumber());
				 query.setParameter("aaid", bean.getAppId());
				 
				   record = query.executeUpdate();
				  
				transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		
		 
		
		 manager.close();
	 
		 if(record !=0) {
				return true;
			}
		 
	
		return false;
	}

	   }
