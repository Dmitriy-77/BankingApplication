package dev.andrylat.banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.andrylat.banking.card.validators.CardNumderValidator;
import dev.andrylat.banking.card.validators.CardValidator;
import dev.andrylat.banking.card.validators.PaymentSystem;

public class CardChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardValidator validator = new CardNumderValidator();
        
        System.out.println("Enter card number");
        
        String cardNumber = scanner.nextLine();
        
        List<String> errorMassages = validator.validate(cardNumber);
        
        if(errorMassages.isEmpty()) {
            String namePaymentSystem = PaymentSystem.identifierPaymentSystem(cardNumber);
            System.out.println(namePaymentSystem);
        } else {
        	for(String result: errorMassages) {
            	System.out.println(result);
            }
        }
    }
}
