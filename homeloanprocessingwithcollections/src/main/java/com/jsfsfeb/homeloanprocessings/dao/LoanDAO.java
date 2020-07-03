package com.jsfsfeb.homeloanprocessings.dao;

import java.util.List;

import com.jsfsfeb.homeloanprocessings.dto.LoansInfoBeans;

public interface LoanDAO {

	public Boolean addLoan(LoansInfoBeans bean);

	public  List<LoansInfoBeans> retriveLoanDetails();

	public LoansInfoBeans retriveLoanDetailsById(long id);

	public Boolean setEmiByLoanId(long id, long emi);

}
