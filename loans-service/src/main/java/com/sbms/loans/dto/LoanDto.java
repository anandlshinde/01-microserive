/**
 * Author: Sameera De Silva
 * User:anand
 * Date:25-05-2024
 * Time:03:44 pm
 */

package com.sbms.loans.dto;

import lombok.Data;

@Data
public class LoanDto {
    private String mobileNumber;
    private String loanNumber;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
}
