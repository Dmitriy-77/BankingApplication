package dev.andrylat.banking.card.validators;

import java.util.ArrayList;
import java.util.List;

import dev.andrylat.banking.Validator;

public class CardNumderValidator implements Validator<String>{
    
    @Override
    public List<String> validate(String cardNumber) {		
        
        Validator enteredDataValidator  = new ActualDataTemplateValidator();
        Validator numberValidator = new ExistingNumberValidator();
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
