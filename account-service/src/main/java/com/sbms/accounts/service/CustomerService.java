package com.sbms.accounts.service;

import com.sbms.accounts.dto.CustomerDetailsDto;

/**
 * @author anand
 *
 */
public interface CustomerService {
	
	CustomerDetailsDto getCustomerDetails(String mobileNumber);

}
