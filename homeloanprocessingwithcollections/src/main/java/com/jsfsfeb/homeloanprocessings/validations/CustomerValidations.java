package com.jsfsfeb.homeloanprocessings.validations;

 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jsfsfeb.homeloanprocessings.exceptions.DataNotFoundException;
 

public class CustomerValidations {
	
	 

	public Boolean appIdValidator(long id) {

		String idRegEx = "[0-9]{1}[0-9]{4}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new DataNotFoundException("Id should contain exactly 5 digits");
		}
		return result;
	}

	public Boolean customerNameValidator(String name) {
		String nameRegEx = "^[A-Za-z\\s]{3,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new DataNotFoundException("Name should contain atleast 3 characters and only alphabets ex: abc....  ");
		}
		return result;

	}

	public Boolean emailValidation(String email) {
		String emailRegEx = "[\\w&&[^_]]{3,50}[@]{1}\\D{2,50}[.]{1}\\D{2,50}";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
			 
		} else {
			 
			throw new DataNotFoundException("Enter Correct Email (@ and extensions(.com)) such as example@gmail.com");
		}
		return result;
	}

	public Boolean loanIdValidation(long loanId) {

		String idRegEx = "[0-9]{1}[0-9]{4}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(loanId))) {
			result = true;
		} else {
			throw new DataNotFoundException("Id should contain exactly 5 digits");
		}
		return result;
	}

	// @gmail.com

	public Boolean adhaarNoValidation(long adhaarId) {
		// String aadhaarPattern = "^[0-9]{10}|[0-9]{12}$";
		String aadhaarPattern = "^[0-9]{12}$";
		boolean result = false;
		if (Pattern.matches(aadhaarPattern, String.valueOf(adhaarId))) {
			result = true;
		} else {
			throw new DataNotFoundException("Id should contain exactly 12 digits");
		}
		return result;
	}

	public Boolean panNoValidation(long panId) {
		String aadhaarPattern = "^[0-9]{10}$";
		boolean result = false;
		if (Pattern.matches(aadhaarPattern, String.valueOf(panId))) {
			result = true;
		} else {
			throw new DataNotFoundException("Id should contain exactly 10 digits");
		}
		return result;

	}
	
	
	public Boolean passwordValidation(String password) {  
		String nameRegEx = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new DataNotFoundException("Enter valid password, should start with capital letter, contain atleast 4 characters "
					+ "before special charater, 1 special character and 3 numbers ex: Abc%123.........");
		}
		return result;
		
	}
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
