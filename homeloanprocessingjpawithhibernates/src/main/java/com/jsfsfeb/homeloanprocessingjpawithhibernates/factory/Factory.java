package com.jsfsfeb.homeloanprocessingjpawithhibernates.factory;

import java.util.Scanner;

import com.jsfsfeb.homeloanprocessingjpawithhibernates.dao.AppStatusDAO;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dao.AppStatusDAOImplementation;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dao.CustomerDAO;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dao.CustomerDAOImplementation;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dao.LoanDAO;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dao.LoanDAOImplementation;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dao.UserDAO;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dao.UserDAOImplementation;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.EmployeeInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.LoansInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.services.ServiceDAO;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.services.ServiceDAOImplementation;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.validations.AppStatusValidations;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.validations.CustomerValidations;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.validations.LoanValidations;

public class Factory {
	
	private Factory() {
		
	}
	
	public static EmployeeInfoBeans employeeInstance() {
		EmployeeInfoBeans EmployeeInfoBeans = new EmployeeInfoBeans();
		return EmployeeInfoBeans;
	}
	
	public static AppStatusInfoBeans applicationStatusInstance() {
		AppStatusInfoBeans AppStatusInfoBeans = new AppStatusInfoBeans();
		return AppStatusInfoBeans;
	}
	
	public static CustomerInfoBeans customerInstance() {
		CustomerInfoBeans CustomerInfoBeans = new CustomerInfoBeans();
		
		return CustomerInfoBeans;
	}
	
	public static LoansInfoBeans loansInstance() {
		LoansInfoBeans LoansInfoBeans = new LoansInfoBeans();
		return LoansInfoBeans;
	}
	
	public static AppStatusDAO appStatusDAOImplementationInstance() {
		 AppStatusDAO dao = new AppStatusDAOImplementation();
		 return dao;
			 
	}
	
	public static LoanDAO loanDAOImplementationInstance() {
		 LoanDAO dao = new LoanDAOImplementation();
		 return dao;		 
	}
	
	public static CustomerDAO customerDAOImplementationInstance() {
		 CustomerDAO dao = new  CustomerDAOImplementation();
		 return dao;		 
	}
	
	public static UserDAO userDAOImplementationInstance() {
		 UserDAO dao = new  UserDAOImplementation();
		 return dao;		 
	}
	
	public static AppStatusValidations appStatusValidationsInstance() {
		AppStatusValidations appStatusValidations = new AppStatusValidations();
		 return appStatusValidations;		 
	}
	
	
	public static CustomerValidations customerValidationsInstance() {
		CustomerValidations customerValidations = new CustomerValidations();
		 return customerValidations;		 
	}
	
	public static LoanValidations loanValidationsInstance() {
		LoanValidations loanValidations = new LoanValidations();
		 return loanValidations;		 
	}
	
		
	public static ServiceDAO ServiceDAOInstance() {
		 ServiceDAO dao = new ServiceDAOImplementation();
		 return dao;		 
	}
	
	public static Scanner scannerInstance() {
		Scanner scanner = new Scanner(System.in);
		 return scanner;		 
	}
	
	
}































