package com.capgemini.homeloanprocessinginjdbc.factory;

import java.util.Scanner;

import com.capgemini.homeloanprocessinginjdbc.dao.AppStatusDAO;
import com.capgemini.homeloanprocessinginjdbc.dao.AppStatusDAOImplementation;
import com.capgemini.homeloanprocessinginjdbc.dao.CustomerDAO;
import com.capgemini.homeloanprocessinginjdbc.dao.CustomerDAOImplementation;
import com.capgemini.homeloanprocessinginjdbc.dao.LoanDAO;
import com.capgemini.homeloanprocessinginjdbc.dao.LoanDAOImplementation;
import com.capgemini.homeloanprocessinginjdbc.dao.UserDAO;
import com.capgemini.homeloanprocessinginjdbc.dao.UserDAOImplementation;
import com.capgemini.homeloanprocessinginjdbc.dto.AppStatusInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.CustomerInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.EmployeeInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.LoansInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.services.ServiceDAO;
import com.capgemini.homeloanprocessinginjdbc.services.ServiceDAOImplementation;
import com.capgemini.homeloanprocessinginjdbc.validations.AppStatusValidations;
import com.capgemini.homeloanprocessinginjdbc.validations.CustomerValidations;
import com.capgemini.homeloanprocessinginjdbc.validations.LoanValidations;

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































