package dev.andrylat.banking.card.validators;

import java.util.ArrayList;
import java.util.List;

public class CardNumderValidator implements CardValidator{
    
    @Override
    public List<String> validate(String cardNumber) {		
        
        CardValidator enteredDataValidator  = new ActualDataTemplateValidator();
        CardValidator numberValidator = new ExistingNumberValidator();
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
