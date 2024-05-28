package com.javaexpress.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.javaexpress.accounts.dto.AccountsContactInfo;


@SpringBootApplication
@EnableConfigurationProperties(AccountsContactInfo.class)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}
	

}
