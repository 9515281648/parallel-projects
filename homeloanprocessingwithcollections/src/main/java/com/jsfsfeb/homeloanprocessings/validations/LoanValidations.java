package com.jsfsfeb.homeloanprocessings.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jsfsfeb.homeloanprocessings.exceptions.DataNotFoundException;

public class LoanValidations {

	public Boolean loanIdValidator(long id) {

		String idRegEx = "[0-9]{1}[0-9]{4}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new DataNotFoundException("Id should contain exactly 5 digits nikhil");
		}
		return result;
	}

	public Boolean loanNameValidator(String name) {
		String nameRegEx = "^[A-Za-z\\s]{3,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new DataNotFoundException(
					"Name should contain atleast 3 characters and only alphabets ex: abc......   ");
		}
		return result;

	}

	public Boolean loanAmountValidator(long id) {

		String idRegEx = "[0-9]{1}[0-9]{4}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new DataNotFoundException("Id should contain exactly 5 digits");
		}
		return result;
	}

	public Boolean loanMinEmiValidator(long id) {
		String idRegEx = "[0-9]{1}[0-9]{4}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new DataNotFoundException("Id should contain exactly 5 digits");
		}
		return result;
	}

	public Boolean setLoanMinEmiValidator(long id) {
		String idRegEx = "[0-9]{1}[0-9]{4}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new DataNotFoundException("Id should contain exactly 5 digits");
		}
		return result;
	}

}
