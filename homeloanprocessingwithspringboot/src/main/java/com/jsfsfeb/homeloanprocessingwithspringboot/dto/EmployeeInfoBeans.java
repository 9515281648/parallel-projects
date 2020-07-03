package com.jsfsfeb.homeloanprocessingwithspringboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
//import lombok.ToString;
 


@Data
@Entity
@Table(name="employee")
public class EmployeeInfoBeans {
	@Id
	@Column
	 private String userName;
	@Column
	 private String email;
	@Column
	 private long mobileNumber;
//	 @ToString.Exclude
	@Column
	 private String password;
	 
  
 
	
	 
	 

}
