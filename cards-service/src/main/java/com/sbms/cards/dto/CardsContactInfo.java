package com.sbms.cards.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;
import java.util.Map;


@RefreshScope
@ConfigurationProperties(prefix = "cards")
@Setter
@Getter
public class CardsContactInfo {

	private String message;
	private Map<String,String> contactDetails;
	private List<String> onCallSupport;
	
}