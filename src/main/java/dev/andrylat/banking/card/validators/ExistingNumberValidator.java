package dev.andrylat.banking.card.validators;

import java.util.ArrayList;
import java.util.List;


public class ExistingNumberValidator implements CardValidator {
    
    private static final String REPLY_MESSAGE_NOT_CORRECT = "Card number is not correct";
    
    @Override
    public List<String> validate(String cardNumber) {
        List<String> errorMessages = new ArrayList<>();
        int[] digitsOfCardNumber = convertStringToInteger(cardNumber);
        boolean isCorrectNumberCard = checkControlSum(digitsOfCardNumber);
        
        if(!isCorrectNumberCard) {
            errorMessages.add(REPLY_MESSAGE_NOT_CORRECT);
        }
        
        return errorMessages;
    }
    
    private int[] convertStringToInteger(String cardNumber) {
        
        char[] charsOfCardNumber = cardNumber.toCharArray();
        int[] digitsOfCardNumber = new int[charsOfCardNumber.length];
        
        for(int i = 0; i < charsOfCardNumber.length; i++) {
            digitsOfCardNumber[i] = Character.getNumericValue(charsOfCardNumber[i]);
        }
        
        return digitsOfCardNumber;
    }
    
    private boolean checkControlSum(int[] digitsOfCardNumber) {
        int sumOfAllDigits = 0;
        int[] tempDigitsOfCardNumber = new int[digitsOfCardNumber.length];
        
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
}
