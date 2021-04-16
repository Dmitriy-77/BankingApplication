package dev.andrylat.banking.mortgage.calculator;

import java.util.ArrayList;
import java.util.List;

import dev.andrylat.banking.mortgage.datacontainers.InitialCreditData;

public class CalculatorPayments {
    
    LoanCalculationData loanCalculationData = new LoanCalculationData();
    
    public void calculator (InitialCreditData creditData) {
        
        double creditAmount = Double.parseDouble(creditData.getCreditAmount());
        double timingCredit = Double.parseDouble(creditData.getTimingCredit());
        double prepayment = Double.parseDouble(creditData.getPrepayment());
        
        loanCalculationData.setFirstInstallment(creditAmount * prepayment / 100);
        loanCalculationData.setFinalLoanAmount(creditAmount - loanCalculationData.getFirstInstallment());
        loanCalculationData.setAmountMonthPayment(timingCredit * 12);
        loanCalculationData.setMainPaymentPerMonth(loanCalculationData.getFinalLoanAmount()
                                                  /loanCalculationData.getAmountMonthPayment());
	}
}
