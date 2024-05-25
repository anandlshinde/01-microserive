package com.sbms.cards.service.impl;

import com.sbms.cards.dto.CardDto;
import com.sbms.cards.entity.Card;
import com.sbms.cards.exception.CardAlreadyExistsException;
import com.sbms.cards.exception.CardNotFoundException;
import com.sbms.cards.repository.CardRepository;
import com.sbms.cards.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    @Override
    public void createCard(String mobileNumber) {
        Optional<Card> card = cardRepository.findByMobileNumber(mobileNumber);
        if(card.isPresent()) {
            throw new CardAlreadyExistsException("Card already exists with mobileNumber : " + mobileNumber);
        }
        createNewCard(mobileNumber);
    }

    private void createNewCard(String mobileNumber) {
        Card card=new Card();
        card.setMobileNumber(mobileNumber);
        card.setCardType("CREDIT_CARD");
        card.setTotalLimit(100000);
        card.setAmountUsed(20000);
        card.setAvailableAmount(80000);
        card.setCardNumber(generateCardNumber());
        cardRepository.save(card);
    }

    private String generateCardNumber(){
        long smallest = 1000_0000_0000_0000L;
        long biggest =  9999_9999_9999_9999L;
        return String.valueOf(ThreadLocalRandom.current().nextLong(smallest, biggest+1));
    }

    @Override
    public CardDto fetchCardDetails(String mobileNumber) {
        Card card=cardRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new CardAlreadyExistsException("Card already exists with mobileNumber : "+mobileNumber));
        CardDto cardDto=new CardDto();
        BeanUtils.copyProperties(card, cardDto);
        return cardDto;
    }

    @Override
    public boolean updateCardDetails(CardDto cardDto) {
        Card card=cardRepository.findByCardNumber(cardDto.getCardNumber())
                .orElseThrow(() -> new CardNotFoundException("Card number not found : "+cardDto.getCardNumber()));

        BeanUtils.copyProperties(cardDto, card);
        cardRepository.save(card);
        return true;
    }

    @Override
    public boolean deleteCardDetails(String mobileNumber) {
        Card card=cardRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new CardNotFoundException("mobileNumber not associated with any card : "+mobileNumber));
        cardRepository.deleteById(card.getCardId());
        return true;
    }
}
