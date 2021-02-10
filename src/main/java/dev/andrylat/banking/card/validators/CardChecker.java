package dev.andrylat.banking.card.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardChecker {

    public void checker(String cardNumber) {
    	
        CardValidator validator = new CardNumderValidator();
        
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
