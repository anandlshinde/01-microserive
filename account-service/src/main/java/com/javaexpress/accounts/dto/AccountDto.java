/**
 * 
 */
package com.javaexpress.accounts.dto;

import lombok.Data;

/**
 * @author anand
 *
 */
@Data
public class AccountDto {

	private Long accountNumber;
	private String accountType;
	private String branchAddress; 
}
