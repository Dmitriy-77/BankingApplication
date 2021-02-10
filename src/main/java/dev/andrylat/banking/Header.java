package dev.andrylat.banking;

import java.util.List;
import java.util.Scanner;

import dev.andrylat.banking.card.validators.CardChecker;
import dev.andrylat.banking.card.validators.CardNumderValidator;
import dev.andrylat.banking.card.validators.CardValidator;
import dev.andrylat.banking.card.validators.PaymentSystem;
import dev.andrylat.banking.mortgage.calculator.MortgageCalculator;

public class Header {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardChecker cardChecker = new CardChecker();
        MortgageCalculator mortgageCalculator = new MortgageCalculator();
        
        System.out.println("Валидация карты: Введите 1");
        System.out.println("Расчёт ипотеки: Введите 2");
        
        String inputNumber = scanner.nextLine();
        String cardNumber;
        
        switch (inputNumber) {
            case "1":
                System.out.println("Введите номер карты");
                cardNumber = scanner.nextLine();
                
                cardChecker.checker(cardNumber);
                break;
                
            case "2":
                mortgageCalculator.calculate();
        }
    }
}
