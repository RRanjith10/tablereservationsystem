package com.mindtree.table.reservation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotels {
	@Id
	int hid;
	String hname;
	String address;
	String city;
	String state;
	
	public Hotels() {
		super();
	}
	public Hotels(int hid, String hname, String address, String city, String state) {
		super();
		this.hid = hid;
		this.hname = hname;
		this.address = address;
		this.city = city;
		this.state = state;
		
	}
	
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
