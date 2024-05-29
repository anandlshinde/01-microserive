package com.sbms.cards;

import com.sbms.cards.dto.CardsContactInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CardsContactInfo.class)
public class CardsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsServiceApplication.class, args);
	}

}
