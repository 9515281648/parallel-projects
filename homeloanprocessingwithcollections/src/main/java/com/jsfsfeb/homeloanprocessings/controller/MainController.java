package com.jsfsfeb.homeloanprocessings.controller;

import java.util.InputMismatchException;

import java.util.Scanner;

import com.jsfsfeb.homeloanprocessings.exceptions.DataNotFoundException;

import lombok.extern.log4j.Log4j;

@Log4j
public class MainController {

	static int choice = 0;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		do {

			try {

				Scanner Scanner = new Scanner(System.in);

				log.info("----------------main category--------------");
				log.info("press 1 for adminpage");
				log.info("press 2 for Loan Approval Department page");
				log.info("press 3 for customerpage");

				choice = Scanner.nextInt();
				switch (choice) {
				case 1:

					AdminControll admin = new AdminControll();
					admin.mainAdmin();

					break;
				case 2:
					LoanApprovalDepartmentController lad = new LoanApprovalDepartmentController();
					lad.loanApprovalDepartmentMain();

					break;

				case 3:
					CustomerController cus = new CustomerController();
					cus.customer();

					break;

				default:
					log.info("can accept only positive integers 1,2,3");

					break;

				}

			} catch (InputMismatchException e) {

				System.err.println("Data is miss matched");
			} catch (DataNotFoundException e) {

				System.err.println(e.getMessage());
			} // end of catch block

		} while (true);

	}// end of main method

}// end of class
