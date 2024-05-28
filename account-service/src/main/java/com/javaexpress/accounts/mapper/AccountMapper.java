/**
 * 
 */
package com.javaexpress.accounts.mapper;


import com.javaexpress.accounts.dto.AccountDto;
import com.javaexpress.accounts.entity.Account;

/**
 * @author anand
 *
 */
public class AccountMapper {
	
	public static AccountDto mapToAccountDto(Account account, AccountDto accountDto) {
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setAccountType(account.getAccountType());
		accountDto.setBranchAddress(account.getBranchAddress());
		return accountDto;
	}
	
	public static Account mapToAccount(AccountDto accountDto,Account account) {
		account.setAccountNumber(accountDto.getAccountNumber());
		account.setAccountType(accountDto.getAccountType());
		account.setBranchAddress(accountDto.getBranchAddress());
		return account;
	}
	
	

}
