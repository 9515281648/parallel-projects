package com.jsfsfeb.homeloanprocessingwithspringboot.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfsfeb.homeloanprocessingwithspringboot.dao.AppStatusDAO;
import com.jsfsfeb.homeloanprocessingwithspringboot.dao.CustomerDAO;
import com.jsfsfeb.homeloanprocessingwithspringboot.dao.LoanDAO;
import com.jsfsfeb.homeloanprocessingwithspringboot.dao.UserDAO;
import com.jsfsfeb.homeloanprocessingwithspringboot.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessingwithspringboot.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessingwithspringboot.dto.EmployeeInfoBeans;
import com.jsfsfeb.homeloanprocessingwithspringboot.dto.LoansInfoBeans;
import com.jsfsfeb.homeloanprocessingwithspringboot.exceptions.DataNotFoundException;
import com.jsfsfeb.homeloanprocessingwithspringboot.exceptions.InputMismatchException;
import com.jsfsfeb.homeloanprocessingwithspringboot.validation.AppStatusValidations;
import com.jsfsfeb.homeloanprocessingwithspringboot.validation.CustomerValidations;
import com.jsfsfeb.homeloanprocessingwithspringboot.validation.LoanValidations;

@Service
public class ServiceDAOImplementation implements ServiceDAO {
	Boolean flag = false;
	@Autowired
	CustomerInfoBeans customerBeans;
	@Autowired
	CustomerDAO cdao;
	@Autowired
	UserDAO udao;
	@Autowired
	LoanDAO ldao;
	@Autowired
	AppStatusDAO adao;
	@Autowired
	CustomerValidations validations;
	@Autowired
	LoanValidations Loan;
	@Autowired
	AppStatusValidations App;

