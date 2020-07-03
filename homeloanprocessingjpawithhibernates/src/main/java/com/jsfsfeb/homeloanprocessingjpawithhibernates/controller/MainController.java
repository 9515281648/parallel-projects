package com.jsfsfeb.homeloanprocessingjpawithhibernates.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.jsfsfeb.homeloanprocessingjpawithhibernates.exceptions.DataNotFoundException;

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
					try {
						admin.mainAdmin();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;
				case 2:
					LoanApprovalDepartmentController lad = new LoanApprovalDepartmentController();
					try {
						lad.loanApprovalDepartmentMain();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;

				case 3:
					CustomerController cus = new CustomerController();
					try {
						cus.customer();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

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
