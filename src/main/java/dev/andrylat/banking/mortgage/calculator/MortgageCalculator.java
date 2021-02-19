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
        CreditData creditData = new CreditData();
        
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
            List<String> paymentResult = calculate.calculator(creditData);
            
            for(String result: paymentResult) {
                System.out.println(result);
            }
        } else {
            for(String result: errorMessages) {
                System.out.println(result);
            }
        }
    }
}
