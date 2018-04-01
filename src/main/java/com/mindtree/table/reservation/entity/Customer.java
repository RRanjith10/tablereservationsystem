package com.mindtree.table.reservation.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @Column
    @ApiModelProperty(notes = "Email id of the customer who has did reservation")
    private String emailId;
    @Column
    @ApiModelProperty(notes = "Password enterred by the customer")
    private String password;
    @Column
    @ApiModelProperty(notes = "Customer name")
    private String custName;
    @Column
    @ApiModelProperty(notes = "Customer mobile number")
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
