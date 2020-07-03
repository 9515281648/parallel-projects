package com.jsfsfeb.homeloanprocessings.services;
import java.util.List;
import com.jsfsfeb.homeloanprocessings.dao.AppStatusDAO;
import com.jsfsfeb.homeloanprocessings.dao.AppStatusDAOImplementation;
import com.jsfsfeb.homeloanprocessings.dao.CustomerDAO;
import com.jsfsfeb.homeloanprocessings.dao.CustomerDAOImplementation;
import com.jsfsfeb.homeloanprocessings.dao.LoanDAO;
import com.jsfsfeb.homeloanprocessings.dao.LoanDAOImplementation;
import com.jsfsfeb.homeloanprocessings.dao.UserDAO;
import com.jsfsfeb.homeloanprocessings.dao.UserDAOImplementation;
import com.jsfsfeb.homeloanprocessings.dto.AppStatusInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.EmployeeInfoBeans;
import com.jsfsfeb.homeloanprocessings.dto.LoansInfoBeans;
import com.jsfsfeb.homeloanprocessings.exceptions.DataNotFoundException;
import com.jsfsfeb.homeloanprocessings.exceptions.InputMismatchException;
import com.jsfsfeb.homeloanprocessings.repository.RepositoryStorage;
import com.jsfsfeb.homeloanprocessings.validations.AppStatusValidations;
import com.jsfsfeb.homeloanprocessings.validations.CustomerValidations;
import com.jsfsfeb.homeloanprocessings.validations.LoanValidations;
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

	public Boolean userLogin(EmployeeInfoBeans bean) {
		try {
				if (bean.getPassword() != null) {
					if (validations.passwordValidation(bean.getPassword()) == true) {
						log.info("password zone  ");
						return udao.userLogin(bean);
					}
					return false;
				}
				if (bean.getEmail() != null) {
					if (validations.emailValidation(bean.getEmail()) == true) {
						log.info("email zone");
						return udao.userLogin(bean);
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
	public boolean customerApplication(CustomerInfoBeans bean) {
		RepositoryStorage.dataOfCustomer();
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
						return true;
					}
				}
				if (bean.getEmail() != null) {
					if (validations.emailValidation(bean.getEmail()) == true) {
						log.info("mail zone");
						RepositoryStorage.dataOfCustomer().add(bean);
						return true;
					}
				}
				if (bean.getLoanId() != 0 && bean.getLoanId() > 0) {
					if (validations.loanIdValidation(bean.getLoanId()) == true) {
						log.info("loan zone");
						RepositoryStorage.dataOfCustomer().add(bean);
						return true;
					}
				}
				if (bean.getAdhaarNumber() != 0 && bean.getAdhaarNumber() > 0) {
					if (validations.adhaarNoValidation(bean.getAdhaarNumber()) == true) {
						log.info("adhaar zone");
						RepositoryStorage.dataOfCustomer().add(bean);
						return true;
					}
				}
				if (bean.getPanNumber() != 0 && bean.getPanNumber() > 0) {

					if (validations.panNoValidation(bean.getPanNumber()) == true) {
						log.info("pan zone");
						RepositoryStorage.dataOfCustomer().add(bean);
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

	public Boolean removeCustomerInfoByName(String name) {
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

	public CustomerInfoBeans retriveAllCustomerInfoByName(String name) {
		try {
			if (validations.customerNameValidator(name) == true) {

				log.info("name is not present in database");
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

	public CustomerInfoBeans retriveAllCustomerInfoBySerial() {
		return udao.retriveAllCustomerInfoBySerial();
	}

	public List<LoansInfoBeans> retriveLoanDetails() {
		return ldao.retriveLoanDetails();
	}

	public AppStatusInfoBeans getAppStatusByLoanId(long id) {
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

	public LoansInfoBeans retriveLoanDetailsById(long id) {
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

	public Boolean setEmiByLoanId(long id, long emi) {
		return ldao.setEmiByLoanId(id, emi);
	}

	public List<CustomerInfoBeans> retriveAllCustomerInfo() {
		return udao.retriveAllCustomerInfo();
	}

	public Boolean addLoan(LoansInfoBeans bean) {

		try {
			if (bean.getLoanId() != 0 && bean.getLoanId() > 0) {

				if (Loan.loanIdValidator(bean.getLoanId()) == true) {

					for (LoansInfoBeans l : RepositoryStorage.dataOfLoan()) {
						if (l.getLoanId() == bean.getLoanId()) {
							log.info("entered loan id is already exit");
							return false;
						}
					}
					log.info("entered loan id is not present in database");

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

	public Boolean removeLoanInfoById(long id) {

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

	public Boolean updateLoanAppStatusInfoById(AppStatusInfoBeans app) {

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

		if (app.getDateOfInterview() != null) {
			try {
				if (App.appDOIValidator(app.getDateOfInterview()) == true) {

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

 
}
