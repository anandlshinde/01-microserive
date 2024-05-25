package com.sbms.cards.service;

import com.sbms.cards.dto.CardDto;

public interface CardService {
    void createCard(String mobileNumber);

    CardDto fetchCardDetails(String mobileNumber);

    boolean updateCardDetails(CardDto cardDto);

    boolean deleteCardDetails(String mobileNumber);
}
