package com.capgemini.homeloanprocessinginjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.homeloanprocessinginjdbc.dto.CustomerInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.exceptions.DataNotFoundException;
import com.capgemini.homeloanprocessinginjdbc.utility.Utility;
import com.mysql.cj.jdbc.exceptions.MySQLTransactionRollbackException;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomerDAOImplementation implements CustomerDAO {

	int rescreate = 0;

	ResultSet res = null;
	CustomerInfoBeans beancreate = new CustomerInfoBeans();
	Utility utility = new Utility();

	public boolean customerApplication(CustomerInfoBeans bean) throws SQLException {

		try (Connection connection = utility.getConnection()) {
			try (Statement stmtcreate1 = connection.createStatement()) {

				res = stmtcreate1.executeQuery(utility.getQuery("getcustomerapp"));

				while (res.next()) {
					if (res.getString("customerName").equals(bean.getCustomerName()) == false
							|| res.getLong("appId") != bean.getAppId() || res.getString("email") != bean.getEmail()
							|| res.getLong("LoanId") != bean.getLoanId()
							|| res.getLong("adhaarNumber") != bean.getAdhaarNumber()
							|| res.getLong("panNumber") != bean.getPanNumber()) {

						try (PreparedStatement stmtcreate = connection
								.prepareStatement(utility.getQuery("addcustomerdetails"))) {

							stmtcreate.setLong(1, bean.getAppId());
							stmtcreate.setString(2, bean.getCustomerName());
							stmtcreate.setString(3, bean.getEmail());
							stmtcreate.setLong(4, bean.getLoanId());
							stmtcreate.setLong(5, bean.getAdhaarNumber());
							stmtcreate.setLong(6, bean.getPanNumber());

							rescreate = stmtcreate.executeUpdate();

							if (bean.getAppId() == 0 || bean.getCustomerName() == null || bean.getEmail() == null
									|| bean.getLoanId() == 0 || bean.getAdhaarNumber() == 0
									|| bean.getPanNumber() == 0) {

								try (PreparedStatement stmtcreate2 = connection
										.prepareStatement(utility.getQuery("deletecustomerdetails"));) {

									stmtcreate2.executeUpdate();

								} catch (MySQLTransactionRollbackException e) {

									e.printStackTrace();
								}

							}

							return true;

						} catch (MySQLTransactionRollbackException e) {

							e.printStackTrace();
						}

					} else {
						throw new DataNotFoundException("entered name already exits");
					}

				}
			}
		} catch (MySQLTransactionRollbackException e) {

			e.printStackTrace();
		}

		finally {

			try {
				if (res != null) {
					res.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		if (rescreate != 0) {
			return true;
		} else {
			return false;
		}

	}

	int result = 0;

	CustomerInfoBeans CustomerInfoBeans = new CustomerInfoBeans();

	public boolean customerApplicationUpdate(CustomerInfoBeans bean) throws SQLException {

		try (Connection con = utility.getConnection()) {
			try (Statement state = con.createStatement()) {
				try (ResultSet ResultSet = state.executeQuery(utility.getQuery("getcustomerapp"))) {

					while (ResultSet.next()) {
						if (ResultSet.getString("customerName").equals(bean.getCustomerName()) == false
								|| ResultSet.getLong("appId") != bean.getAppId()
								|| ResultSet.getString("email") != bean.getEmail()
								|| ResultSet.getLong("LoanId") != bean.getLoanId()
								|| ResultSet.getLong("adhaarNumber") != bean.getAdhaarNumber()
								|| ResultSet.getLong("panNumber") != bean.getPanNumber()) {

							try (PreparedStatement stmt = con
									.prepareStatement(utility.getQuery("updatecustomerdetails"))) {
								stmt.setString(1, bean.getEmail());
								stmt.setLong(2, bean.getLoanId());
								stmt.setLong(3, bean.getAdhaarNumber());
								stmt.setLong(4, bean.getPanNumber());
								stmt.setString(5, bean.getCustomerName());

								result = stmt.executeUpdate();

								if (bean.getCustomerName() == null) {
									return true;
								}
							}
						} else {
							throw new DataNotFoundException("entered name already exits");
						}

					}
				}
			}
		} catch (MySQLTransactionRollbackException e) {

			e.printStackTrace();
		}

		if (result != 0) {
			return true;
		} else {
			log.info("entered name doesn't exist in database");
			return false;
		}

	}

	int score = 0;

	CustomerInfoBeans infoBeans = new CustomerInfoBeans();

	public boolean customerApplicationUpdateById(CustomerInfoBeans bean) throws SQLException {

		try (Connection Connection = utility.getConnection()) {
			try (Statement Statement = Connection.createStatement()) {
				try (ResultSet resultSet = Statement.executeQuery(utility.getQuery("getcustomerapp"))) {

					while (resultSet.next()) {
						if (resultSet.getString("customerName") != bean.getCustomerName()
								|| resultSet.getLong("appId") == bean.getAppId()
								|| resultSet.getString("email") != bean.getEmail()
								|| resultSet.getLong("LoanId") != bean.getLoanId()
								|| resultSet.getLong("adhaarNumber") != bean.getAdhaarNumber()
								|| resultSet.getLong("panNumber") != bean.getPanNumber()) {

							try (PreparedStatement PreparedStatement = Connection
									.prepareStatement(utility.getQuery("updatecustomerdetailsbyid"));) {

								PreparedStatement.setString(1, bean.getCustomerName());
								PreparedStatement.setString(2, bean.getEmail());
								PreparedStatement.setLong(3, bean.getLoanId());
								PreparedStatement.setLong(4, bean.getAdhaarNumber());
								PreparedStatement.setLong(5, bean.getPanNumber());
								PreparedStatement.setLong(6, bean.getAppId());

								score = PreparedStatement.executeUpdate();

								if (bean.getAppId() == 0) {
									return true;
								}

							}

						} else {
							throw new DataNotFoundException("entered app id deosn't  exits");
						}

					}
				}
			}
		} catch (MySQLTransactionRollbackException e) {

			e.printStackTrace();
		}

		if (score != 0) {
			return true;
		} else {
			log.info("entered application id doesn't exist in database");
			return false;
		}

	}
}
