package Banking_Utilities;

public class CardNumderValidator {
    final static String REPLY_MASSAGE_CORRECT = "Card number is correct";
    final static String REPLY_MESSAGE_NOT_CORRECT = "Card number is not correct";
    final static int SIZE_NUMBER_OF_CARD = 16;
    
    protected String processCheckDigit(String cardNumber) {		
        
       char[] cardNumberChars = cardNumber.toCharArray();
        
        boolean onlyDigits = areDigitsOnly(cardNumberChars);
        boolean amountDigits = checksAmountOfDigits(cardNumberChars);
        
        if(onlyDigits == true && amountDigits == true) {
            int [] digitsOfCardNumber = convertCharToInteger(cardNumberChars);
            boolean numberOfCardIsCorrect = checksThatNumberIsCorrect(digitsOfCardNumber);            
            
            if(numberOfCardIsCorrect == true) {
                return REPLY_MASSAGE_CORRECT;
            } else {
        	return REPLY_MESSAGE_NOT_CORRECT;
            }
            
        } else {
            return REPLY_MESSAGE_NOT_CORRECT;
        }        
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
        
    public int[] convertCharToInteger(char[] charsOfCardNumber) {
        int[] digitsOfCardNumber = new int[SIZE_NUMBER_OF_CARD];
        
        for(int i = 0; i < charsOfCardNumber.length; i++) {
            digitsOfCardNumber[i] = Character.getNumericValue(charsOfCardNumber[i]);
        }
        
        return digitsOfCardNumber;
    }    
}
