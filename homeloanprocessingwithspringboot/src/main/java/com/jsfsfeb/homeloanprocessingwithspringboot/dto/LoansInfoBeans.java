package com.jsfsfeb.homeloanprocessingwithspringboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="loan")
public class LoansInfoBeans {
@Id
@Column
	private long loanId;
@Column
	private String loanName;
@Column
	private long loanAmount;
@Column
	private long minimumEmi;
@Column
	private long setEmi;

}
