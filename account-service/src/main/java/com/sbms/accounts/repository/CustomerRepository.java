package com.sbms.accounts.repository;

import java.util.Optional;

import com.sbms.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author anand
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	
	Optional<Customer> findByMobileNumber(String mobileNumber);

}
