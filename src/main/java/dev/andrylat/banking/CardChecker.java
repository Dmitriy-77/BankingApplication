package dev.andrylat.banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.andrylat.banking.card.validators.CardNumderValidator;

public class CardChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardNumderValidator cardNumberValidator = new CardNumderValidator();
        
        System.out.println("Enter card number");
        
        String cardNumber = scanner.nextLine();
        for(String result: cardNumberValidator.processCheckDigit(cardNumber)) {
        	System.out.println(result);
        }
    }
}
