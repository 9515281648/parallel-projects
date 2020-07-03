package com.jsfsfeb.homeloanprocessingjpawithhibernates.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.EmployeeInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.exceptions.DataNotFoundException;

public class UserDAOImplementation implements UserDAO {

	CustomerInfoBeans beans= new CustomerInfoBeans();
	 
	@Override
	public Boolean userLogin(EmployeeInfoBeans bean) {
		 
	
		EntityManagerFactory	entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=entityManagerFactory.createEntityManager();
		 
		 
  	 String jpql = "select e from EmployeeInfoBeans e where e.email=:mail AND e.password=:pass   ";
		 Query query = manager.createQuery(jpql);
		 
		 query.setParameter("mail", bean.getEmail());
		 query.setParameter("pass", bean.getPassword());
		  
	 	 
		 List<EmployeeInfoBeans[]> movie =    query.getResultList();
	 if(movie.isEmpty()) {
		throw new DataNotFoundException("emailid or password is incorrect ");
	 }else {
		 return true;
	 }
		 
		 
		 
	
		 
	}

	@Override
	public Boolean removeCustomerInfoByName(String name) throws SQLException {
		EntityManagerFactory	entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=entityManagerFactory.createEntityManager();
		EntityTransaction 	 transaction =manager.getTransaction();
		 transaction.begin();
		
  	 String jpql = "delete from CustomerInfoBeans c where c.customerName=:nam  ";
		 Query query = manager.createQuery(jpql);
		 
		 query.setParameter("nam",  name);
	 
		 int record = query.executeUpdate();
		 transaction.commit();
		 if(record==0) {
			 throw new DataNotFoundException("invalid name");

		 }else {
			 return true;
		 }
		 
	}

	@Override
	public CustomerInfoBeans retriveAllCustomerInfoByName(
			String name) throws SQLException {
		 
		EntityManagerFactory	entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=entityManagerFactory.createEntityManager();
		 
		 
  	 String jpql = "select e from CustomerInfoBeans e  where e.customerName=:nam   ";
  	 
  	 
  	TypedQuery<CustomerInfoBeans> query = manager.createQuery(jpql, CustomerInfoBeans.class);
	
  	 
		
		  query.setParameter("nam", name);
	 	 try {
		  CustomerInfoBeans movie =    query.getSingleResult();
			return movie;
	 	 }catch(NoResultException e) {
	 		 throw new DataNotFoundException( "entered name is invalid");
	 	 }
		 
		 
	}

	@Override
	public CustomerInfoBeans retriveAllCustomerInfoBySerial()
			throws SQLException {
		EntityManagerFactory	entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=entityManagerFactory.createEntityManager();
		 
		 
  	 String jpql = "select e from CustomerInfoBeans e where appId=(select min(appId) from   e) ";
		TypedQuery<CustomerInfoBeans> query = manager.createQuery(jpql, CustomerInfoBeans.class);
		CustomerInfoBeans bean = query.getSingleResult();
		  
		return bean;
	}

	@Override
	public List<CustomerInfoBeans> retriveAllCustomerInfo(){
		 
		
		EntityManagerFactory	entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=entityManagerFactory.createEntityManager();
		EntityTransaction 	 transaction =manager.getTransaction();
		 transaction.begin();
		
 	 String jpql = "select c from CustomerInfoBeans c   ";
		TypedQuery<CustomerInfoBeans> bean = manager.createQuery(jpql , CustomerInfoBeans.class);
		
		
		List<CustomerInfoBeans> b = bean.getResultList();
		
		return b;
		 
		 
		
		
	 
	}

	@Override
	public Boolean removeLoanInfoById(long ids) throws SQLException {
		 
		
		EntityManagerFactory	entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=entityManagerFactory.createEntityManager();
		EntityTransaction 	 transaction =manager.getTransaction();
		 transaction.begin();
		
  	 String jpql = "delete from LoanInfoBeans c where c.loanId=:id  ";
		 Query query = manager.createQuery(jpql);
		 
		 query.setParameter("id",  ids);
	 
		 int record = query.executeUpdate();
		 transaction.commit();
		 if(record==0) {
			 throw new DataNotFoundException("invalid name");

		 }else {
			 return true;
		 }
		
		
	 
	}

	@Override
	public Boolean updateLoanAppStatusInfoById(AppStatusInfoBeans app) throws SQLException {
		 
		
		 EntityManagerFactory  entityManagerFactory = null;
		 	EntityManager manager = null;
	 	EntityTransaction transaction = null;
		
		try {
			entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
			 manager=entityManagerFactory.createEntityManager();
				  transaction =manager.getTransaction();
				 transaction.begin();
				 String jpql = "update AppStatusInfoBeans e  set e.acceptedOrRejected=:acc, e.dateOfInterview=:date , e.approvedOrRejected=:approve where e.appId=:id  ";
				 Query query = manager.createQuery(jpql);
				 query.setParameter("acc", app.getAcceptedOrRejected());
				 query.setParameter("date", app.getDateOfInterview());
				 query.setParameter("approve", app.getApprovedOrRejected());
				 query.setParameter("id", app.getAppId());
				 
				 int record = query.executeUpdate();
				 
				 System.out.println("updated record with "+ record + "rows");
 
 
				transaction.commit();
		} catch (Exception e) {
			 
			transaction.rollback();
		}
		
		 manager.close();
		 entityManagerFactory.close();
		
		
		return true;
	}

	@Override
	public Boolean addLoanAppStatusInfo(AppStatusInfoBeans app) throws SQLException { 
		 
		
		 EntityManagerFactory  entityManagerFactory = null;
		 	EntityManager manager = null;
	 	EntityTransaction transaction = null;
		
		try {
			entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
			 manager=entityManagerFactory.createEntityManager();
				  transaction =manager.getTransaction();
				 transaction.begin();
				 manager.persist(app);
				transaction.commit();
				return true;
		} catch (Exception e) {
			 
			transaction.rollback();
		}
		
		 manager.close();
		 entityManagerFactory.close();
		
		
		return true;
	} }
















