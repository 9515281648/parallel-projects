package com.capgemini.homeloanprocessinginjdbc.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.capgemini.homeloanprocessinginjdbc.dao.AppStatusDAO;
import com.capgemini.homeloanprocessinginjdbc.dao.AppStatusDAOImplementation;
import com.capgemini.homeloanprocessinginjdbc.dao.CustomerDAO;
import com.capgemini.homeloanprocessinginjdbc.dao.CustomerDAOImplementation;
import com.capgemini.homeloanprocessinginjdbc.dao.LoanDAO;
import com.capgemini.homeloanprocessinginjdbc.dao.LoanDAOImplementation;
import com.capgemini.homeloanprocessinginjdbc.dao.UserDAO;
import com.capgemini.homeloanprocessinginjdbc.dao.UserDAOImplementation;
import com.capgemini.homeloanprocessinginjdbc.dto.AppStatusInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.CustomerInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.EmployeeInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.dto.LoansInfoBeans;
import com.capgemini.homeloanprocessinginjdbc.exceptions.DataNotFoundException;
import com.capgemini.homeloanprocessinginjdbc.exceptions.InputMismatchException;
import com.capgemini.homeloanprocessinginjdbc.validations.AppStatusValidations;
import com.capgemini.homeloanprocessinginjdbc.validations.CustomerValidations;
import com.capgemini.homeloanprocessinginjdbc.validations.LoanValidations;

import lombok.extern.log4j.Log4j;

@Log4j
public class ServiceDAOImplementation implements ServiceDAO {
	Boolean flag = false;
	CustomerInfoBeans customerBeans = new CustomerInfoBeans();
	CustomerDAO cdao = new CustomerDAOImplementation();
	UserDAO udao = new UserDAOImplementation();
	LoanDAO ldao = new LoanDAOImplementation();
	AppStatusDAO adao = new AppStatusDAOImplementation();
	CustomerValidations validations = new CustomerValidations();
	LoanValidations Loan = new LoanValidations();
	AppStatusValidations App = new AppStatusValidations();

