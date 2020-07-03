package com.jsfsfeb.homeloanprocessings.dao;

 import java.util.List;

import com.jsfsfeb.homeloanprocessings.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.EmployeeInfoBeans;
 

public interface UserDAO {

	public Boolean userLogin(EmployeeInfoBeans bean);
   
	public Boolean removeCustomerInfoByName(String name);

	public CustomerInfoBeans retriveAllCustomerInfoByName(String name);

	public CustomerInfoBeans retriveAllCustomerInfoBySerial();

	public List<CustomerInfoBeans> retriveAllCustomerInfo();

	public Boolean removeLoanInfoById(long id);

	public Boolean updateLoanAppStatusInfoById(AppStatusInfoBeans app);

}
