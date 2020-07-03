package com.capgemini.homeloanprocessinginjdbc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.homeloanprocessinginjdbc.dto.AppStatusInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.exceptions.DataNotFoundException;
import com.capgemini.homeloanprocessinginjdbc.utility.Utility;
import com.mysql.cj.jdbc.exceptions.MySQLTransactionRollbackException;

public class AppStatusDAOImplementation implements AppStatusDAO {
	int value = 0;
	ResultSet result = null;
	AppStatusInfoBeans appStatusInfoBeans = new AppStatusInfoBeans();
	Utility utility = new Utility();


	public AppStatusInfoBeans getAppStatusByLoanId(long id) throws SQLException, IOException, ClassNotFoundException {
		try (Connection connection = utility.getConnection()) {
			
			try (PreparedStatement PreparedStatement = connection.prepareStatement(utility.getQuery("getLoanStatus") )) {

				PreparedStatement.setLong(1, id);

				result = PreparedStatement.executeQuery();
 				if (result.next()) {
					appStatusInfoBeans.setAppId(result.getInt("appId"));
					appStatusInfoBeans.setAcceptedOrRejected(result.getString("acceptedOrRejected"));
					appStatusInfoBeans.setDateOfInterview(result.getDate("dateOfInterview").toLocalDate());
					appStatusInfoBeans.setApprovedOrRejected(result.getString("approvedOrRejected"));
					return appStatusInfoBeans;
				}
 	             throw new DataNotFoundException("entered id is invalid");

			}

		} catch (MySQLTransactionRollbackException e) {

			e.printStackTrace();
		}
		return appStatusInfoBeans;

	}

}
