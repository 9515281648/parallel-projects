package com.jsfsfeb.homeloanprocessingjpawithhibernates.dto;

 
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@Table(name = "loanappstatus")
public class AppStatusInfoBeans {
@Id
@Column
	private long appId;
@Column
	private String acceptedOrRejected;
@Column
	private  LocalDate dateOfInterview;
@Column
	private String approvedOrRejected;
 

}
