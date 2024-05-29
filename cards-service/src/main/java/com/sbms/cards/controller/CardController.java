package com.sbms.cards.controller;

import com.sbms.cards.dto.CardsContactInfo;
import com.sbms.cards.dto.CardDto;
import com.sbms.cards.service.CardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
@Slf4j
public class CardController {

    private final CardService cardService;
    private final CardsContactInfo accountsContactInfo;


    @PostMapping("/create")
    public String createCard(@RequestParam String mobileNumber){
        cardService.createCard(mobileNumber);
        return "Card created successfully";
    }

    @GetMapping("/fetch")
    public CardDto fetchCardDetails(@RequestParam String mobileNumber){
        return cardService.fetchCardDetails(mobileNumber);
    }

    @PutMapping("/update")
    public Boolean updateCardDetails(@RequestBody CardDto cardDto){
        return cardService.updateCardDetails(cardDto);
    }

    @DeleteMapping("/delete")
    public Boolean deleteCardDetails(@RequestParam String mobileNumber){
        return cardService.deleteCardDetails(mobileNumber);
    }

    @GetMapping("/contact-info")
    public CardsContactInfo getContactInfo() {
        log.info("accountinfo : ");
        return accountsContactInfo;
    }
}
