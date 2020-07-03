package com.jsfsfeb.homeloanprocessingjpawithhibernates.controller;

import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.AppStatusInfoBeansDublicat;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.CustomerInfoDublicate;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.EmployeeInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.EmployeeInfoBeansDublicate;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.LoansInfoBeans;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.dto.LoansInfoBeansDublicat;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.exceptions.DataNotFoundException;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.factory.Factory;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.services.ServiceDAO;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.validations.AppStatusValidations;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.validations.CustomerValidations;
import com.jsfsfeb.homeloanprocessingjpawithhibernates.validations.LoanValidations;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdminControll {
	int result = 10;
	Boolean flag = false;

	long appId = 0;
	String customerName = null;
	String email = null;
	long loanId = 0;
	long adhaarNumber = 0;
	long panNumber = 0;

	String password = null;
	Scanner Scanner = new Scanner(System.in);
	long appIds = 0;
	String acceptedOrRejected = null;
	//String dateOfInterview = null;
LocalDate	dateOfInterview = null ;
	String approvedOrRejected = null;

	long loanIds = 0;
	String loanName = null;
	long loanAmount = 0;
	long minimumEmi = 0;
	long setEmi = 0;
	CustomerInfoBeans beans = Factory.customerInstance();
	CustomerValidations validation = Factory.customerValidationsInstance();
	LoanValidations LoanValidation = Factory.loanValidationsInstance();
	AppStatusValidations ApplicationValidation = Factory.appStatusValidationsInstance();

	 
	ServiceDAO ServiceDao = Factory.ServiceDAOInstance();
	EmployeeInfoBeans login = null;
	CustomerInfoBeans con = null;

	public void mainAdmin() throws SQLException

	{

		log.info(
				"-----------------------------------------------------login please---------------------------------------------");
		log.info("press 1 for admin login ");
		log.info(
				"--------------------------------------------------------------------------------------------------------------");
		log.info("press 2 for main  category");
		int choice = Scanner.nextInt();

		switch (choice) {

		case 1:
			 

			do {
EmployeeInfoBeansDublicate dublicate = new EmployeeInfoBeansDublicate();
EmployeeInfoBeans bean1 = new EmployeeInfoBeans();
				do {

					EmployeeInfoBeans bean = Factory.employeeInstance();

					log.info("Enter the email :");
					  email = Scanner.next();
					bean1.setEmail(email);

					flag = ServiceDao.userLogin(bean1);
					if (flag == false) {
						log.info("email id is not correct");
					}

				} while (flag == false);
				dublicate.setEmaild(email);

				do {
					EmployeeInfoBeans bean = Factory.employeeInstance();
					log.info("enter the password");
					password = Scanner.next();
					bean.setPassword(password);
					flag = ServiceDao.userLogin(bean);

					 

				} while (!flag);
				
				dublicate.setPasswordd(password);
				bean1.setEmail(dublicate.getEmaild());
				bean1.setPassword(dublicate.getPasswordd());
				flag = ServiceDao.userLogin(bean1);
				if (flag == true) {
					log.info("Admin login successfully done");

					admin();

				}
				 

			} while (flag == false);// case 1 do block

			break;
		case 2:

			break;

		default:
			log.info("can accept only positive integers 1,2");

			log.info("presults 0 to go back");
			int result = Scanner.nextInt();
			if (result == 0) {
				mainAdmin();
			} else {
				log.info("can accept only positive integers 1,2");

				log.info("presults 0 to go back");
				int result1 = Scanner.nextInt();
				if (result1 == 0) {
					mainAdmin();
				}
			}

			break;

		}

	}

	void admin() throws SQLException {

		log.info("-----------------------Functionalities of admin-------------------------------------");
		log.info("press 1 for remove   details of     customer     by name ");
		log.info("--------------------------------------------------------------------------------------");
		log.info("press 2 for update   details of     cudtomer     by name");
		log.info("--------------------------------------------------------------------------------------");
		log.info("press 3 for retrive  details of     customer     by name ");
		log.info("--------------------------------------------------------------------------------------");
		log.info("press 4 for adding   new     loans");
		log.info("--------------------------------------------------------------------------------------");
		log.info("press 5 for remove   details of loan by          loanIds");
		log.info("--------------------------------------------------------------------------------------");
		log.info("press 6 for update   details of loan application status by appIds");
		log.info("--------------------------------------------------------------------------------------");
		 
		log.info("press 7 for main     category ");

		int choice1 = Scanner.nextInt();

		switch (choice1) {
		case 1:
			do {

				do {
					try {
						log.info("enter the customer name");
						String name = Scanner.next();

						flag = ServiceDao.removeCustomerInfoByName(name);
						if (flag == true) {
							log.info("--------------------------------------------------------------------------");
							log.info("successfully deleted the details of the customer by the name : " + name);
							log.info(
									"-------------------------------next operation-----------------------------------");
							log.info("press 0 to go back");
							int result = Scanner.nextInt();
							if (result == 0) {
								admin();
							}
						}  

					} catch (InputMismatchException e) {
						flag = false;
						System.err.println("Id should contains 3 characters and all alphabits  ");
					} catch (DataNotFoundException e) {
						flag = false;
						System.err.println(e.getMessage());
					}

				} while (flag == false);

			} while (flag);

			break;

		case 2:
			do {
				CustomerInfoDublicate dublicate = new CustomerInfoDublicate();

				do {
					CustomerInfoBeans bean1 = Factory.customerInstance();
					log.info("Enter application id :");
					appId = Scanner.nextLong();

					bean1.setAppId(appId);

					flag = ServiceDao.customerApplicationUpdate(bean1);

				} while (!flag);
				dublicate.setAppIdd(appId);
				do {

					CustomerInfoBeans bean2 = Factory.customerInstance();
					log.info("Enter email  id :");
					email = Scanner.next();

					bean2.setEmail(email);
					flag = ServiceDao.customerApplicationUpdate(bean2);

				} while (!flag);
				dublicate.setEmaild(email);
				do {

					CustomerInfoBeans bean2 = Factory.customerInstance();
					log.info("Enter loan  id :");
					loanId = Scanner.nextLong();

					bean2.setLoanId(loanId);
					flag = ServiceDao.customerApplicationUpdate(bean2);

				} while (!flag);
				dublicate.setLoanIdd(loanId);
				do {

					CustomerInfoBeans bean2 = Factory.customerInstance();
					log.info("Enter adhaar  number :");
					adhaarNumber = Scanner.nextLong();

					bean2.setAdhaarNumber(adhaarNumber);
					flag = ServiceDao.customerApplicationUpdate(bean2);

				} while (!flag);
				dublicate.setAdhaarNumberd(adhaarNumber);
				do {

					CustomerInfoBeans bean2 = Factory.customerInstance();
					log.info("Enter pan number  ");
					panNumber = Scanner.nextLong();

					bean2.setPanNumber(panNumber);
					flag = ServiceDao.customerApplicationUpdate(bean2);

				} while (!flag);
				dublicate.setPanNumberd(panNumber);
				do {

					CustomerInfoBeans bean0 = Factory.customerInstance();
					log.info("Enter full name :");
					customerName = Scanner.next();

					bean0.setCustomerName(customerName);

					flag = ServiceDao.customerApplicationUpdate(bean0);

				} while (!flag);
				dublicate.setCustomerNamed(customerName);
				CustomerInfoBeans beans = new CustomerInfoBeans();
				beans.setAppId(dublicate.getAppIdd());
				beans.setCustomerName(dublicate.getCustomerNamed());
				beans.setEmail(dublicate.getEmaild());
				beans.setLoanId(dublicate.getLoanIdd());
				beans.setAdhaarNumber(dublicate.getAdhaarNumberd());
				beans.setPanNumber(dublicate.getPanNumberd());
			flag =	ServiceDao.customerApplicationUpdate(beans);
				if (flag == true) {

					log.info("------------------------------------------------------------------------");
					log.info("Customer details successfully updated by the name : " + customerName);
					log.info("-------------------------------next operation-----------------------------------");
					log.info("presults 0 to go back");
					int result = Scanner.nextInt();
					if (result == 0) {
						admin();
					}

				} else {
					log.info("there is no data with these name " + customerName);
					log.info("-------------------------------next operation-----------------------------------");
					log.info("presults 0 to go back");
					int result = Scanner.nextInt();
					if (result == 0) {
						admin();
					}
				}

			} while (flag);

			break;

		case 3:
			do {

				do {

					log.info("enter the customer  name ");
					String name = Scanner.next();

					con = ServiceDao.retriveAllCustomerInfoByName(name);

				} while (con == null);

				if (con != null) {
					 
					log.info(
							"-------------------------------------------Access gained successfully-----------------------------------------");
					log.info("appIds          ===========>    " + con.getAppId());
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("customer name   ===========>    " + con.getCustomerName());
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("customer email  ===========>    " + con.getEmail());
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("loanIds         ===========>    " + con.getLoanId());
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("adhaar id       ===========>    " + con.getAdhaarNumber());
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("pan id          ===========>    " + con.getPanNumber());
					log.info("---------------------------next operations -----------------------------");
					log.info("press 0 to go back");
					int result = Scanner.nextInt();
					if (result == 0) {
						admin();
					}

				} else {
					log.info("name not matched in database ");
					log.info("---------------------------next operations -----------------------------");
					log.info("press 0 to go back");
					int result = Scanner.nextInt();
					if (result == 0) {
						admin();
					}
				}

			} while (con == null);
			break;

		case 4:
			do {
				LoansInfoBeansDublicat dublicate = new LoansInfoBeansDublicat();
				do {

					LoansInfoBeans Loans = Factory.loansInstance();
					log.info("Enter loan name :");
					loanName = Scanner.next();
					Loans.setLoanName(loanName);
					flag = ServiceDao.addLoan(Loans);

				} while (flag == false);
				dublicate.setLoanNamed(loanName);

				do {

					LoansInfoBeans Loans = Factory.loansInstance();
					log.info("Enter loan amount :");
					loanAmount = Scanner.nextInt();
					Loans.setLoanAmount(loanAmount);
					flag = ServiceDao.addLoan(Loans);

				} while (flag == false);
				dublicate.setLoanAmountd(loanAmount);

				do {
					LoansInfoBeans Loans = Factory.loansInstance();
					log.info("Enter loan minimum emi :");
					minimumEmi = Scanner.nextInt();
					Loans.setMinimumEmi(minimumEmi);
					flag = ServiceDao.addLoan(Loans);

				} while (flag == false);
				dublicate.setMinimumEmid(minimumEmi);

				do {
					LoansInfoBeans Loans = Factory.loansInstance();
					log.info("Enter emi amount to set  :");
					setEmi = Scanner.nextInt();
					Loans.setSetEmi(setEmi);
					flag = ServiceDao.addLoan(Loans);
				} while (flag == false);
				dublicate.setSetEmid(setEmi);
				do {

					LoansInfoBeans Loans = Factory.loansInstance();
					log.info("Enter loan ID :");
					loanIds = Scanner.nextInt();
					Loans.setLoanId(loanIds);
					flag = ServiceDao.addLoan(Loans);

				} while (flag == false);
				
				dublicate.setLoanIdd(loanIds);
				LoansInfoBeans infoBeans = new LoansInfoBeans();
				infoBeans.setLoanId(dublicate.getLoanIdd());
				infoBeans.setLoanName(dublicate.getLoanNamed());
				infoBeans.setLoanAmount(dublicate.getLoanAmountd());
				infoBeans.setMinimumEmi(dublicate.getMinimumEmid());
				infoBeans.setSetEmi(dublicate.getSetEmid());
				  flag =	ServiceDao.addLoan(infoBeans);
				if (flag == true) {
					log.info("--------------------------------------------------------------");
					log.info("Successfully added the loan ");
					log.info("---------------------------next operations -----------------------------");
					log.info("press 0 to go back");
					int result = Scanner.nextInt();
					if (result == 0) {
						admin();
					}
				}else {
					log.info("invalid loan id");
					log.info("---------------------------next operations -----------------------------");
					log.info("press 0 to go back");
					int result = Scanner.nextInt();
					if (result == 0) {
						admin();
					}
				}

			} while (!flag);

			break;

		case 5:
			do {

				do {

					log.info("Enter loan  id :");
					loanIds = Scanner.nextInt();

					flag = ServiceDao.removeLoanInfoById(loanIds);

				} while (flag == false);

				if (flag == true) {
					log.info("-----------------------------------------------------------");
					log.info("loan         Successfully        deleted");
					log.info("---------------------------next operations -----------------------------");
					log.info("press        0 to go back");
					int result = Scanner.nextInt();
					if (result == 0) {
						admin();
					}
				}

			} while (!flag);
			break;

		case 6:
			do {
AppStatusInfoBeansDublicat dublicate = new AppStatusInfoBeansDublicat();
				 
				do {

					AppStatusInfoBeans AppStatusInfoBeans = Factory.applicationStatusInstance();
					log.info("Enter app  accepted or rejected or null :");
					acceptedOrRejected = Scanner.next();
					AppStatusInfoBeans.setAcceptedOrRejected(acceptedOrRejected);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);

				} while (!flag);
				dublicate.setAcceptedOrRejectedd(acceptedOrRejected);

				do {
					try {	
					AppStatusInfoBeans AppStatusInfoBeans = Factory.applicationStatusInstance();
					log.info("Enter interview date    : ");
					dateOfInterview = LocalDate.of(Scanner.nextInt(), Scanner.nextInt(), Scanner.nextInt());
					
					
					
					AppStatusInfoBeans.setDateOfInterview(dateOfInterview);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);
					} catch (DateTimeException e) {
						flag = false;
						System.err.println("enter the correct date  ");
					} catch (DataNotFoundException e) {
						flag = false;
						System.err.println(e.getMessage());
					}
					

				} while (!flag);
				dublicate.setDateOfInterviewd(dateOfInterview);

				do {

					AppStatusInfoBeans AppStatusInfoBeans = Factory.applicationStatusInstance();
					log.info("Enter approved or rejected   : ");
					approvedOrRejected = Scanner.next();
					AppStatusInfoBeans.setApprovedOrRejected(approvedOrRejected);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);

				} while (!flag);
				dublicate.setApprovedOrRejectedd(approvedOrRejected);
				do {

					AppStatusInfoBeans AppStatusInfoBeans = Factory.applicationStatusInstance();
					log.info("Enter app  id :");
					appId = Scanner.nextInt();

					AppStatusInfoBeans.setAppId(appId);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);

				} while (!flag);
				dublicate.setAppIdd(appId);
				AppStatusInfoBeans bean = Factory.applicationStatusInstance();
				bean.setAppId(dublicate.getAppIdd());
				bean.setAcceptedOrRejected(dublicate.getAcceptedOrRejectedd());
				bean.setDateOfInterview(dublicate.getDateOfInterviewd());
				bean.setApprovedOrRejected(dublicate.getApprovedOrRejectedd());
				flag = ServiceDao.updateLoanAppStatusInfoById(bean);

				if (flag == true) {
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("Loan Application Status Updated Successfully");
					log.info(
							"---------------------------------------next operations --------------------------------------------------------");
					log.info("press 0 to go back");
					int result = Scanner.nextInt();
					if (result == 0) {
						admin();
					}
				} else {
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("entered application number is invalid");
				}
			} while (!flag);
			break;

		 		case 7:

			break;

			
			
		default:

			log.info("can accept only positive integers 1,2,3,4,5,6,7");
			do {
				log.info("---------------------------next operations -----------------------------");
				log.info("press 0 to go back");
				result = Scanner.nextInt();
				if (result == 0) {
					admin();
				}

				break;

			} while (result != 10);

		}

	}

}
