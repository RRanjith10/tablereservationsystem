package com.mindtree.table.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.table.reservation.entity.Customer;
import com.mindtree.table.reservation.entity.Hotels;
import com.mindtree.table.reservation.repository.CustomerRepository;
import com.mindtree.table.reservation.repository.HotelRepository;

@Service
public class CustomerRegistrationService {
	@Autowired
	CustomerRepository customerRepo;
	
	public Customer searchCustomer(String emailId){
		
		return customerRepo.findByEmailId(emailId);
		
	}
	
public Customer saveCustomer(Customer saveCust){
		//System.out.println(saveCust.getPassword());
		return customerRepo.save(saveCust);
		
	}

public boolean checkLogin(String emailId, String password) {
	// TODO Auto-generated method stub
	Customer loginCust = customerRepo.findByEmailId(emailId);
	if(loginCust!=null && loginCust.getEmailId().equals(emailId) && loginCust.getPassword().equals(password)){
		return true;
	}
	return false;
	
}
	
}
