package com.sbms.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbms.accounts.dto.CustomerDetailsDto;
import com.sbms.accounts.service.CustomerService;

import lombok.AllArgsConstructor;

/**
 * @author anand
 *
 */
@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;
	
	
	@GetMapping("/fetchCustomerDetails")
	public CustomerDetailsDto fetchCustomerDetails(@RequestParam String mobileNumber) {
		return customerService.getCustomerDetails(mobileNumber);
	}

}
