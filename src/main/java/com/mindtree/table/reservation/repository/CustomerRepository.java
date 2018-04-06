package com.mindtree.table.reservation.repository;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.table.reservation.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
    public Customer findByEmailId(String emailId);

    public Customer save(Customer c);

}
