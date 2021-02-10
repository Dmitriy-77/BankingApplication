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
        
        System.out.println("������� ����� �������");
        String creditAmount = scanner.nextLine();
        
        System.out.println("������� ���������� ������");
        String interestRate = scanner.nextLine();
        
        System.out.println("������ ���� �� ��������� �������: �� 1 �� 30 ���");
        String timingCredit = scanner.nextLine();
        
        System.out.println("������� ��������� ����� � ���������� ����������� � ����� �������");
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
