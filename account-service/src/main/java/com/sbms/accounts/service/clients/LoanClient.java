package com.sbms.accounts.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbms.accounts.dto.LoanDto;


@FeignClient("LOANS")
public interface LoanClient {

	@GetMapping("/api/v1/fetch")
    public LoanDto fetchLoan(@RequestParam String mobileNumber);
}
