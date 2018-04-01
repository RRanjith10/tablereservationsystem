package com.mindtree.table.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.table.reservation.entity.Customer;
import com.mindtree.table.reservation.repository.CustomerRepository;

@Service
public class CustomerRegistrationService {
    @Autowired
    CustomerRepository customerRepo;

    public Customer searchCustomer(String emailId) {

        return customerRepo.findByEmailId(emailId);

    }

    public Customer saveCustomer(Customer saveCust) {
        return customerRepo.save(saveCust);

    }

    public boolean checkLogin(String emailId, String password) {
        Customer loginCust = customerRepo.findByEmailId(emailId);
        if (loginCust != null && loginCust.getEmailId().equals(emailId) && loginCust.getPassword().equals(password)) {
            return true;
        }
        return false;

    }

}
