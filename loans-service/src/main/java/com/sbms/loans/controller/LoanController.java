/**
 * Author: Sameera De Silva
 * User:anand
 * Date:25-05-2024
 * Time:04:37 pm
 */

package com.sbms.loans.controller;

import com.sbms.loans.dto.LoansContactInfo;
import com.sbms.loans.dto.LoanDto;
import com.sbms.loans.service.LoanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class LoanController {

    private final LoanService loanService;

    private final LoansContactInfo accountsContactInfo;

    @PostMapping("/create")
    public String createLoan(@RequestParam String mobileNumber){
        loanService.createLoan(mobileNumber);
        return "Loan created successfully";
    }

    @GetMapping("/fetch")
    public LoanDto fetchLoan(@RequestParam String mobileNumber){
        return loanService.fetchLoanDetails(mobileNumber);
    }

    @PutMapping("/update")
    public Boolean updateLoan(@RequestBody LoanDto loanDto){
        return loanService.updateLoanDetails(loanDto);
    }

    @DeleteMapping("/delete")
    public Boolean deleteLoan(@RequestParam String mobileNumber){
        return loanService.deleteLoanDetails(mobileNumber);
    }

    @GetMapping("/contact-info")
    public LoansContactInfo getContactInfo() {
        log.info("accountinfo : ");
        return accountsContactInfo;
    }
}
