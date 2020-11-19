package Banking_Utilities;

public class CardNumderChecker {
    private String cardIsCorrect = "Card number is correct";
    private String cardIsNotCorrect = "Card number is not correct";
    final int sizeNumberOfCard = 16;
    private int[] digitsOfCardNumber;
    private boolean numberOfCardIsCorrect;
    
    protected String processCheckDigit(String cardNumber) {		
        
       char[] charsOfCardNumber = cardNumber.toCharArray();
        
        boolean onlyDigits = checksThatOnlyDigits(charsOfCardNumber);
        boolean amountDigits = checksAmountOfDigits(charsOfCardNumber);
        
        if(onlyDigits == true && amountDigits == true) {
            digitsOfCardNumber = convertCharToInteger(charsOfCardNumber);
            numberOfCardIsCorrect = ñhecksThatNumberIsCorrect(digitsOfCardNumber);            
            
            if(numberOfCardIsCorrect == true) {
                return cardIsCorrect;
            } else {
        	return cardIsNotCorrect;
            }
            
        } else {
            return cardIsNotCorrect;
        }        
    }
    
    private boolean checksThatOnlyDigits(char[] charsOfCardNumber) {
        for(int i = 0; i < charsOfCardNumber.length; i++) {
            if(!Character.isDigit(charsOfCardNumber[i])) {
        	return false;
            }
        }
        
        return true;
    }
    
    private boolean checksAmountOfDigits(char[] charsOfCardNumber) {
        if(charsOfCardNumber.length == sizeNumberOfCard) {
            return true;
        } else {
            return false;
        }
    }        
    
    public boolean ñhecksThatNumberIsCorrect(int[] digitsOfCardNumber) {
        int sumOfAllDigits = 0;
        int[] tempDigitsOfCardNumber = new int[sizeNumberOfCard];
        
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
        digitsOfCardNumber = new int[sizeNumberOfCard];
        
        for(int i = 0; i < charsOfCardNumber.length; i++) {
            digitsOfCardNumber[i] = Character.getNumericValue(charsOfCardNumber[i]);
        }
        
        return digitsOfCardNumber;
    }    
}
