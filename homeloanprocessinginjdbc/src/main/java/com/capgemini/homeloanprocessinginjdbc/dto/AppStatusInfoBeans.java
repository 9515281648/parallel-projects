package com.capgemini.homeloanprocessinginjdbc.dto;

 
import java.time.LocalDate;

import lombok.Data;

@Data
public class AppStatusInfoBeans {

	private long appId;
	private String acceptedOrRejected;
	private  LocalDate dateOfInterview;
	private String approvedOrRejected;
 

}
