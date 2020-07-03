package com.jsfsfeb.homeloanprocessingwithspringboot.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsfsfeb.homeloanprocessingwithspringboot.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessingwithspringboot.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessingwithspringboot.dto.EmployeeInfoBeans;

public interface UserDAO {

	public Boolean userLogin(EmployeeInfoBeans bean) throws SQLException;

	public Boolean removeCustomerInfoByName(String name) throws SQLException;

	public CustomerInfoBeans retriveAllCustomerInfoByName(String name) throws SQLException;

	public CustomerInfoBeans retriveAllCustomerInfoBySerial() throws SQLException;

	public List<CustomerInfoBeans> retriveAllCustomerInfo() throws SQLException;

	public Boolean removeLoanInfoById(long id) throws SQLException;

	public Boolean updateLoanAppStatusInfoById(AppStatusInfoBeans app) throws SQLException;

}
