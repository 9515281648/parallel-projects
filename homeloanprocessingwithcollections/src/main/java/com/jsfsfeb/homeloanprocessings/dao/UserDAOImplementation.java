package com.jsfsfeb.homeloanprocessings.dao;

import java.util.List;

import com.jsfsfeb.homeloanprocessings.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.EmployeeInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.LoansInfoBeans;
import com.jsfsfeb.homeloanprocessings.exceptions.DataNotFoundException;
import com.jsfsfeb.homeloanprocessings.repository.RepositoryStorage;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserDAOImplementation implements UserDAO {

	public Boolean userLogin(EmployeeInfoBeans bean) {

		for (EmployeeInfoBeans bean1 : RepositoryStorage.dataOfEmployee()) {

			if ((bean1.getEmail().equalsIgnoreCase(bean.getEmail()))) {

				return true;
			}
			if ((bean1.getPassword().equalsIgnoreCase(bean.getPassword()))) {

				return true;
			}
		}

		return false;

	}

	@SuppressWarnings("unused")
	public Boolean removeCustomerInfoByName(String nam) {
		for (CustomerInfoBeans b1 : RepositoryStorage.dataOfCustomer()) {
			if (b1.getCustomerName().equals(nam)) {
				log.info("found data");
				for (int i = 0; i < RepositoryStorage.customer.size() - 1; i++) {
					RepositoryStorage.customer.remove(i);

					return true;
				}

			}

		}

		return false;
	}

	public CustomerInfoBeans retriveAllCustomerInfoByName(String name) {

		for (CustomerInfoBeans b1 : RepositoryStorage.dataOfCustomer()) {
			if (b1.getCustomerName().equals(name)) {
				return b1;
			}
		}
		throw new DataNotFoundException("entered name is not found in database ");
	}

	public CustomerInfoBeans retriveAllCustomerInfoBySerial() {

		for (CustomerInfoBeans b1 : RepositoryStorage.dataOfCustomer()) {
			return b1;
		}
		return null;
	}

	public List<CustomerInfoBeans> retriveAllCustomerInfo() {
		

		return RepositoryStorage.dataOfCustomer();

	}

	public Boolean removeLoanInfoById(long id) {
		for (LoansInfoBeans lo : RepositoryStorage.dataOfLoan()) {
			if (lo.getLoanId() == id) {
				RepositoryStorage.dataOfLoan().remove(lo);
				return true;
			}
		}
		return false;
	}

	public Boolean updateLoanAppStatusInfoById(AppStatusInfoBeans app) {

		for (AppStatusInfoBeans a : RepositoryStorage.dataOfAppStatus()) {

			if (a.getAppId() == app.getAppId()) {
				RepositoryStorage.status.add(app);
				return true;

			}

		}

		if (app.getAcceptedOrRejected() != null) {
			return true;
		}

		if (app.getApprovedOrRejected() != null) {
			return true;
		}

		if (app.getDateOfInterview() != null) {
			return true;
		}

	 
		throw new DataNotFoundException("entered app id is not present in the database");
		 
	}

	 
	 

}
