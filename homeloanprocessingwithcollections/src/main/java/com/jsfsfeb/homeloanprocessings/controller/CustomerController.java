package com.jsfsfeb.homeloanprocessings.controller;

 
import java.util.List;
import java.util.Scanner;

import com.jsfsfeb.homeloanprocessings.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.LoansInfoBeans;
 
import com.jsfsfeb.homeloanprocessings.factory.Factory;
import com.jsfsfeb.homeloanprocessings.services.ServiceDAO;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomerController {
	Boolean flag = false;
	long appId = 0;
	String customerName = null;
	String email = null;
	long adhaarNumber = 0;
	long panNumber = 0;
	AppStatusInfoBeans a = null;
	AppStatusInfoBeans res = null;
	Boolean check = false;
	long loanId = 0;
	String loanName = null;
	long loanAmount = 0;
	long minimumEmi = 0;
	long setEmi = 0;
	CustomerInfoBeans CustomerInfoBeans = Factory.customerInstance();
	ServiceDAO ServiceDao =Factory.ServiceDAOInstance();
	Scanner Scanner = Factory.scannerInstance();

	void customer() {

		log.info(
				"---------------------------------Customer   Functionalities----------------------------------------------------");
		log.info("press 1 for appling  for    online      home  loan application ");
		log.info(
				"---------------------------------------------------------------------------------------------------------------");
		log.info("press 2 for see      loans");
		
		
		log.info(
				"---------------------------------------------------------------------------------------------------------------");
		log.info("press 3 for knowing  loan   Application Status by  app_id");
		log.info(
				"---------------------------------------------------------------------------------------------------------------");
		log.info("press 4 for update       application details");
		log.info("press 5 for main     category   ");

		int choice = Scanner.nextInt();
		switch (choice) {
		case 1:

			do {

				do {
					CustomerInfoBeans bean = Factory.customerInstance();
					log.info("Enter application id :");
					appId = Scanner.nextLong();

					bean.setAppId(appId);

					flag = ServiceDao.customerApplication(bean);

				} while (!flag);

				do {

					CustomerInfoBeans bean = Factory.customerInstance();
					log.info("Enter email  id :");
					email = Scanner.next();

					bean.setEmail(email);
					flag = ServiceDao.customerApplication(bean);

				} while (!flag);

				do {

					CustomerInfoBeans bean =  Factory.customerInstance();
					log.info("Enter loan  id :");
					loanId = Scanner.nextLong();

					bean.setLoanId(loanId);
					flag = ServiceDao.customerApplication(bean);

				} while (!flag);

				do {

					CustomerInfoBeans bean =  Factory.customerInstance();
					log.info("Enter adhaar  number :");
					adhaarNumber = Scanner.nextLong();

					bean.setAdhaarNumber(adhaarNumber);
					flag = ServiceDao.customerApplication(bean);

				} while (!flag);

				do {

					CustomerInfoBeans bean =  Factory.customerInstance();
					log.info("Enter pan number  ");
					panNumber = Scanner.nextLong();

					bean.setPanNumber(panNumber);
					flag = ServiceDao.customerApplication(bean);

				} while (!flag);

				do {

					CustomerInfoBeans bean =  Factory.customerInstance();
					log.info("Enter full name :");
					customerName = Scanner.next();

					bean.setCustomerName(customerName);

					flag = ServiceDao.customerApplication(bean);
				} while (!flag);

				if (flag == true) {

					log.info("------------------------------------------------------------------------");
					log.info("applied successfully   by the name : " + customerName);
					log.info("-------------------------------next operation-----------------------------------");
					log.info("press 0 to go back");
					int result = Scanner.nextInt();
					if (result == 0) {
						customer();
					}

				}

			} while (!flag);

			break;
		case 2:

		List<LoansInfoBeans> loan =	ServiceDao.retriveLoanDetails();
		 
		for(LoansInfoBeans info : loan) {
			log.info("Loan name         =================>           "+ info.getLoanName());
			log.info("------------------------------------------------------------------------");
			log.info("Loan Amount       =================>           "+ info.getLoanAmount());
			log.info("------------------------------------------------------------------------");
			log.info("Loan Id           =================>           "+ info.getLoanId());
			log.info("------------------------------------------------------------------------");
			log.info("Loan Minimum Emi  =================>           "+ info.getMinimumEmi());
			log.info("------------------------------------------------------------------------");
			log.info("Loan Set Emi      =================>           "+ info.getSetEmi());
			log.info("------------------------------------------------------------------------");
			log.info("                                                                        ");
			log.info("************************************************************************");
			log.info("------------------------------------------------------------------------");
			log.info("************************************************************************");
			log.info("------------------------------------------------------------------------");
			log.info("                                                                        ");
			
		}

			subCustomer();

			break;

		case 3:

			do {
				do {

					log.info("Enter app  id :");
					long appid = Scanner.nextInt();

					res = ServiceDao.getAppStatusByLoanId(appid);
				} while (res == null);
				if (res != null) {

					log.info("app_id                     ==========>    " + res.getAppId());
					log.info("Accepted or rejected       ==========>    " + res.getAcceptedOrRejected());
					log.info("date of interview          ==========>    " + res.getDateOfInterview());
					log.info("Approved or rejected       ==========>    " + res.getApprovedOrRejected());
					log.info("----------------------------------------------------------------------");
					log.info("press 0 to go back");
					int res2 = Scanner.nextInt();
					if (res2 == 0) {
						customer();
					}

				} else {
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("the entered app id is not found in database ");
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("press 0 to go back");
					int res3 = Scanner.nextInt();
					if (res3 == 0) {
						customer();
					}
				}

			} while (res == null);

			break;

		case 4:
			

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
						log.info("presults 0 to go back");
						int result = Scanner.nextInt();
						if (result == 0) {
							customer();
						}

					} else {
						log.info("there is no data with these name " + customerName);
					}

				} while (!flag);

			} while (flag);

			

			break;
		case 5:

			break;

		}// end of switch

	}// end of customer method

	/**
	 * @deprecated Use {@link #subCustomer()} instead
	 */
	void subcus() {
		subCustomer();
	}

	void subCustomer() {

		log.info(
				"---------------------------------------------------------------------------------------------------------------");
		log.info("press 1 for selecting loan by loanId");

		int choice1 = Scanner.nextInt();

		switch (choice1) {

		case 1:

			do {

				log.info("Enter loan  id :");
				loanId = Scanner.nextInt();

				LoansInfoBeans LoansInfoBeans = ServiceDao.retriveLoanDetailsById(loanId);

				if (LoansInfoBeans != null) {
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("loanId           =========>   " + LoansInfoBeans.getLoanId());
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("loanName         =========>   " + LoansInfoBeans.getLoanName());
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("loanAmount       =========>   " + LoansInfoBeans.getLoanAmount());
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("loan_minimum_emi =========>   " + LoansInfoBeans.getMinimumEmi());
					log.info(
							"---------------------------------------------------------------------------------------------------------------");
					log.info("loan_emi_set     =========>   " + LoansInfoBeans.getSetEmi());

					log.info("press 0 to go back");
					int res = Scanner.nextInt();
					if (res == 0) {
						customer();
					}
				} else {
					log.info("entered id is not found in database");
				}

			} while (flag == false);

			break;

		}// end of switch

	}// end of subCustomer

}// end of class
