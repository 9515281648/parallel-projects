package com.capgemini.homeloanprocessinginjdbc.dao;

import java.sql.SQLException;

import com.capgemini.homeloanprocessinginjdbc.dto.CustomerInfoBeans;

public interface CustomerDAO {
	public boolean customerApplication(CustomerInfoBeans bean) throws SQLException;
	public boolean customerApplicationUpdate(CustomerInfoBeans bean) throws SQLException;
	public boolean customerApplicationUpdateById(CustomerInfoBeans bean) throws SQLException;
}
