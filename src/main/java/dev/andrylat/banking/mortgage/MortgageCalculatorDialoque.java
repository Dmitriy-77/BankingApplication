package dev.andrylat.banking.mortgage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.andrylat.banking.interfaces.Dialoque;
import dev.andrylat.banking.interfaces.Validator;
import dev.andrylat.banking.mortgage.calculator.CalculatorPayments;
import dev.andrylat.banking.mortgage.calculator.LoanCalculationData;
import dev.andrylat.banking.mortgage.datacontainers.InitialCreditData;
import dev.andrylat.banking.mortgage.validators.MortgageDataValidator;

public class MortgageCalculatorDialoque implements Dialoque{
    
    @Override
    public void start() {
        
        Scanner scanner = new Scanner(System.in);
        InitialCreditData creditData = new InitialCreditData();
        
        System.out.println("Enter the loan amount:");
        creditData.setCreditAmount(scanner.nextLine());
        
        System.out.println("Enter interest on the loan:");
        creditData.setInterestRate(scanner.nextLine());
        
        System.out.println("Enter the loan maturity from 1 to 30 years old:");
        creditData.setTimingCredit(scanner.nextLine());
        
        System.out.println("Enter advance interest:");
        creditData.setPrepayment(scanner.nextLine());
        
        printMortgageResult(creditData);
    }
    
    private void printMortgageResult (InitialCreditData creditData) {
                
    	List<String> errorMessages =  new ArrayList<>();
    	Validator validator = new MortgageDataValidator();
    	CalculatorPayments calculate = new CalculatorPayments();
    	LoanCalculationData loanCalculationData = new LoanCalculationData();
        
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
