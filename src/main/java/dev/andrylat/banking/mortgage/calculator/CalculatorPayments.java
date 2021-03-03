package dev.andrylat.banking.mortgage.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPayments {
    
    private static final String MESSAGE_FIRST_INSTALLMENT = "First installment - ";
    private static final String MESSAGE_CREDIT_AMOUNT = "Credit amount - ";
    private static final String MESSAGE_MONTHS_PAYMENT = "Months of payment - ";
    private static final String MESSAGE_MAIN_PAYMENT_PER_MONTH = "Main payment per month - ";
    private static final String MESSAGE_OVERALL_PAYMENT = "Overall payment- ";
    private static final String MESSAGE_INTEREST_PAYMENT = "Interest payment - ";
    private static final String MESSAGE_LOAN_BALANCE = "Loan balance - ";
    
    double firstInstallment;
    double finalLoanAmount;
    double amountMonthPayment;
    double mainPaymentPerMonth;
    double summaViplachenyhProcentov;
    double loanBalance = finalLoanAmount;
    
    public List<String> calculator (CreditData creditData) {
        List<String> result =  new ArrayList<>();
        
        double creditAmount = Double.parseDouble(creditData.getCreditAmount());
        double interestRate = Double.parseDouble(creditData.getInterestRate());
        double timingCredit = Double.parseDouble(creditData.getTimingCredit());
        double prepayment = Double.parseDouble(creditData.getPrepayment());
	    
        firstInstallment = creditAmount * prepayment / 100;
        finalLoanAmount = creditAmount - firstInstallment;
        amountMonthPayment = timingCredit * 12;
        mainPaymentPerMonth = finalLoanAmount / amountMonthPayment;
        loanBalance = finalLoanAmount;
        
        result.add(MESSAGE_FIRST_INSTALLMENT + Double.toString(firstInstallment));
        result.add(MESSAGE_CREDIT_AMOUNT + Double.toString(finalLoanAmount));
        
        for(int i = 0; i < amountMonthPayment; i++) {
            
            double monthlyInterestPayment = loanBalance * interestRate / 100 / 12;
            double generalPlatej = monthlyInterestPayment + mainPaymentPerMonth;
            loanBalance = loanBalance - mainPaymentPerMonth;            
            
            result.add(generalPlatej + Double.toString(generalPlatej) + "; " 
                                     + loanBalance + Double.toString(loanBalance));
        }
	    return result;
	}
}
