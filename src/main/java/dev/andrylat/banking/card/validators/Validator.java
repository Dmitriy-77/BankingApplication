package dev.andrylat.banking.card.validators;

import java.util.List;

public interface Validator {
    public List<String> validate (String CardNumber);    	
    
}
