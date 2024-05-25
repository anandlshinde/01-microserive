/**
 * Author: Sameera De Silva
 * User:anand
 * Date:25-05-2024
 * Time:03:46 pm
 */

package com.sbms.loans.service.impl;

import com.sbms.loans.dto.LoanDto;
import com.sbms.loans.entity.Loan;
import com.sbms.loans.exception.LoanAlreadyExistsException;
import com.sbms.loans.exception.ResourceNotFoundException;
import com.sbms.loans.repository.LoanRepository;
import com.sbms.loans.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loan> loan = loanRepository.findByMobileNumber(mobileNumber);
        if(loan.isPresent()){
            throw new LoanAlreadyExistsException("Loan already registered with mobile number : "+mobileNumber);
        }
        loanRepository.save(createNewLoan(mobileNumber));
    }

    private Loan createNewLoan(String mobileNumber) {
        Loan loan=new Loan();
        loan.setLoanNumber(generateLoanNumber());
        loan.setMobileNumber(mobileNumber);
        loan.setLoanType("HOME_LOAN");
        loan.setTotalLoan(1000000);
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(1000000);
        return loan;
    }

    private String generateLoanNumber(){
        long smallest = 1000_0000_0000_0000L;
        long biggest =  9999_9999_9999_9999L;
        return String.valueOf(ThreadLocalRandom.current().nextLong(smallest, biggest+1));
    }

    @Override
    public LoanDto fetchLoanDetails(String mobileNumber) {
        Loan loan=loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not associated with mobile number : "+mobileNumber));
        LoanDto loanDto=new LoanDto();
        BeanUtils.copyProperties(loan, loanDto);
        return loanDto;
    }

    @Override
    public boolean updateLoanDetails(LoanDto loansDto) {
        Loan loan=loanRepository.findByLoanNumber(loansDto.getLoanNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found LoanNumber : "+loansDto.getLoanNumber()));
    BeanUtils.copyProperties(loansDto, loan);
    loanRepository.save(loan);
        return true;
    }

    @Override
    public boolean deleteLoanDetails(String mobileNumber) {
        Loan loan=loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not associated with mobile number : "+mobileNumber));
        loanRepository.deleteById(loan.getLoanId());
        return true;
    }
}
