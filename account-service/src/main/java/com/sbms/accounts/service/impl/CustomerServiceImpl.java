/**
 * 
 */
package com.sbms.accounts.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sbms.accounts.dto.AccountDto;
import com.sbms.accounts.dto.CardDto;
import com.sbms.accounts.dto.CustomerDetailsDto;
import com.sbms.accounts.dto.LoanDto;
import com.sbms.accounts.entity.Account;
import com.sbms.accounts.entity.Customer;
import com.sbms.accounts.exception.ResourceNotFoundException;
import com.sbms.accounts.repository.AccountRepository;
import com.sbms.accounts.repository.CustomerRepository;
import com.sbms.accounts.service.CustomerService;
import com.sbms.accounts.service.clients.CardClient;
import com.sbms.accounts.service.clients.LoanClient;

import lombok.AllArgsConstructor;

/**
 * @author anand
 *
 */
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{
	
	private final CardClient cardClient;
	
	private final LoanClient loanClient;
	
	private final AccountRepository accountRepository;
	
	private final CustomerRepository customerRepository;

	@Override
	public CustomerDetailsDto getCustomerDetails(String mobileNumber) {
		// TODO Auto-generated method stub
		
		Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				() -> new ResourceNotFoundException("Customer mobileNumber not found : "+mobileNumber));
		Account account=accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Account not found for mobileNumber : "+mobileNumber));
		
		CardDto cardDto=cardClient.fetchCardDetails(mobileNumber);
	    LoanDto loanDto=loanClient.fetchLoan(mobileNumber);
	    
	    CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
	    BeanUtils.copyProperties(customer, customerDetailsDto);
	    
	    AccountDto accountDto=new AccountDto();
	    BeanUtils.copyProperties(account, accountDto);
	    customerDetailsDto.setAccountDto(accountDto);
	    
	    if(cardDto!=null) {
	    	customerDetailsDto.setCardDto(cardDto);
	    }
	    if(loanDto!=null) {
	    	customerDetailsDto.setLoanDto(loanDto);
	    }
	    
	    return customerDetailsDto;
		
	}

}
