package com.jsfsfeb.homeloanprocessings.controller;

 
import java.util.List;
import java.util.Scanner;

import com.jsfsfeb.homeloanprocessings.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.EmployeeInfoBeans;
 
import com.jsfsfeb.homeloanprocessings.factory.Factory;
import com.jsfsfeb.homeloanprocessings.services.ServiceDAO;
import com.jsfsfeb.homeloanprocessings.services.ServiceDAOImplementation;
 

import lombok.extern.log4j.Log4j;

@Log4j
public class LoanApprovalDepartmentController {

	Boolean flag = false;

	long appId = 0;
	String customerName = null;
	String emailId = null;
	long loanId = 0;
	long adhaarNumber = 0;
	long panNumber = 0;
	int choice = 0;
	String password = null;

	String acceptedOrRejected = null;
	String dateOfInterview = null;
	String approvedOrRejected = null;

	 
	ServiceDAO ServiceDao =  Factory.ServiceDAOInstance();
	Scanner Scanner = Factory.scannerInstance();
	CustomerInfoBeans CustomerInfoBeans = null;
	EmployeeInfoBeans EmployeeInfoBeans = null;

	 

	void loanApprovalDepartmentMain() {

		do {
			log.info("press 1 for LAD login ");
			log.info("press 2 for main category");
			choice = Scanner.nextInt();

			switch (choice) {

			case 1:
				do {

					do {
						EmployeeInfoBeans bean =Factory.employeeInstance();
						log.info("enter the email");
						emailId = Scanner.next();
						bean.setEmail(emailId);
						flag = ServiceDao.userLogin(bean);
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
						if (flag == false) {
							log.info("password  is not correct");
						}

					} while (flag == false);

					if (flag == true) {
						log.info("LAD login successfully Done");

						loanApprovalDepartment();

					}

				} while (flag == false);
				break;

			case 2:

				break;

			default:
				log.info("only positive integers 1,2 are accepted");
				break;

			}
		} while (choice == 0);

	}// end of ladm method

	void loanApprovalDepartment() {

		log.info("----------------------------------------------------------------------------------------");

		log.info("press  1 for taking   application   details  to       start loan processing");
		log.info("----------------------------------------------------------------------------------------");
		log.info("press  2 for updating application   status   by       appid");
		log.info("----------------------------------------------------------------------------------------");
		log.info("press  3 to  see      all           customer details");
		log.info("----------------------------------------------------------------------------------------");
		log.info("press  4 for main     category ");
		log.info("----------------------------------------------------------------------------------------");
		int choice1 = Scanner.nextInt();

		switch (choice1) {

		case 1:
			do {

				ServiceDAO s = new ServiceDAOImplementation();

				CustomerInfoBeans = s.retriveAllCustomerInfoBySerial();
				log.info(
						"--------------------------------Access  gained successfully-------------------------------------");
				log.info("app_id               ===========>    " + CustomerInfoBeans.getAppId());
				log.info("customer_name        ===========>    " + CustomerInfoBeans.getCustomerName());
				log.info("customer email       ===========>    " + CustomerInfoBeans.getEmail());
				log.info("loan_id              ===========>    " + CustomerInfoBeans.getLoanId());
				log.info("adhaar_id            ===========>    " + CustomerInfoBeans.getAdhaarNumber());
				log.info("pan_id               ===========>    " + CustomerInfoBeans.getPanNumber());
				log.info(
						"--------------------------------next    operation-----------------------------------------------");
				log.info("press 0 to go back");
				int res = Scanner.nextInt();
				if (res == 0) {
					loanApprovalDepartment();
				}

			} while (CustomerInfoBeans == null);
			break;

		case 2:
			do {

				do {

					AppStatusInfoBeans AppStatusInfoBeans = Factory.applicationStatusInstance();
					log.info("Enter app  id :");
					appId = Scanner.nextInt();

					AppStatusInfoBeans.setAppId(appId);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);

				} while (!flag);

				do {

					AppStatusInfoBeans AppStatusInfoBeans = Factory.applicationStatusInstance();
					log.info("Enter app  accepted or rejected or null :");
					acceptedOrRejected = Scanner.next();
					AppStatusInfoBeans.setAcceptedOrRejected(acceptedOrRejected);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);

				} while (!flag);

				do {

					AppStatusInfoBeans AppStatusInfoBeans = Factory.applicationStatusInstance();
					log.info("Enter interview date    :");
					dateOfInterview = Scanner.next();
					AppStatusInfoBeans.setDateOfInterview(dateOfInterview);
					flag = ServiceDao.updateLoanAppStatusInfoById(AppStatusInfoBeans);

				} while (!flag);

				do {

					AppStatusInfoBeans AppStatusInfoBeans = Factory.applicationStatusInstance();
					log.info("Enter approved or rejected   :");
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
						loanApprovalDepartment();
					}
				} else {
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("entered application number is invalid");
				}
			} while (!flag);
			break;

		case 3:
			ServiceDAO s1 = new ServiceDAOImplementation();
			List<CustomerInfoBeans> cus = s1.retriveAllCustomerInfo();

			for (CustomerInfoBeans record : cus) {
				log.info("application id     =====================>     " + record.getAppId());
				log.info("Customer name      =====================>     " + record.getCustomerName());
				log.info("customer mail      =====================>     " + record.getEmail());
				log.info("customer loan id   =====================>     " + record.getLoanId());
				log.info("customer adhaar no =====================>     " + record.getAdhaarNumber());
				log.info("customer pan no    =====================>     " + record.getPanNumber());
				log.info(
						"====================================================================================================");
				log.info(
						"                                                                                                    ");
				log.info(
						"****************************************************************************************************");
				log.info(
						"                                                                                                    ");
				log.info(
						"====================================================================================================");

			}

			log.info("------------------next operation-----------------");
			log.info("press 0 to go back");
			int res = Scanner.nextInt();
			if (res == 0) {
				loanApprovalDepartment();
			}

			break;
		case 4:

			break;

		}// end of switch

	}// end of lad method

}// end of class
