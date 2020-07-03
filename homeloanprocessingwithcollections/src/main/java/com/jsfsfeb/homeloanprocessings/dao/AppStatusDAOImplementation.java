package com.jsfsfeb.homeloanprocessings.dao;

import com.jsfsfeb.homeloanprocessings.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessings.exceptions.DataNotFoundException;
import com.jsfsfeb.homeloanprocessings.repository.RepositoryStorage;
 
public class AppStatusDAOImplementation implements AppStatusDAO {

	public AppStatusInfoBeans getAppStatusByLoanId(long id) {
		for (AppStatusInfoBeans a : RepositoryStorage.dataOfAppStatus()) {
			if (a.getAppId() == id) {

				return a;
			}
		}
	 	throw new DataNotFoundException("entered id is invalid");
		 
		 
	}

}
