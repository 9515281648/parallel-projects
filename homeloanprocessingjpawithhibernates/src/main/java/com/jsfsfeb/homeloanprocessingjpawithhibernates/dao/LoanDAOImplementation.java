package com.jsfsfeb.homeloanprocessingjpawithhibernates.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.LoansInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.exceptions.DataNotFoundException;
import com.mysql.cj.conf.ConnectionUrl.Type;

 

 
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
		TypedQuery<LoansInfoBeans> movie =   manager.createQuery(jpql , LoansInfoBeans.class);
		 

		 List<LoansInfoBeans> bean = movie.getResultList(); 
		 
		
		return bean;
	}

	@Override
	public LoansInfoBeans retriveLoanDetailsById(long id)
			throws SQLException {
		LoansInfoBeans bean =null;
		EntityManagerFactory	entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=entityManagerFactory.createEntityManager();
		 
		 String jpql = "select e from LoansInfoBeans e where e.loanId=:ids    ";
		TypedQuery<LoansInfoBeans> movie =   manager.createQuery(jpql , LoansInfoBeans.class);
		
		movie.setParameter("ids", id);
		 
		 try {
			   bean = movie.getSingleResult();  
			 
		 }
		 catch(NoResultException e) {
			 System.err.println("entered id is invalid");
		 }

		 
		 
		return bean;
	}

	@Override
	public Boolean setEmiByLoanId(long id, long emi) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	} }
