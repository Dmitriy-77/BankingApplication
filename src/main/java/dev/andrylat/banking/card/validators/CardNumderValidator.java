package dev.andrylat.banking.card.validators;

import java.util.ArrayList;
import java.util.List;

public class CardNumderValidator {
    final static String REPLY_MASSAGE_CORRECT = "Card number is correct";
    final static String REPLY_MESSAGE_NOT_CORRECT = "Card number is not correct";
    final static String REPLY_MESSAGE_ENTERED_INCORRECT_AMOUNT_DIGITS = "You entered incorrect ammount of digits";
    final static String REPLY_MESSAGE_ENTERED_LETTER_OR_CHAR = "You entered a letter or char";
    final static int SIZE_NUMBER_OF_CARD = 16;
    
    public List<String> processCheckDigit(String cardNumber) {		
        
        char[] cardNumberChars = cardNumber.toCharArray();
        
        List<String> responseToUser = new ArrayList<>();
        
        boolean onlyDigits = areDigitsOnly(cardNumberChars);
        boolean amountDigits = checksAmountOfDigits(cardNumberChars);
        boolean numberOfCardIsCorrect;
        
        if(onlyDigits == false) {
            responseToUser.add(REPLY_MESSAGE_ENTERED_LETTER_OR_CHAR);
        }
        if(amountDigits == false) {
            responseToUser.add(REPLY_MESSAGE_ENTERED_INCORRECT_AMOUNT_DIGITS);
        }
        if(responseToUser.isEmpty()) {
            int [] digitsOfCardNumber = convertCharToInteger(cardNumberChars);
            numberOfCardIsCorrect = checksThatNumberIsCorrect(digitsOfCardNumber);
            if(numberOfCardIsCorrect == false) {
                responseToUser.add(REPLY_MESSAGE_NOT_CORRECT);
            } else {
                responseToUser.add(REPLY_MASSAGE_CORRECT);
            }
        }
        
        return responseToUser;
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
        if(charsOfCardNumber.length == SIZE_NUMBER_OF_CARD) {
            return true;
        } else {
            return false;
        }
    }        
    
    public boolean checksThatNumberIsCorrect(int[] digitsOfCardNumber) {
        int sumOfAllDigits = 0;
        int[] tempDigitsOfCardNumber = new int[SIZE_NUMBER_OF_CARD];
        
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
        int[] digitsOfCardNumber = new int[SIZE_NUMBER_OF_CARD];
        
        for(int i = 0; i < charsOfCardNumber.length; i++) {
            digitsOfCardNumber[i] = Character.getNumericValue(charsOfCardNumber[i]);
        }
        
        return digitsOfCardNumber;
    }
}
