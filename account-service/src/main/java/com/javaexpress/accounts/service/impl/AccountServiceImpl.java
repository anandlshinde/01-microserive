package com.javaexpress.accounts.service.impl;

import java.util.Optional;
import java.util.Random;

import com.javaexpress.accounts.dto.AccountDto;
import com.javaexpress.accounts.dto.CustomerDto;
import com.javaexpress.accounts.entity.Account;
import com.javaexpress.accounts.entity.Customer;
import com.javaexpress.accounts.exception.CustomerAlreadyExistsException;
import com.javaexpress.accounts.exception.ResourceNotFoundException;
import com.javaexpress.accounts.mapper.AccountMapper;
import com.javaexpress.accounts.mapper.CustomerMapper;
import com.javaexpress.accounts.repository.AccountRepository;
import com.javaexpress.accounts.repository.CustomerRepository;
import com.javaexpress.accounts.service.AccountService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

/**
 * @author anand
 *
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository accountRepository;
	private final CustomerRepository customerRepository;

	@Override
	public void createAccount(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		//Convert customerDto to Customer entity
		Customer customer= CustomerMapper.mapToCustomer(customerDto, new Customer());
		// validate mobileNumber in database
		Optional<Customer> cutomerObj=customerRepository.findByMobileNumber(customerDto.getMobileNumber());
		if(cutomerObj.isPresent()) {
			throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber : "+customerDto.getMobileNumber());
		}
		//save customer information database
		var registeredCustomer=customerRepository.save(customer);
		
		//create new account
		accountRepository.save(createNewAccount(registeredCustomer));
		
	}

	/**
	 * @param registeredCustomer
	 */
	private Account createNewAccount(Customer registeredCustomer) {
		Account account=new Account();
		account.setCustomerId(registeredCustomer.getCustomerId());
		account.setAccountType("SAVINGS");
		account.setBranchAddress("Hadapsar pune");
		Long randomAccountNumber=10000000L + new Random().nextInt(900000000);
		account.setAccountNumber(randomAccountNumber);
		return account;
	}

	@Override
	public CustomerDto fetchAccountDetails(String mobileNumber) {
		Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				() -> new ResourceNotFoundException("Customer mobileNumber not found : "+mobileNumber));
		Account account=accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Account not found for mobileNumber : "+mobileNumber));
		CustomerDto customerDto=CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
		customerDto.setAccountDto(AccountMapper.mapToAccountDto(account, new AccountDto()));
		return customerDto;
	}

	@Override
	public boolean updateAccount(CustomerDto customerDto) {
		boolean isUpdated=false;
		var accountDto=customerDto.getAccountDto();
		if(accountDto!=null) {
			Account account=accountRepository.findById(accountDto.getAccountNumber()).orElseThrow(
					() -> new ResourceNotFoundException("Account number not found : "+accountDto.getAccountNumber()));
			AccountMapper.mapToAccount(accountDto,account);
			accountRepository.save(account);
			
			Long customerId=account.getCustomerId();
			Customer customer=customerRepository.findById(customerId).orElseThrow(
					() -> new ResourceNotFoundException("CustomerId not found : "+account.getCustomerId()));
			CustomerMapper.mapToCustomer(customerDto, customer);
			customerRepository.save(customer);
			isUpdated=true;
		}else {
			throw new RuntimeException("Update operation failed, please try again or contact ");
		}
		
		return isUpdated;
	}

	@Override
	public boolean deleteAccount(String mobileNumber) {
		Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				() -> new ResourceNotFoundException("Customer mobileNumber not found : "+mobileNumber));
		
		accountRepository.deleteByCustomerId(customer.getCustomerId());
		accountRepository.deleteById(customer.getCustomerId());
		return true;
	}

}
