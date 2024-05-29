package com.sbms.accounts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author anand
 *
 */
@Data
public class CustomerDetailsDto {
	
	private String name;
	private String mobileNumber;
	private String email;
	@JsonProperty("accounts")
	private AccountDto accountDto;
	@JsonProperty("cards")
	private CardDto cardDto;
	@JsonProperty("loans")
	private LoanDto loanDto;

}
