package com.capgemini.homeloanprocessinginjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.homeloanprocessinginjdbc.dto.AppStatusInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.CustomerInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.EmployeeInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.LoansInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.utility.Utility;

public class UserDAOImplementation implements UserDAO {

	/////////////////// userlogin ///////////////////////
	int rescreate = 0;
	EmployeeInfoBeans employeeInfoBeans = new EmployeeInfoBeans();
	Utility utility = new Utility();

	public Boolean userLogin(EmployeeInfoBeans bean) throws SQLException {
		try (Connection concreate = utility.getConnection()) {
			try (Statement stmtcreate1 = concreate.createStatement()) {
				try (ResultSet res = stmtcreate1.executeQuery(utility.getQuery("getlogindetails"))) {
					while (res.next()) {

						if (res.getString("email").equals(bean.getEmail())) {

							return true;
						}
						if (res.getString("password").equals(bean.getPassword())) {

							return true;
						}
					}
				}
			}

		}
		return false;
	}

	////////////////////////////////////////// delete by id
	////////////////////////////////////////// ///////////////////////////

	int resdelete = 0;
	CustomerInfoBeans customerInfoBeans = new CustomerInfoBeans();

	public Boolean removeCustomerInfoByName(String name) throws SQLException {
		try (Connection condelete = utility.getConnection()) {
			try (PreparedStatement stmtdelete = condelete.prepareStatement(utility.getQuery("deletecustomerbyname"));) {
				stmtdelete.setString(1, name);
				resdelete = stmtdelete.executeUpdate();
			}
		}
		if (resdelete != 0) {
			return true;
		} else {
			return false;
		}

	}

	/////////////// retrive customer detailes by name ///////////
	ResultSet ressget = null;
	CustomerInfoBeans customerInfoBean = new CustomerInfoBeans();

	public CustomerInfoBeans retriveAllCustomerInfoByName(String name) throws SQLException {
		CustomerInfoBeans customerInfoBean = new CustomerInfoBeans();
		try (Connection conget = utility.getConnection()) {
			try (PreparedStatement stmtget = conget.prepareStatement(utility.getQuery("getcustomerbyname"))) {
				stmtget.setString(1, name);
				ressget = stmtget.executeQuery();
				if (ressget.next()) {
					customerInfoBean.setAppId(ressget.getLong("appId"));
					customerInfoBean.setCustomerName(ressget.getString("customerName"));
					customerInfoBean.setEmail(ressget.getString("email"));
					customerInfoBean.setLoanId(ressget.getLong("loanId"));
					customerInfoBean.setAdhaarNumber(ressget.getLong("adhaarNumber"));
					customerInfoBean.setPanNumber(ressget.getLong("panNumber"));
				}
				if (customerInfoBean.getAppId() == 0) {
					return null;
				}
			}
		} finally {
			try {
				if (ressget != null) {
					ressget.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return customerInfoBean;
	}

	////////////////////////////////// retrive detailes by serial
	////////////////////////////////// ///////////////////
	CustomerInfoBeans beans = new CustomerInfoBeans();

	public CustomerInfoBeans retriveAllCustomerInfoBySerial() throws SQLException {
		try (Connection connect = utility.getConnection()) {
			try (Statement statement = connect.createStatement()) {
				try (ResultSet set = statement.executeQuery(utility.getQuery("getcustomerapp"))) {
					while (set.next()) {
						beans.setAppId(set.getLong("appId"));
						beans.setCustomerName(set.getString("customerName"));
						beans.setEmail(set.getString("email"));
						beans.setLoanId(set.getLong("loanId"));
						beans.setAdhaarNumber(set.getLong("adhaarNumber"));
						beans.setPanNumber(set.getLong("panNumber"));
						return beans;
					}
				}
			}
		}
		return beans;
	}

	/////////////////////////// retrive all detailes of customer
	/////////////////////////// ////////////////////////////////

	public List<CustomerInfoBeans> retriveAllCustomerInfo() throws SQLException {
		List<CustomerInfoBeans> list = new ArrayList<CustomerInfoBeans>();
		try (Connection Connection = utility.getConnection()) {
			try (Statement Statement = Connection.createStatement()) {
				try (ResultSet ResultSet = Statement.executeQuery(utility.getQuery("getcustomerapp"))) {
					while (ResultSet.next()) {
						CustomerInfoBeans bean = new CustomerInfoBeans();
						bean.setAppId(ResultSet.getLong("appId"));
						bean.setCustomerName(ResultSet.getString("customerName"));
						bean.setEmail(ResultSet.getString("email"));
						bean.setLoanId(ResultSet.getLong("loanId"));
						bean.setAdhaarNumber(ResultSet.getLong("adhaarNumber"));
						bean.setPanNumber(ResultSet.getLong("panNumber"));
						list.add(bean);
					}
				}
			}
		} finally {

		}
		return list;

	}

	/////////////////////////// remove loan info by id
	/////////////////////////// ///////////////////////////////////
	int r1 = 0;
	LoansInfoBeans infoBeans = new LoansInfoBeans();

	public Boolean removeLoanInfoById(long id) throws SQLException {
		try (Connection c1 = utility.getConnection()) {
			try (PreparedStatement s1 = c1.prepareStatement(utility.getQuery("deleteloanbyid"))) {
				s1.setLong(1, id);

				r1 = s1.executeUpdate();
			}
		}
		if (r1 != 0) {
			return true;
		} else {
			return false;
		}

	}

	//////////////// update app status by id ////////////////////////
	int resupdate = 0;
	LoansInfoBeans loansInfoBeans = new LoansInfoBeans();

	public Boolean updateLoanAppStatusInfoById(AppStatusInfoBeans app) throws SQLException {
		try (Connection conupdate = utility.getConnection()) {
			try (Statement state4 = conupdate.createStatement()) {
				try (PreparedStatement stmtupdate = conupdate
						.prepareStatement(utility.getQuery("updateloanstatusbyid"))) {
					stmtupdate.setString(1, app.getAcceptedOrRejected());
					if (app.getDateOfInterview() == null) {
						System.out.println("nikhil ur correct");
						stmtupdate.setInt(2, 0);
					} else {
						stmtupdate.setDate(2, java.sql.Date.valueOf(app.getDateOfInterview()));
					}
					stmtupdate.setString(3, app.getApprovedOrRejected());
					stmtupdate.setLong(4, app.getAppId());
					resupdate = stmtupdate.executeUpdate();
					if (app.getAppId() == 0) {
						return true;
					}
				}
			}
		} finally {

		}

		if (resupdate != 0) {
			return true;
		} else {
			return false;
		}

	}

}
