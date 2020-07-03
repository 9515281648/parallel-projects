package com.capgemini.homeloanprocessinginjdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.homeloanprocessinginjdbc.dto.LoansInfoBeans;

public interface LoanDAO {
	
	public Boolean addLoan(LoansInfoBeans bean) throws SQLException;

	public  List<LoansInfoBeans> retriveLoanDetails() throws SQLException;

	public LoansInfoBeans retriveLoanDetailsById(long id ) throws SQLException;

	public Boolean setEmiByLoanId(long id, long emi) throws SQLException;

}
