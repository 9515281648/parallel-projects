package com.jsfsfeb.homeloanprocessingjpawithhibernates.dao;

import java.sql.SQLException;

import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.CustomerInfoBeans;

public interface CustomerDAO {
	public boolean customerApplication(CustomerInfoBeans bean) throws SQLException;
	public boolean customerApplicationUpdate(CustomerInfoBeans bean) throws SQLException;
	public boolean customerApplicationUpdateById(CustomerInfoBeans bean) throws SQLException;
	 
}
