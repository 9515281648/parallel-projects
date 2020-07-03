package com.jsfsfeb.homeloanprocessingwithspringboot.exceptions;

 

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1461109805839557360L;

	public DataNotFoundException(String msg) {
		super(msg);
	}
	
	 
}
