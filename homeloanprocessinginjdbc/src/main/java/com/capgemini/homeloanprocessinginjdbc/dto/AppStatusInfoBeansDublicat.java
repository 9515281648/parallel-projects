package com.capgemini.homeloanprocessinginjdbc.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class AppStatusInfoBeansDublicat {
	private long appIdd;
	private String acceptedOrRejectedd;
	private  LocalDate dateOfInterviewd;
	private String approvedOrRejectedd;
 
}
