package com.jsfsfeb.homeloanprocessingjpawithhibernates.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.exceptions.DataNotFoundException;
 
public class AppStatusDAOImplementation implements AppStatusDAO {

	AppStatusInfoBeans beans = new AppStatusInfoBeans();
	 
	public AppStatusInfoBeans getAppStatusByLoanId(long ids)
			throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		 
		

		
		AppStatusInfoBeans infoBeans = new AppStatusInfoBeans();
		
		EntityManagerFactory	entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=entityManagerFactory.createEntityManager();
		 
		 String jpql = "select e from AppStatusInfoBeans e  where appId=:id   ";
	            TypedQuery<AppStatusInfoBeans> movie 	= manager.createQuery(jpql,AppStatusInfoBeans.class);
		 
		 movie.setParameter("id", ids);
		 
	 	 try {
	infoBeans =	 movie.getSingleResult();
		 
	 	 }catch(NoResultException e) {
throw new DataNotFoundException("entered loanid is invalid");
	 	 }

		
		
		return infoBeans;
	} 
	
}
