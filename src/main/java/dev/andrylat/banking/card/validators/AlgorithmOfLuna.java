package dev.andrylat.banking.card.validators;

public class AlgorithmOfLuna implements NumberValidator{
	private static final int CARD_NUMBER_SIZE = 16;
	
    @Override
    public boolean validate(int[] digitsOfCardNumber) {
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
}
