package com.jsfsfeb.homeloanprocessings.dao;

import com.jsfsfeb.homeloanprocessings.dto.AppStatusInfoBeans;
 
public interface AppStatusDAO {
	
	public AppStatusInfoBeans getAppStatusByLoanId(long id);

}
