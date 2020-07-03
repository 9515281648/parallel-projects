package com.capgemini.homeloanprocessinginjdbc.dto;

import lombok.Data;

@Data
public class LoansInfoBeans {

	private long loanId;
	private String loanName;
	private long loanAmount;
	private long minimumEmi;
	private long setEmi;

}
