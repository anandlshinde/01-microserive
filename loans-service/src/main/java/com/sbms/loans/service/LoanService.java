package com.sbms.loans.service;

import com.sbms.loans.dto.LoanDto;

public interface LoanService {

    public void createLoan(String mobileNumber);

    public LoanDto fetchLoanDetails(String mobileNumber);

    public boolean updateLoanDetails(LoanDto loansDto);

    public boolean deleteLoanDetails(String mobileNumber);



}