	public Boolean userLogin(EmployeeInfoBeans bean) throws SQLException {
		try {
			if (bean.getPassword() != null && bean.getEmail() == null) {
				if (validations.passwordValidation(bean.getPassword()) == true) {
					return true;
				}
			}
			if (bean.getPassword() != null && bean.getEmail() != null) {

				return udao.userLogin(bean);
			}

			if (bean.getEmail() != null && bean.getPassword() == null) {
				if (validations.emailValidation(bean.getEmail()) == true) {

					return true;
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

					return cdao.customerApplication(bean);
				}
			}
			if (bean.getAppId() != 0 && bean.getAppId() > 0) {
				if (validations.appIdValidator(bean.getAppId()) == true) {

					return cdao.customerApplication(bean);
				}
			}
			if (bean.getEmail() != null) {
				if (validations.emailValidation(bean.getEmail()) == true) {

					return cdao.customerApplication(bean);
				}
			}
			if (bean.getLoanId() != 0 && bean.getLoanId() > 0) {
				if (validations.loanIdValidation(bean.getLoanId()) == true) {

					return cdao.customerApplication(bean);
				}
			}
			if (bean.getAdhaarNumber() != 0 && bean.getAdhaarNumber() > 0) {
				if (validations.adhaarNoValidation(bean.getAdhaarNumber()) == true) {

					return cdao.customerApplication(bean);
				}
			}
			if (bean.getPanNumber() != 0 && bean.getPanNumber() > 0) {

				if (validations.panNoValidation(bean.getPanNumber()) == true) {

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

	public AppStatusInfoBeans getAppStatusByLoanId(long id)
			throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
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

			if (bean.getLoanId() != 0 && bean.getLoanId() > 0 && bean.getLoanName() != null && bean.getLoanAmount() != 0
					&& bean.getLoanAmount() > 0 && bean.getMinimumEmi() != 0 && bean.getMinimumEmi() > 0
					&& bean.getSetEmi() != 0 && bean.getSetEmi() > 0) {
				return ldao.addLoan(bean);
			}

			if (bean.getLoanId() != 0 && bean.getLoanId() > 0 && bean.getLoanName() == null) {

				if (Loan.loanIdValidator(bean.getLoanId()) == true) {

					return true;

				}

			}

			if (bean.getLoanName() != null && bean.getLoanAmount() == 0) {

				if (Loan.loanNameValidator(bean.getLoanName()) == true) {

					return true;

				}

			}

			if (bean.getLoanAmount() != 0 && bean.getLoanAmount() > 0 && bean.getLoanName() == null) {

				if (Loan.loanAmountValidator(bean.getLoanAmount()) == true) {

					return true;

				}

			}

			if (bean.getMinimumEmi() != 0 && bean.getMinimumEmi() > 0 && bean.getLoanName() == null) {

				if (Loan.loanMinEmiValidator(bean.getMinimumEmi()) == true) {

					return true;

				}

			}

			if (bean.getSetEmi() != 0 && bean.getSetEmi() > 0 && bean.getLoanName() == null) {

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
		try {

			if (app.getAppId() != 0 && app.getAppId() > 0 && app.getAcceptedOrRejected() != null
					&& app.getDateOfInterview() != null && app.getApprovedOrRejected() != null) {
				System.out.println("process started");
				return udao.updateLoanAppStatusInfoById(app);
			}

			if (app.getAppId() != 0 && app.getAppId() > 0 && app.getAcceptedOrRejected() == null) {
				if (App.appStatusIdValidator(app.getAppId()) == true) {
					return true;
				}
			}
			if (app.getAcceptedOrRejected() != null && app.getDateOfInterview() == null) {
				if (App.appAccOrRejValidator(app.getAcceptedOrRejected()) == true) {
					return true;
				}
			}
			if (app.getDateOfInterview() != null && app.getAcceptedOrRejected() == null) {
				return true;
			}
			if (app.getApprovedOrRejected() != null && app.getAcceptedOrRejected() == null) {
				if (App.appAppOrRejValidator(app.getApprovedOrRejected()) == true) {
					return true;
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

	@Override
	public boolean customerApplicationUpdate(CustomerInfoBeans bean) throws SQLException {

		try {

			if (bean.getCustomerName() != null && bean.getAppId() != 0 && bean.getAppId() > 0 && bean.getEmail() != null
					&& bean.getLoanId() != 0 && bean.getLoanId() > 0 && bean.getAdhaarNumber() != 0
					&& bean.getAdhaarNumber() > 0 && bean.getPanNumber() != 0 && bean.getPanNumber() > 0) {
				return cdao.customerApplicationUpdate(bean);
			}

			if (bean.getCustomerName() != null && bean.getAppId() == 0) {
				if (validations.customerNameValidator(bean.getCustomerName()) == true) {

					return true;
				}
			}
			if (bean.getAppId() != 0 && bean.getAppId() > 0 && bean.getCustomerName() == null) {
				if (validations.appIdValidator(bean.getAppId()) == true) {

					return true;
				}
			}
			if (bean.getEmail() != null && bean.getCustomerName() == null) {
				if (validations.emailValidation(bean.getEmail()) == true) {

					return true;
				}
			}
			if (bean.getLoanId() != 0 && bean.getLoanId() > 0 && bean.getCustomerName() == null) {
				if (validations.loanIdValidation(bean.getLoanId()) == true) {

					return true;
				}
			}
			if (bean.getAdhaarNumber() != 0 && bean.getAdhaarNumber() > 0 && bean.getCustomerName() == null) {
				if (validations.adhaarNoValidation(bean.getAdhaarNumber()) == true) {

					return true;
				}
			}
			if (bean.getPanNumber() != 0 && bean.getPanNumber() > 0 && bean.getCustomerName() == null) {

				if (validations.panNoValidation(bean.getPanNumber()) == true) {

					return true;
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
			if (bean.getCustomerName() != null && bean.getAppId() != 0 && bean.getAppId() > 0 && bean.getEmail() != null
					&& bean.getLoanId() != 0 && bean.getLoanId() > 0 && bean.getAdhaarNumber() != 0
					&& bean.getAdhaarNumber() > 0 && bean.getPanNumber() != 0 && bean.getPanNumber() > 0) {
				return cdao.customerApplicationUpdateById(bean);
			}

			if (bean.getCustomerName() != null) {
				if (validations.customerNameValidator(bean.getCustomerName()) == true) {

					return true;
				}
			}
			if (bean.getAppId() != 0 && bean.getAppId() > 0) {
				if (validations.appIdValidator(bean.getAppId()) == true) {

					return true;
				}
			}
			if (bean.getEmail() != null) {
				if (validations.emailValidation(bean.getEmail()) == true) {

					return true;
				}
			}
			if (bean.getLoanId() != 0 && bean.getLoanId() > 0) {
				if (validations.loanIdValidation(bean.getLoanId()) == true) {

					return true;
				}
			}
			if (bean.getAdhaarNumber() != 0 && bean.getAdhaarNumber() > 0) {
				if (validations.adhaarNoValidation(bean.getAdhaarNumber()) == true) {

					return true;
				}
			}
			if (bean.getPanNumber() != 0 && bean.getPanNumber() > 0) {

				if (validations.panNoValidation(bean.getPanNumber()) == true) {

					return true;
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
