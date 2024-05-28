package com.sbms.accounts.dto;

import lombok.Data;

/**
 * @author anand
 *
 */
@Data
public class CustomerDto {
	
	private String name;
	private String mobileNumber;
	private String email;
	private AccountDto accountDto;

}
