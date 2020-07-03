package com.jsfsfeb.homeloanprocessingwithspringboot.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.jsfsfeb.homeloanprocessingwithspringboot.dto.AppStatusInfoBeans;

public interface AppStatusDAO {
	public AppStatusInfoBeans getAppStatusByLoanId(long id) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException;
}
