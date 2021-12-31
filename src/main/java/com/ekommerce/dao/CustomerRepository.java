package com.ekommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekommerce.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
