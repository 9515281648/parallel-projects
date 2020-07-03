package com.jsfsfeb.homeloanprocessingwithspringboot.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jsfsfeb.homeloanprocessingwithspringboot.dto.AppStatusInfoBeans;
 @Repository
public class AppStatusDAOImplementation implements AppStatusDAO {

	AppStatusInfoBeans beans = new AppStatusInfoBeans();
	 
	public AppStatusInfoBeans getAppStatusByLoanId(long ids)
			throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		 
		

		
		
		
		EntityManagerFactory	entityManagerFactory= Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager=entityManagerFactory.createEntityManager();
		 
		 String jpql = "select e from loanappstatus e  where appId=:id   ";
		 Query query = manager.createQuery(jpql);
		 
		 query.setParameter("id", ids);
		 
	 	 
		 
		 @SuppressWarnings("unchecked")
		List<AppStatusInfoBeans[]> movie =    query.getResultList();
		 
		 Iterator  i = movie.iterator();
		 
		 while(i.hasNext()) {
			 System.out.println(i.next());
	 
		 }
		 

		
		
		return null;
	} 
	
}
