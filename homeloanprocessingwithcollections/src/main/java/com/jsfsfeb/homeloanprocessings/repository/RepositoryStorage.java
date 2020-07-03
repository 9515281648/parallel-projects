package com.jsfsfeb.homeloanprocessings.repository;

import java.util.ArrayList;
import java.util.List;

import com.jsfsfeb.homeloanprocessings.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.EmployeeInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.LoansInfoBeans;

public class RepositoryStorage {

	public static final  List<CustomerInfoBeans> customer = new ArrayList<CustomerInfoBeans>();

	public static final  List<EmployeeInfoBeans> employee = new ArrayList<EmployeeInfoBeans>();

	public static final List<LoansInfoBeans> loan = new ArrayList<LoansInfoBeans>();

	public static final  List<AppStatusInfoBeans> status = new ArrayList<AppStatusInfoBeans>();
 
	public static  List<AppStatusInfoBeans> dataOfAppStatus() {
		AppStatusInfoBeans bean = new AppStatusInfoBeans();
		bean.setAppId(12121);
		bean.setAcceptedOrRejected("accepted");
		bean.setDateOfInterview( "1-2-2020");
		bean.setApprovedOrRejected("Approved");
		status.add(bean);
		
		
		AppStatusInfoBeans bean1 = new AppStatusInfoBeans();
		bean1.setAppId(12122);
		bean1.setAcceptedOrRejected("accepted");
		bean1.setDateOfInterview( "1-2-2021");
		bean1.setApprovedOrRejected("null");
		status.add(bean1);
		
		AppStatusInfoBeans bean2 = new AppStatusInfoBeans();
		bean2.setAppId(12123);
		bean2.setAcceptedOrRejected("accepted");
		bean2.setDateOfInterview( "12-1-2021");
		bean2.setApprovedOrRejected("Rejected");
		status.add(bean2);
		
		
		AppStatusInfoBeans bean3 = new AppStatusInfoBeans();
		bean3.setAppId(12124);
		bean3.setAcceptedOrRejected("Rejected");
		bean3.setDateOfInterview( "null");
		bean3.setApprovedOrRejected("null");
		status.add(bean3);

		return status;
	}

	 
	public static  List<CustomerInfoBeans> dataOfCustomer() {
		CustomerInfoBeans bean = new CustomerInfoBeans();
		
		bean.setAppId(1);
		bean.setCustomerName("nikhil");
		bean.setEmail("nikhil@gmail.com");
		bean.setLoanId(23);
		bean.setAdhaarNumber(34234);
		bean.setPanNumber(97453);
		customer.add(bean);
		
		
		CustomerInfoBeans bean1 = new CustomerInfoBeans();
		bean1.setAppId(2);
		bean1.setCustomerName("Mahesh");
		bean1.setEmail("Mahesh@gmail.com");
		bean1.setLoanId(2);
		bean1.setAdhaarNumber(98322);
		bean1.setPanNumber(43762);
		customer.add(bean1);
		
		
		CustomerInfoBeans bean2 = new CustomerInfoBeans();
		bean2.setAppId(3);
		bean2.setCustomerName("Surya");
		bean2.setEmail("Surya@gmail.com");
		bean2.setLoanId(3);
		bean2.setAdhaarNumber(98323);
		bean2.setPanNumber(98372);
		customer.add(bean2);
		
		
		CustomerInfoBeans bean3 = new CustomerInfoBeans();
		bean3.setAppId(4);
		bean3.setCustomerName("Vamshi");
		bean3.setEmail("Vamshi@gmail.com");
		bean3.setLoanId(7);
		bean3.setAdhaarNumber(76873);
		bean3.setPanNumber(83922);
		customer.add(bean3);
		
		return customer;
	}

	 
	public static  List<EmployeeInfoBeans> dataOfEmployee() {
		
		EmployeeInfoBeans bean = new EmployeeInfoBeans();
		bean.setUserName("Krishna Mohan");
		bean.setEmail("krishna@gmail.com");
		bean.setMobileNumber(982432938);
		bean.setPassword("krishna00009");
		employee.add(bean);
		
		EmployeeInfoBeans bean1 = new EmployeeInfoBeans();
		bean1.setUserName("Ravindra Varma");
		bean1.setEmail("ravi@gmail.com");
		bean1.setMobileNumber(982349823);
		bean1.setPassword("Varma$123");
		employee.add(bean1);
		
		EmployeeInfoBeans bean2 = new EmployeeInfoBeans();
		bean2.setUserName("Savithri Devi");
		bean2.setEmail("savi@gmail.com");
		bean2.setMobileNumber(934628233);
		bean2.setPassword("devi7501");
		employee.add(bean2);

		return employee;
	}

	 
	public static  List<LoansInfoBeans> dataOfLoan() {

		LoansInfoBeans bean =  new LoansInfoBeans();
		bean.setLoanId(12345);
		bean.setLoanName("Home Extension  Loan");
		bean.setLoanAmount(2500000);
		bean.setMinimumEmi(25000);
		bean.setSetEmi(25000);
		loan.add(bean);
		
		
		LoansInfoBeans bean1 =  new LoansInfoBeans(); 
		bean1.setLoanId(12346);
		bean1.setLoanName("Home Improvement Loan");
		bean1.setLoanAmount(3500000);
		bean1.setMinimumEmi(35000);
		bean1.setSetEmi(35000);
		loan.add(bean1);
		
		 
		LoansInfoBeans bean2 =  new LoansInfoBeans();
		bean2.setLoanId(12347);
		bean2.setLoanName("Land Purchase  Loan");
		bean2.setLoanAmount(1500000);
		bean2.setMinimumEmi(15000);
		bean2.setSetEmi(15000);
		loan.add(bean2);
		
	 
		LoansInfoBeans bean3 =  new LoansInfoBeans();
		bean3.setLoanId(12348);
		bean3.setLoanName("Home Purchase  Loan");
		bean3.setLoanAmount(4500000);
		bean3.setMinimumEmi(45000);
		bean3.setSetEmi(45000);
		loan.add(bean3);
		
		
		
		return loan;
	}

}
