package com.jsfsfeb.homeloanprocessingjpawithhibernates.validations;

 
 
import java.util.regex.Pattern;

import com.jsfsfeb.homeloanprocessingjpawithhibernates.exceptions.DataNotFoundException;

public class AppStatusValidations {

	public Boolean appStatusIdValidator(long id) {

		String idRegEx = "[0-9]{1}[0-9]{4}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new DataNotFoundException("Id should contain exactly 5 digits ");
		}
		return result;
	}

	public Boolean appAccOrRejValidator(String name) {
		
		
		if(name.equalsIgnoreCase("Accepted") || name.equalsIgnoreCase("Rejected")  || name.equalsIgnoreCase("null")) {
			return true;
		}else {
			throw new DataNotFoundException("input fiels should be Accepted  or  Rejected  or null ");
		}
		
		
	

	}

//	public Boolean appDOIValidator(LocalDate localDate) {
//		String nameRegEx = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
//		boolean result = false;
//		Pattern pattern = Pattern.compile(nameRegEx);
//		Matcher matcher = pattern.matcher(localDate);
//		if (matcher.matches()) {
//			result = true;
//		} else {
//			throw new DataNotFoundException("date should contain 12 months  31 days  ");
//		}
//		return result;
//
//	}

	public Boolean appAppOrRejValidator(String name) {
		if(name.equalsIgnoreCase("Approved") || name.equalsIgnoreCase("Rejected")  || name.equalsIgnoreCase("null")) {
			return true;
		}else {
			throw new DataNotFoundException("input fiels should be Approved  or  Rejected  or null ");
		}

	}

}
