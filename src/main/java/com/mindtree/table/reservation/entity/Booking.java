package com.mindtree.table.reservation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Booking {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int bookingId;
String bookedDate;
Long billTotal;

@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name = "hid", nullable=false)
private Hotels hotel;


@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name = "emailId", nullable=false)
private Customer customer;


public int getBookingId() {
	return bookingId;
}


public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}


public String getBookedDate() {
	return bookedDate;
}


public void setBookedDate(String bookedDate) {
	this.bookedDate = bookedDate;
}


public Long getBillTotal() {
	return billTotal;
}


public void setBillTotal(Long billTotal) {
	this.billTotal = billTotal;
}


public Hotels getHotel() {
	return hotel;
}


public void setHotel(Hotels hotel) {
	this.hotel = hotel;
}


public Customer getCustomer() {
	return customer;
}


public void setCustomer(Customer customer) {
	this.customer = customer;
}


public Booking(int bookingId, String bookedDate, Long billTotal, Hotels hotel, Customer customer) {
	super();
	this.bookingId = bookingId;
	this.bookedDate = bookedDate;
	this.billTotal = billTotal;
	this.hotel = hotel;
	this.customer = customer;
}


public Booking() {
	super();
}

}