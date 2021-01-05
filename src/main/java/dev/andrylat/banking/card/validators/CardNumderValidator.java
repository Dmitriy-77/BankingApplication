package dev.andrylat.banking.card.validators;

import java.util.ArrayList;
import java.util.List;

public class CardNumderValidator implements CardValidator{
    private static final String REPLY_MESSAGE_NOT_CORRECT = "Card number is not correct";
    private static final String REPLY_MESSAGE_ENTERED_INCORRECT_AMOUNT_DIGITS = "You entered incorrect ammount of digits";
    private static final String REPLY_MESSAGE_ENTERED_LETTER_OR_CHAR = "You entered a letter or char";
    private static final int CARD_NUMBER_SIZE = 16;
    
    @Override
    public List<String> validate(String cardNumber) {		
        
        char[] cardNumberChars = cardNumber.toCharArray();
        
        List<String> errorMessages = new ArrayList<>();
        
        boolean onlyDigits = areDigitsOnly(cardNumberChars);
        boolean amountDigits = checksAmountOfDigits(cardNumberChars);
        
        if(!onlyDigits) {
            errorMessages.add(REPLY_MESSAGE_ENTERED_LETTER_OR_CHAR);
        }
        if(!amountDigits) {
            errorMessages.add(REPLY_MESSAGE_ENTERED_INCORRECT_AMOUNT_DIGITS);
        }
        if(errorMessages.isEmpty()) {
            int [] digitsOfCardNumber = convertCharToInteger(cardNumberChars);
            boolean numberOfCardIsCorrect = checkControlSum(digitsOfCardNumber);
            if(!numberOfCardIsCorrect) {
                errorMessages.add(REPLY_MESSAGE_NOT_CORRECT);
            }
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
    
    private boolean checksAmountOfDigits(char[] charsOfCardNumber) {
        if(charsOfCardNumber.length == CARD_NUMBER_SIZE) {
            return true;
        } else {
            return false;
        }
    }        
    
    private boolean checkControlSum(int[] digitsOfCardNumber) {
        int sumOfAllDigits = 0;
        int[] tempDigitsOfCardNumber = new int[CARD_NUMBER_SIZE];
        
        for(int i = 0; i < digitsOfCardNumber.length; i++) {
            if(i%2 == 0) {
                tempDigitsOfCardNumber[i] = digitsOfCardNumber[i]*2;
            } else {
                tempDigitsOfCardNumber[i] = digitsOfCardNumber[i];
            }
        }
        
        for(int i = 0; i < tempDigitsOfCardNumber.length; i++) {
            if(tempDigitsOfCardNumber[i] >= 10) {
                while(tempDigitsOfCardNumber[i] != 0) {
                    sumOfAllDigits += tempDigitsOfCardNumber[i]%10;
                    tempDigitsOfCardNumber[i] = tempDigitsOfCardNumber[i]/10;
                }
            } else {
        	sumOfAllDigits += tempDigitsOfCardNumber[i];
            }
        }
        
        if(sumOfAllDigits%10 == 0) {
            return true;
        } else {
            return false;
        }
    }
        
    private int[] convertCharToInteger(char[] charsOfCardNumber) {
        int[] digitsOfCardNumber = new int[CARD_NUMBER_SIZE];
        
        for(int i = 0; i < charsOfCardNumber.length; i++) {
            digitsOfCardNumber[i] = Character.getNumericValue(charsOfCardNumber[i]);
        }
        
        return digitsOfCardNumber;
    }
}
