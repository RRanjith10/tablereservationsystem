package com.mindtree.table.reservation.entity;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;


@Entity
public class Customer {
	@Id
	@Column 
	private String emailId;
	@Column 
	private String password;
	@Column
    private String custName;
	
	@Column
	private String phoneNo;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Customer(String emailId, String password, String custName, String phoneNo) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.custName = custName;
		this.phoneNo = phoneNo;
	}

	public Customer() {
		super();
			}
	
   
}
