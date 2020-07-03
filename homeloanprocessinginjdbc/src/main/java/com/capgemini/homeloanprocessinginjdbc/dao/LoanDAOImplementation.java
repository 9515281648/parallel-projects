package com.capgemini.homeloanprocessinginjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.homeloanprocessinginjdbc.dto.AppStatusInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.LoansInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.utility.Utility;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoanDAOImplementation implements LoanDAO {

	int rescreate = 0;
	LoansInfoBeans loansInfoBeans = new LoansInfoBeans();
	Utility utility = new Utility();

	public Boolean addLoan(LoansInfoBeans bean) throws SQLException {

		try (Connection concreate = utility.getConnection()) {
			try (Statement stmtcreate1 = concreate.createStatement()) {
				try (ResultSet res = stmtcreate1.executeQuery(utility.getQuery("getallloandetails"))) {

					while (res.next()) {
						if (res.getLong("loanId") != bean.getLoanId()
								|| res.getLong("loanAmount") != bean.getLoanAmount()
								|| res.getLong("minimumEmi") != bean.getMinimumEmi()
								|| res.getString("loanName").equals(bean.getLoanName())) {

							try (PreparedStatement stmtcreate = concreate
									.prepareStatement(utility.getQuery("addloan"))) {

								stmtcreate.setLong(1, bean.getLoanId());
								stmtcreate.setString(2, bean.getLoanName());
								stmtcreate.setLong(3, bean.getLoanAmount());
								stmtcreate.setLong(4, bean.getMinimumEmi());
								stmtcreate.setLong(5, bean.getSetEmi());

								rescreate = stmtcreate.executeUpdate();

								if (bean.getLoanId() == 0 || bean.getLoanName() == null || bean.getLoanAmount() == 0
										|| bean.getMinimumEmi() == 0 || bean.getSetEmi() == 0) {
									try (PreparedStatement stmtcreate2 = concreate
											.prepareStatement(utility.getQuery("deleteloan"))) {

										stmtcreate2.executeUpdate();
									}
								}

								if (bean.getLoanId() == 0) {
									return true;
								}

							}

						}
					}

				}
			}
		} finally {
		}

		if (rescreate != 0) {
			return true;
		} else {
			log.info("entered id is already exist");
			return false;
		}

	}

	////////////////// retrive loans by id//////////////////////////////////

	AppStatusInfoBeans appStatusInfoBeans = new AppStatusInfoBeans();

	public List<LoansInfoBeans> retriveLoanDetails() throws SQLException {
		List<LoansInfoBeans> infoBeans = new ArrayList<LoansInfoBeans>();

		try (Connection conget = utility.getConnection()) {
			try (Statement stmt = conget.createStatement()) {
				try (ResultSet result = stmt.executeQuery(utility.getQuery("getallloandetails"))) {

					while (result.next()) {
						LoansInfoBeans loansInfoBeans = new LoansInfoBeans();
						loansInfoBeans.setLoanId(result.getLong("loanId"));
						loansInfoBeans.setLoanName(result.getString("loanName"));
						loansInfoBeans.setLoanAmount(result.getLong("loanAmount"));
						loansInfoBeans.setMinimumEmi(result.getLong("minimumEmi"));
						loansInfoBeans.setSetEmi(result.getLong("setEmi"));

						infoBeans.add(loansInfoBeans);

					}
				}
			}
		} finally {

		}
		return infoBeans;

	}

	/////////////////////// get loan by id ////////////

	ResultSet results = null;
	LoansInfoBeans loans = new LoansInfoBeans();

	public LoansInfoBeans retriveLoanDetailsById(long id) throws SQLException {
		try (Connection con = utility.getConnection()) {
			try (PreparedStatement stmtget = con.prepareStatement(utility.getQuery("getloanbyid"));) {
				stmtget.setLong(1, id);

				results = stmtget.executeQuery();

				if (results != null) {

					if (results.next()) {
						loans.setLoanId(results.getLong("loanId"));
						loans.setLoanName(results.getString("loanName"));
						loans.setLoanAmount(results.getLong("loanAmount"));
						loans.setMinimumEmi(results.getLong("minimumEmi"));
						loans.setSetEmi(results.getLong("setEmi"));
					}
				} else {
					throw new com.capgemini.homeloanprocessinginjdbc.exceptions.DataNotFoundException(
							"entered loan id is invalid");
				}
			}
		} finally {

			try {
				if (results != null) {
					results.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return loans;

	}

	int resupdate = 0;

	public Boolean setEmiByLoanId(long id, long emi) throws SQLException {

		try (Connection conupdate = utility.getConnection()) {
			try (PreparedStatement stmtupdate = conupdate.prepareStatement(utility.getQuery("updateloanbyid"))) {

				stmtupdate.setLong(1, emi);
				stmtupdate.setLong(2, id);
				resupdate = stmtupdate.executeUpdate();

				if (resupdate != 0) {
					return true;
				} else {
					return false;
				}

			}
		}

	}

}
