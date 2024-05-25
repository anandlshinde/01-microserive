package com.sbms.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbms.accounts.entity.Customer;

/**
 * @author anand
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	
	Optional<Customer> findByMobileNumber(String mobileNumber);

}
