package com.jsfsfeb.homeloanprocessingjpawithhibernates.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_application")
public class CustomerInfoBeans {
	
	 @Id
	 @Column
	private long appId;
	 @Column
	private String customerName;
	 @Column
	private String email;
	 @Column
	private long loanId;
	 @Column
	private long adhaarNumber;
	 @Column
	private long panNumber;
	 
	 
	 
	 
	 
	
	

}
