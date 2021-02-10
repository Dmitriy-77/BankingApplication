package dev.andrylat.banking.mortgage.calculator;

import java.util.ArrayList;
import java.util.List;

public class MortgageDataValidator implements DataValidator{
    
    private static final String RESPONSE_MESSAGE_INCORRECT_DATA_ENTERED 
                                    = "Invalid data entered. Possibly a character or letter entered";
    
    @Override
    public List<String> validate (String creditAmount, String interestRate, String timingCredit, String prepayment) {
        List<String> errorMessages = new ArrayList<>();
        
        if(!creditAmount.matches("\\d+(\\.\\d{1,2})?")) {
            errorMessages.add("Сумма кредита");
        }
        if(!interestRate.matches("\\d+(\\.\\d{1,2})?")) {
            errorMessages.add("Процентная ставка");
        }
        if(!timingCredit.matches("\\d+")) {
            errorMessages.add("срок погашения(вы ввели не целое число, либо символ)");
        }
        if(!prepayment.matches("\\d+(\\.\\d{1,2})?")) {
            errorMessages.add("аванс");
        }
        return errorMessages;
    }    
}
