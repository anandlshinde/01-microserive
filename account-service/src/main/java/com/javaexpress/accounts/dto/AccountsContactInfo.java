package com.javaexpress.accounts.dto;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;



@RefreshScope
@ConfigurationProperties(prefix = "accounts")
@Setter
@Getter
public class AccountsContactInfo {

	private String message;
	private Map<String,String> contactDetails;
	private List<String> onCallSupport;
	
}