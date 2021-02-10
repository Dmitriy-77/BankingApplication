package dev.andrylat.banking.mortgage.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MortgageCalculator{
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        List<String> errorMessages =  new ArrayList<>();
        DataValidator validator = new MortgageDataValidator();
        CalculatorPayments calculate = new CalculatorPayments();
        
        System.out.println("¬ведите сумму кредита");
        String creditAmount = scanner.nextLine();
        
        System.out.println("¬ведите процентную ставку");
        String interestRate = scanner.nextLine();
        
        System.out.println("¬ведит срок на погашение кредита: ќт 1 до 30 лет");
        String timingCredit = scanner.nextLine();
        
        System.out.println("¬ведите авансовый платЄж в процентном соотнешении к сумме кредита");
        String prepayment = scanner.nextLine();
        
        errorMessages = validator.validate(creditAmount, interestRate, timingCredit, prepayment);
        
        if(errorMessages.isEmpty()) {
            List<String> paymentResult = calculate.calculator(creditAmount, interestRate, timingCredit, prepayment);
            
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
