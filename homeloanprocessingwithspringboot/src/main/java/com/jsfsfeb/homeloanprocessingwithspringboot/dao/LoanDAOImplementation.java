package com.jsfsfeb.homeloanprocessingwithspringboot.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jsfsfeb.homeloanprocessingwithspringboot.dto.LoansInfoBeans;

 

 @Repository
public class LoanDAOImplementation implements LoanDAO {
	
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	
	public Boolean addLoan(LoansInfoBeans bean)
			throws SQLException {
	
	
	try {
		EntityManagerFactory	entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager	entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction	transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(bean);
		transaction.commit();
		return true;
	
	} catch (Exception e) {
		e.printStackTrace();
		transaction.rollback();
	}
	entityManager.close();
	entityManagerFactory.close();
	return false;
	
		 		 
	}

	 
	public List<LoansInfoBeans> retriveLoanDetails()
			throws SQLException {

		
		
		
		EntityManagerFactory	entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=entityManagerFactory.createEntityManager();
		 
		 String jpql = "select e from LoansInfoBeans e     ";
		 Query query = manager.createQuery(jpql);
		 

		 
		 
		 List<Object[]> movie =    query.getResultList();
		 
		 Iterator  i = movie.iterator();
		 
		 while(i.hasNext()) {
			 System.out.println(i.next());
	 
		 }
		 

		
		return null;
	}

	@Override
	public LoansInfoBeans retriveLoanDetailsById(long id)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setEmiByLoanId(long id, long emi) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	} }
