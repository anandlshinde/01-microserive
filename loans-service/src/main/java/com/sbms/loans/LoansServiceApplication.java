package com.sbms.loans;

import com.sbms.loans.dto.LoansContactInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(LoansContactInfo.class)
public class LoansServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansServiceApplication.class, args);
	}

}
