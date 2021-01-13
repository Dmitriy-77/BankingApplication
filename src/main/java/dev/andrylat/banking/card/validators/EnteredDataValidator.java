package dev.andrylat.banking.card.validators;

import java.util.ArrayList;
import java.util.List;

public class EnteredDataValidator implements DataValidator {
	
    private static final String REPLY_MESSAGE_ENTERED_INCORRECT_AMOUNT_DIGITS = "You entered incorrect ammount of digits";
    private static final String REPLY_MESSAGE_ENTERED_LETTER_OR_CHAR = "You entered a letter or char";
    private static final int CARD_NUMBER_SIZE = 16;
    
    @Override
    public List<String> validate(String cardNumber) {
        
        char[] cardNumberChars = cardNumber.toCharArray();
        
        List<String> errorMessages = new ArrayList<>();
        
        boolean onlyDigits = areDigitsOnly(cardNumberChars);
        boolean amountDigits = areAmountOfDigits(cardNumberChars);
        
        if(!onlyDigits) {
            errorMessages.add(REPLY_MESSAGE_ENTERED_LETTER_OR_CHAR);
        }
        if(!amountDigits) {
            errorMessages.add(REPLY_MESSAGE_ENTERED_INCORRECT_AMOUNT_DIGITS);
        }        
        
        return errorMessages;
    }
    
    private boolean areDigitsOnly(char[] charsOfCardNumber) {
        for(int i = 0; i < charsOfCardNumber.length; i++) {
            if(!Character.isDigit(charsOfCardNumber[i])) {
        	return false;
            }
        }
        
        return true;
    }
    
    private boolean areAmountOfDigits(char[] charsOfCardNumber) {
        if(charsOfCardNumber.length == CARD_NUMBER_SIZE) {
            return true;
        } else {
            return false;
        }
    }        
}