	public Boolean userLogin(EmployeeInfoBeans bean) throws SQLException {
		try {
			if (bean.getPassword() != null) {
				if (validations.passwordValidation(bean.getPassword()) == true) {
					log.info("password zone  ");
					return udao.userLogin(bean);
				}
			}

			if (bean.getEmail() != null) {
				if (validations.emailValidation(bean.getEmail()) == true) {
					log.info("email zone");
					return udao.userLogin(bean);
				}
			}

			return false;

		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean customerApplication(CustomerInfoBeans bean) throws SQLException {

		try {
			if (bean.getCustomerName() != null) {
				if (validations.customerNameValidator(bean.getCustomerName()) == true) {
					log.info("name zone");
					return cdao.customerApplication(bean);
				}
			}
			if (bean.getAppId() != 0 && bean.getAppId() > 0) {
				if (validations.appIdValidator(bean.getAppId()) == true) {
					log.info("appid zone");
					return cdao.customerApplication(bean);
				}
			}
			if (bean.getEmail() != null) {
				if (validations.emailValidation(bean.getEmail()) == true) {
					log.info("mail zone");

					return cdao.customerApplication(bean);
				}
			}
			if (bean.getLoanId() != 0 && bean.getLoanId() > 0) {
				if (validations.loanIdValidation(bean.getLoanId()) == true) {
					log.info("loan zone");

					return cdao.customerApplication(bean);
				}
			}
			if (bean.getAdhaarNumber() != 0 && bean.getAdhaarNumber() > 0) {
				if (validations.adhaarNoValidation(bean.getAdhaarNumber()) == true) {
					log.info("adhaar zone");

					return cdao.customerApplication(bean);
				}
			}
			if (bean.getPanNumber() != 0 && bean.getPanNumber() > 0) {

				if (validations.panNoValidation(bean.getPanNumber()) == true) {
					log.info("pan zone");

					return cdao.customerApplication(bean);
				}

			}
		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} 
		
		
		
		return false;
	}

	public Boolean removeCustomerInfoByName(String name) throws SQLException {
		try {
			if (validations.customerNameValidator(name) == true) {
				return udao.removeCustomerInfoByName(name);
			}
		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} // email catch block
		return false;
	}

	public CustomerInfoBeans retriveAllCustomerInfoByName(String name) throws SQLException {
		try {
			if (validations.customerNameValidator(name) == true) {

				return udao.retriveAllCustomerInfoByName(name);
			}
		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} // email catch block
		return null;
	}

	public CustomerInfoBeans retriveAllCustomerInfoBySerial() throws SQLException {

		return udao.retriveAllCustomerInfoBySerial();
	}

	public List<LoansInfoBeans> retriveLoanDetails() throws SQLException {
		return ldao.retriveLoanDetails();
	}

	public AppStatusInfoBeans getAppStatusByLoanId(long id) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		try {
			if (Loan.loanIdValidator(id) == true) {
				return adao.getAppStatusByLoanId(id);
			}
		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		}
		return null;
	}

	public LoansInfoBeans retriveLoanDetailsById(long id) throws SQLException {
		try {
			if (Loan.loanIdValidator(id) == true && id > 0) {
				return ldao.retriveLoanDetailsById(id);
			}
		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		}
		return ldao.retriveLoanDetailsById(id);
	}

	public Boolean setEmiByLoanId(long id, long emi) throws SQLException {
		return ldao.setEmiByLoanId(id, emi);
	}

	public List<CustomerInfoBeans> retriveAllCustomerInfo() throws SQLException {
		return udao.retriveAllCustomerInfo();
	}

	public Boolean addLoan(LoansInfoBeans bean) throws SQLException {

		try {
			if (bean.getLoanId() != 0 && bean.getLoanId() > 0) {

				if (Loan.loanIdValidator(bean.getLoanId()) == true) {

					return ldao.addLoan(bean);

				}
				return true;

			}

		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} // email catch block

		try {
			if (bean.getLoanName() != null) {

				if (Loan.loanNameValidator(bean.getLoanName()) == true) {

					return ldao.addLoan(bean);

				}

			}

		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} // email catch block

		try {
			if (bean.getLoanAmount() != 0 && bean.getLoanAmount() > 0) {

				if (Loan.loanAmountValidator(bean.getLoanAmount()) == true) {

					return ldao.addLoan(bean);

				}

			}

		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} // email catch block

		try {
			if (bean.getMinimumEmi() != 0 && bean.getMinimumEmi() > 0) {

				if (Loan.loanMinEmiValidator(bean.getMinimumEmi()) == true) {

					return ldao.addLoan(bean);

				}

			}

		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} // email catch block

		try {
			if (bean.getSetEmi() != 0 && bean.getSetEmi() > 0) {

				if (Loan.setLoanMinEmiValidator(bean.getSetEmi()) == true) {

					return ldao.addLoan(bean);

				}

			}

		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} // email catch block

		return false;

	}

	public Boolean removeLoanInfoById(long id) throws SQLException {

		try {

			if (Loan.loanIdValidator(id) == true && id > 0) {

				log.info("entered loan id doesn't exit");
				return udao.removeLoanInfoById(id);

			}

		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} // email catch block

		return false;

	}

	public Boolean updateLoanAppStatusInfoById(AppStatusInfoBeans app) throws SQLException {

		if (app.getAppId() != 0 && app.getAppId() > 0) {

			try {
				if (App.appStatusIdValidator(app.getAppId()) == true) {

					return udao.updateLoanAppStatusInfoById(app);

				}

			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Id should contains 3 characters and all alphabits  ");
			} catch (DataNotFoundException e) {
				flag = false;
				System.err.println(e.getMessage());
			}

		}

		if (app.getAcceptedOrRejected() != null) {
			try {
				if (App.appAccOrRejValidator(app.getAcceptedOrRejected()) == true) {

					return udao.updateLoanAppStatusInfoById(app);

				}

			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Id should contains 3 characters and all alphabits  ");
			} catch (DataNotFoundException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		}
		try {	
		if (app.getDateOfInterview() != null) {
		
		  

			
			return udao.updateLoanAppStatusInfoById(app);
		}
		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		}

			 
		

		if (app.getApprovedOrRejected() != null) {
			try {
				if (App.appAppOrRejValidator(app.getApprovedOrRejected()) == true) {

					return udao.updateLoanAppStatusInfoById(app);

				}

			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Id should contains 3 characters and all alphabits  ");
			} catch (DataNotFoundException e) {
				flag = false;
				System.err.println(e.getMessage());
			}

		}

		return false;

	}

	@Override
	public boolean customerApplicationUpdate(CustomerInfoBeans bean) throws SQLException {
		 


		try {
			if (bean.getCustomerName() != null) {
				if (validations.customerNameValidator(bean.getCustomerName()) == true) {
					log.info("name zone");
					return cdao.customerApplicationUpdate(bean);
				}
			}
			if (bean.getAppId() != 0 && bean.getAppId() > 0) {
				if (validations.appIdValidator(bean.getAppId()) == true) {
					log.info("appid zone");
					return cdao.customerApplicationUpdate(bean);
				}
			}
			if (bean.getEmail() != null) {
				if (validations.emailValidation(bean.getEmail()) == true) {
					log.info("mail zone");

					return cdao.customerApplicationUpdate(bean);
				}
			}
			if (bean.getLoanId() != 0 && bean.getLoanId() > 0) {
				if (validations.loanIdValidation(bean.getLoanId()) == true) {
					log.info("loan zone");

					return cdao.customerApplicationUpdate(bean);
				}
			}
			if (bean.getAdhaarNumber() != 0 && bean.getAdhaarNumber() > 0) {
				if (validations.adhaarNoValidation(bean.getAdhaarNumber()) == true) {
					log.info("adhaar zone");

					return cdao.customerApplicationUpdate(bean);
				}
			}
			if (bean.getPanNumber() != 0 && bean.getPanNumber() > 0) {

				if (validations.panNoValidation(bean.getPanNumber()) == true) {
					log.info("pan zone");

					return cdao.customerApplicationUpdate(bean);
				}

			}
		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} // email catch block
		return false;
	
	}

	@Override
	public boolean customerApplicationUpdateById(CustomerInfoBeans bean) throws SQLException {


		try {
			if (bean.getCustomerName() != null) {
				if (validations.customerNameValidator(bean.getCustomerName()) == true) {
					log.info("name zone");
					return cdao.customerApplicationUpdateById(bean);
				}
			}
			if (bean.getAppId() != 0 && bean.getAppId() > 0) {
				if (validations.appIdValidator(bean.getAppId()) == true) {
					log.info("appid zone");
					return cdao.customerApplicationUpdateById(bean);
				}
			}
			if (bean.getEmail() != null) {
				if (validations.emailValidation(bean.getEmail()) == true) {
					log.info("mail zone");

					return cdao.customerApplicationUpdateById(bean);
				}
			}
			if (bean.getLoanId() != 0 && bean.getLoanId() > 0) {
				if (validations.loanIdValidation(bean.getLoanId()) == true) {
					log.info("loan zone");

					return cdao.customerApplicationUpdateById(bean);
				}
			}
			if (bean.getAdhaarNumber() != 0 && bean.getAdhaarNumber() > 0) {
				if (validations.adhaarNoValidation(bean.getAdhaarNumber()) == true) {
					log.info("adhaar zone");

					return cdao.customerApplicationUpdateById(bean);
				}
			}
			if (bean.getPanNumber() != 0 && bean.getPanNumber() > 0) {

				if (validations.panNoValidation(bean.getPanNumber()) == true) {
					log.info("pan zone");

					return cdao.customerApplicationUpdateById(bean);
				}

			}
		} catch (InputMismatchException e) {
			flag = false;
			System.err.println("Id should contains 3 characters and all alphabits  ");
		} catch (DataNotFoundException e) {
			flag = false;
			System.err.println(e.getMessage());
		} // email catch block
		return false;
	
	}

}
