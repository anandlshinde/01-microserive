package com.sbms.accounts.service;

import com.sbms.accounts.dto.CustomerDto;

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
