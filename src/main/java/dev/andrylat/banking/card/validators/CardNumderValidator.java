package dev.andrylat.banking.card.validators;

import java.util.ArrayList;
import java.util.List;

public class CardNumderValidator implements Validator{
    
    @Override
    public List<String> validate(String cardNumber) {		
        
        Validator enteredDataValidator  = new EnteredDataValidator();
        Validator numberValidator = new NumberValidator();
        List<String> errorMessages = new ArrayList<>();
        
        errorMessages = enteredDataValidator.validate(cardNumber);
        
        if(!errorMessages.isEmpty()) {
            return errorMessages;
        } else {
        	errorMessages = numberValidator.validate(cardNumber);
        }
        
        return errorMessages;
    }
}
