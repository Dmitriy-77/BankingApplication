package dev.andrylat.banking.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.andrylat.banking.card.datacontainers.PaymentSystem;
import dev.andrylat.banking.card.validators.CardNumderValidator;
import dev.andrylat.banking.interfaces.Dialoque;
import dev.andrylat.banking.interfaces.Validator;

public class CardCheckerDialoque implements Dialoque{

    @Override
    public void start() {
        Scanner scanner =  new Scanner(System.in);
        
    	System.out.println("Enter card number");
    	String cardNumber = scanner.nextLine();
        
        Validator validator = new CardNumderValidator();
        
        List<String> errorMessages = validator.validate(cardNumber);
        
        if(errorMessages.isEmpty()) {
            String namePaymentSystem = PaymentSystem.showNamePaymentSystem(cardNumber);
            System.out.println(namePaymentSystem);
        } else {
            for(String result: errorMessages) {
                System.out.println(result);
            }
        }
    }
}
