package com.capgemini.homeloanprocessinginjdbc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.capgemini.homeloanprocessinginjdbc.dto.AppStatusInfoBeans;

public interface AppStatusDAO {
	public AppStatusInfoBeans getAppStatusByLoanId(long id) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException;
}
