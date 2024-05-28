package com.javaexpress.accounts.service;

import com.javaexpress.accounts.dto.CustomerDto;

/**
 * @author anand
 *
 */
public interface AccountService {
	
	void createAccount(CustomerDto customerDto);
	
	CustomerDto fetchAccountDetails(String mobileNumber);
	
	boolean updateAccount(CustomerDto customerDto);
	
	boolean deleteAccount(String mobileNumber);

}
