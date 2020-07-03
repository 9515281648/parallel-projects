package com.jsfsfeb.homeloanprocessings.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.jsfsfeb.homeloanprocessings.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.EmployeeInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.LoansInfoBeans;
import com.jsfsfeb.homeloanprocessings.exceptions.DataNotFoundException;
import com.jsfsfeb.homeloanprocessings.factory.Factory;
import com.jsfsfeb.homeloanprocessings.services.ServiceDAO;
import com.jsfsfeb.homeloanprocessings.validations.AppStatusValidations;
import com.jsfsfeb.homeloanprocessings.validations.CustomerValidations;
import com.jsfsfeb.homeloanprocessings.validations.LoanValidations;

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

	long appIds = 0;
	String acceptedOrRejected = null;
	String dateOfInterview = null;
	String approvedOrRejected = null;

	long loanIds = 0;
	String loanName = null;
	long loanAmount = 0;
	long minimumEmi = 0;
	long setEmi = 0;
	CustomerInfoBeans beans =Factory.customerInstance();
	CustomerValidations validation =Factory.customerValidationsInstance();
	LoanValidations LoanValidation = Factory.loanValidationsInstance();
	AppStatusValidations ApplicationValidation = Factory.appStatusValidationsInstance();

	Scanner Scanner = new Scanner(System.in);
	ServiceDAO ServiceDao = Factory.ServiceDAOInstance();
	EmployeeInfoBeans login = null;
	CustomerInfoBeans con = null;

	public void mainAdmin()

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
		//	EmployeeInfoBeans bean = new EmployeeInfoBeans();

			do {

				do {

					EmployeeInfoBeans bean1 = Factory.employeeInstance();

					log.info("Enter the email :");
					String email = Scanner.next();
					bean1.setEmail(email);

					flag = ServiceDao.userLogin(bean1);
					if (flag == false) {
						log.info("email id is not correct");
					}

				} while (flag == false);

				do {
					EmployeeInfoBeans bean = Factory.employeeInstance();
					log.info("enter the password");
					password = Scanner.next();
					bean.setPassword(password);
					flag = ServiceDao.userLogin(bean);
					 

					if (flag == true) {
						log.info("Admin login successfully done");

						admin();

					}
					if (flag == false) {
						log.info("  password is incorrect");

					}

				} while (!flag);

			} while (flag == false);// case 1 do block

			break;
		case 2:

			break;

		default:
			log.info("can accept only positive integers 1,2");

			log.info("press 0 to go back");
			int result = Scanner.nextInt();
			if (result == 0) {
				mainAdmin();
			} else {
				log.info("can accept only positive integers 1,2");

				log.info("press 0 to go back");
				int result1 = Scanner.nextInt();
				if (result1 == 0) {
					mainAdmin();
				}
			}

			break;

		}

	}

	void admin() {

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
						} else {
							log.info("entered name is incorrect");
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

				do {
					CustomerInfoBeans bean1 =Factory.customerInstance();
					log.info("Enter application id :");
					appId = Scanner.nextLong();

					bean1.setAppId(appId);

					flag = ServiceDao.customerApplication(bean1);

				} while (!flag);

				do {

					CustomerInfoBeans bean2 =Factory.customerInstance();
					log.info("Enter email  id :");
					email = Scanner.next();

					bean2.setEmail(email);
					flag = ServiceDao.customerApplication(bean2);

				} while (!flag);

				do {

					CustomerInfoBeans bean2 = Factory.customerInstance();
					log.info("Enter loan  id :");
					loanId = Scanner.nextLong();

					bean2.setLoanId(loanId);
					flag = ServiceDao.customerApplication(bean2);

				} while (!flag);

				do {

					CustomerInfoBeans bean2 =Factory.customerInstance();
					log.info("Enter adhaar  number :");
					adhaarNumber = Scanner.nextLong();

					bean2.setAdhaarNumber(adhaarNumber);
					flag = ServiceDao.customerApplication(bean2);

				} while (!flag);

				do {

					CustomerInfoBeans bean2 =Factory.customerInstance();
					log.info("Enter pan number  ");
					panNumber = Scanner.nextLong();

					bean2.setPanNumber(panNumber);
					flag = ServiceDao.customerApplication(bean2);

				} while (!flag);

				do {

					CustomerInfoBeans bean0 = Factory.customerInstance();
					log.info("Enter full name :");
					customerName = Scanner.next();

					bean0.setCustomerName(customerName);

					flag = ServiceDao.customerApplication(bean0);

					if (flag == true) {

						log.info("------------------------------------------------------------------------");
						log.info("Customer details successfully updated by the name : " + customerName);
						log.info("-------------------------------next operation-----------------------------------");
						log.info("press 0 to go back");
						int result = Scanner.nextInt();
						if (result == 0) {
							admin();
						}

					} else {
						log.info("there is no data with these name " + customerName);
					}

				} while (!flag);

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

				do {

					LoansInfoBeans Loans = Factory.loansInstance();
					log.info("Enter loan name :");
					loanName = Scanner.next();
					Loans.setLoanName(loanName);
					flag = ServiceDao.addLoan(Loans);

				} while (flag == false);

				do {

					LoansInfoBeans Loans = Factory.loansInstance();
					log.info("Enter loan amount :");
					loanAmount = Scanner.nextInt();
					Loans.setLoanAmount(loanAmount);
					flag = ServiceDao.addLoan(Loans);

				} while (flag == false);

				do {
					LoansInfoBeans Loans = Factory.loansInstance();
					log.info("Enter loan minimum emi :");
					minimumEmi = Scanner.nextInt();
					Loans.setMinimumEmi(minimumEmi);
					flag = ServiceDao.addLoan(Loans);

 
				} while (flag == false);

				do {
					LoansInfoBeans Loans = Factory.loansInstance();
					log.info("Enter emi amount to set  :");
					setEmi = Scanner.nextInt();
					Loans.setSetEmi(setEmi);
					flag = ServiceDao.addLoan(Loans);
				} while (flag == false);

				do {

					LoansInfoBeans Loans = Factory.loansInstance();
					log.info("Enter loan ID :");
					loanIds = Scanner.nextInt();
					Loans.setLoanId(loanIds);
					flag = ServiceDao.addLoan(Loans);

				} while (flag == false);
				if (flag == true) {
					log.info("--------------------------------------------------------------");
					log.info("Successfully added the loan ");
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

				do {

					AppStatusInfoBeans AppStatusInfoBeans = Factory.applicationStatusInstance();
					log.info("Enter app  id :");
					appId = Scanner.nextInt();

					AppStatusInfoBeans.setAppId(appId);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);

				} while (!flag);

				do {

					AppStatusInfoBeans AppStatusInfoBeans =  Factory.applicationStatusInstance();
					log.info("Enter app  accepted or rejected or null :");
					acceptedOrRejected = Scanner.next();
					AppStatusInfoBeans.setAcceptedOrRejected(acceptedOrRejected);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);

				} while (!flag);

				do {

					AppStatusInfoBeans AppStatusInfoBeans = Factory.applicationStatusInstance();
					log.info("Enter interview date    : ");
					dateOfInterview = Scanner.next();
					AppStatusInfoBeans.setDateOfInterview(dateOfInterview);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);

				} while (!flag);

				do {

					AppStatusInfoBeans AppStatusInfoBeans =  Factory.applicationStatusInstance();
					log.info("Enter approved or rejected   : ");
					approvedOrRejected = Scanner.next();
					AppStatusInfoBeans.setApprovedOrRejected(approvedOrRejected);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);

				} while (!flag);

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
