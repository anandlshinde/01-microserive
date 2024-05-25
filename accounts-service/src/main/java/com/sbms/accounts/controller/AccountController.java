package com.sbms.accounts.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sbms.accounts.dto.CustomerDto;
import com.sbms.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author anand
 *
 */
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class AccountController {
	
		private final AccountService accountService;
	
	
		@PostMapping("/create")
		public String createAccount(@RequestBody CustomerDto customerDto) {
			log.info("create Account api called");
			accountService.createAccount(customerDto);
			return "Account created successfully";
		}
		
		@GetMapping("/fetch")
		public CustomerDto fetchAccountDetails(@RequestParam String mobileNumber) {
			return accountService.fetchAccountDetails(mobileNumber);
		}
		
		@PutMapping("/update")
		public Boolean updateAccountDetails(@RequestBody CustomerDto customerDto) {
			return accountService.updateAccount(customerDto);
		}
		
		@DeleteMapping("/delete")
		public Boolean deleteAccountDetails(@RequestParam String mobileNumber) {
			return accountService.deleteAccount(mobileNumber);
		}
}
