package dev.andrylat.banking.mortgage.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MortgageCalculator implements Dialoque{
    
    @Override
    public void start() {
        
        Scanner scanner = new Scanner(System.in);
        List<String> errorMessages =  new ArrayList<>();
        DataValidator validator = new MortgageDataValidator();
        CalculatorPayments calculate = new CalculatorPayments();
        InitialCreditData creditData = new InitialCreditData();
        LoanCalculationData loanCalculationData = new LoanCalculationData();
        
        System.out.println("Enter the loan amount:");
        String creditAmount = scanner.nextLine();
        
        System.out.println("Enter interest on the loan:");
        String interestRate = scanner.nextLine();
        
        System.out.println("Enter the loan maturity from 1 to 30 years old:");
        String timingCredit = scanner.nextLine();
        
        System.out.println("Enter advance interest:");
        String prepayment = scanner.nextLine();
        
        creditData.setCreditAmount(creditAmount);
        creditData.setInterestRate(interestRate);
        creditData.setTimingCredit(timingCredit);
        creditData.setPrepayment(prepayment);
        
        errorMessages = validator.validate(creditData);
        
        if(errorMessages.isEmpty()) {
            calculate.calculator(creditData);
            
            System.out.println("First installment - " + loanCalculationData.getFirstInstallment());
            System.out.println("Credit amount - " + loanCalculationData.getFinalLoanAmount());
            System.out.println("Main payment per month - " + loanCalculationData.getMainPaymentPerMonth());
            System.out.println("Amount month payment - " + loanCalculationData.getAmountMonthPayment());
        } else {
            for(String result: errorMessages) {
                System.out.println(result);
            }
        }
    }
}
