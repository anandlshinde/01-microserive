package com.sbms.cards.controller;

import com.sbms.cards.dto.CardDto;
import com.sbms.cards.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class CardController {

    private final CardService cardService;

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
}
