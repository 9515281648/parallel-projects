package com.jsfsfeb.homeloanprocessings.services;

 import java.util.List;

import com.jsfsfeb.homeloanprocessings.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.EmployeeInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.LoansInfoBeans;

public interface ServiceDAO {

	public Boolean userLogin( EmployeeInfoBeans bean);

	public boolean customerApplication(CustomerInfoBeans b1);

	public Boolean removeCustomerInfoByName(String name);

	public CustomerInfoBeans retriveAllCustomerInfoByName(String name);

	public CustomerInfoBeans retriveAllCustomerInfoBySerial();

	public  List<LoansInfoBeans> retriveLoanDetails();

	public AppStatusInfoBeans getAppStatusByLoanId(long id);

	public LoansInfoBeans retriveLoanDetailsById(long id);

	public Boolean setEmiByLoanId(long id, long emi);

	public List<CustomerInfoBeans> retriveAllCustomerInfo();

	public Boolean addLoan(LoansInfoBeans bean);

	public Boolean removeLoanInfoById(long id);

	public Boolean updateLoanAppStatusInfoById(AppStatusInfoBeans app);
	
	 
}
