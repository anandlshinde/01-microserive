package com.sbms.accounts.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbms.accounts.dto.CardDto;


@FeignClient("CARDS")
public interface CardClient {
	
	 	@GetMapping("api/v1/fetch")
	    public CardDto fetchCardDetails(@RequestParam String mobileNumber);

}
