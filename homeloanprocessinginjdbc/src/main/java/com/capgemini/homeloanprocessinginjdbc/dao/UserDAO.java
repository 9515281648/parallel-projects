package com.capgemini.homeloanprocessinginjdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.homeloanprocessinginjdbc.dto.AppStatusInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.CustomerInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.EmployeeInfoBeans;

public interface UserDAO {

	public Boolean userLogin(EmployeeInfoBeans bean) throws SQLException;

	public Boolean removeCustomerInfoByName(String name) throws SQLException;

	public CustomerInfoBeans retriveAllCustomerInfoByName(String name) throws SQLException;

	public CustomerInfoBeans retriveAllCustomerInfoBySerial() throws SQLException;

	public List<CustomerInfoBeans> retriveAllCustomerInfo() throws SQLException;

	public Boolean removeLoanInfoById(long id) throws SQLException;

	public Boolean updateLoanAppStatusInfoById(AppStatusInfoBeans app) throws SQLException;

}
