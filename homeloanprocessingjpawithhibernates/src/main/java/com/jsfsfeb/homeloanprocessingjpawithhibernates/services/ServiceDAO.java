package com.jsfsfeb.homeloanprocessingjpawithhibernates.services;

 import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.EmployeeInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.LoansInfoBeans;

public interface ServiceDAO {

	public Boolean userLogin( EmployeeInfoBeans bean) throws SQLException;

	public boolean customerApplication(CustomerInfoBeans b1) throws SQLException;

	public Boolean removeCustomerInfoByName(String name) throws SQLException;

	public CustomerInfoBeans retriveAllCustomerInfoByName(String name) throws SQLException;

	public CustomerInfoBeans retriveAllCustomerInfoBySerial() throws SQLException;

	public  List<LoansInfoBeans> retriveLoanDetails() throws SQLException;

	public AppStatusInfoBeans getAppStatusByLoanId(long id) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException;

	public LoansInfoBeans retriveLoanDetailsById(long id) throws SQLException;

	public Boolean setEmiByLoanId(long id, long emi) throws SQLException;

	public List<CustomerInfoBeans> retriveAllCustomerInfo() throws SQLException;

	public Boolean addLoan(LoansInfoBeans bean) throws SQLException;

	public Boolean removeLoanInfoById(long id) throws SQLException;

	public Boolean updateLoanAppStatusInfoById(AppStatusInfoBeans app) throws SQLException;
	
	public Boolean addLoanAppStatusInfo(AppStatusInfoBeans app) throws SQLException;
	
	public boolean customerApplicationUpdate(CustomerInfoBeans bean) throws SQLException;
	
	public boolean customerApplicationUpdateById(CustomerInfoBeans bean) throws SQLException;

	
}
