package com.jsfsfeb.homeloanprocessings.dao;

import java.util.List;

import com.jsfsfeb.homeloanprocessings.dto.LoansInfoBeans;
import com.jsfsfeb.homeloanprocessings.repository.RepositoryStorage;

public class LoanDAOImplementation implements LoanDAO {

	public Boolean addLoan(LoansInfoBeans bean) {
		for (LoansInfoBeans l : RepositoryStorage.dataOfLoan()) {
			if (l.getLoanId() == bean.getLoanId()) {
				return true;
			}
		}
		RepositoryStorage.loan.add(bean);
		return true;
	}

	@SuppressWarnings("unused")
	public List<LoansInfoBeans> retriveLoanDetails() {
		for (LoansInfoBeans l : RepositoryStorage.dataOfLoan()) {
		for (int i = 0; i < RepositoryStorage.loan.size() - 1; i++) {
			RepositoryStorage.loan.get(i);

		}

		return RepositoryStorage.loan;
		}
		
		return null;
		
	}

	public LoansInfoBeans retriveLoanDetailsById(long id) {

		for (LoansInfoBeans lo : RepositoryStorage.dataOfLoan()) {
			if (lo.getLoanId() == id) {
				return lo;
			}
		}
		return null;

	}

	public Boolean setEmiByLoanId(long id, long emi) {
		for (LoansInfoBeans l : RepositoryStorage.dataOfLoan()) {
			if (l.getLoanId() == id) {
				l.setSetEmi(emi);

				return true;
			}
		}
		return false;
	}

}
