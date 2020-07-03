package com.capgemini.homeloanprocessinginjdbc.services;

 import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.capgemini.homeloanprocessinginjdbc.dto.AppStatusInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.CustomerInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.EmployeeInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.LoansInfoBeans;

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
	
	public boolean customerApplicationUpdate(CustomerInfoBeans bean) throws SQLException;
	
	public boolean customerApplicationUpdateById(CustomerInfoBeans bean) throws SQLException;
}
