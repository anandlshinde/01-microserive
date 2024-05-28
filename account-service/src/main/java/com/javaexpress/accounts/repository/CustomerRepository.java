package com.javaexpress.accounts.repository;

import java.util.Optional;

import com.javaexpress.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author anand
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	
	Optional<Customer> findByMobileNumber(String mobileNumber);

}
