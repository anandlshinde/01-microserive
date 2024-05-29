package com.sbms.loans.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;
import java.util.Map;


@RefreshScope
@ConfigurationProperties(prefix = "loans")
@Setter
@Getter
public class LoansContactInfo {

	private String message;
	private Map<String,String> contactDetails;
	private List<String> onCallSupport;
	
}