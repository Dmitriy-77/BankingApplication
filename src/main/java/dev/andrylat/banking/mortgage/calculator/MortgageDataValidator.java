package dev.andrylat.banking.mortgage.calculator;

import java.util.ArrayList;
import java.util.List;

import dev.andrylat.banking.Validator;

public class MortgageDataValidator implements Validator<InitialCreditData>{
    
    private static final String RESPONSE_MESSAGE_INCORRECT_DATA_ENTERED_CREDIT_AMOUNT 
                                    = "Credit Amount: Invalid data entered. Possibly a character or letter entered";
    private static final String RESPONSE_MESSAGE_INCORRECT_DATA_ENTERED_INTEREST_RATE
                                    = "Interest Rate: Invalid data entered. Possibly a character or letter entered";
    private static final String RESPONSE_MESSAGE_INCORRECT_DATA_ENTERED_TIMING_CREDIT 
                                    = "Timing Credit: Invalid data entered. Possibly a character or letter entered";
    private static final String RESPONSE_MESSAGE_INCORRECT_DATA_ENTERED_PREPAYMENT 
                                    = "Prepayment: Invalid data entered. Possibly a character or letter entered";
    
    private static final String FLOATING_POINT_DATA = "\\d+(\\.\\d{1,2})?";
    private static final String WHOLE_NUMBERS_ONLY = "\\d+";
    
    @Override
    public List<String> validate (InitialCreditData creditData){
        List<String> errorMessages = new ArrayList<String>();
        
        if(!creditData.getCreditAmount().matches(FLOATING_POINT_DATA)) {
            errorMessages.add(RESPONSE_MESSAGE_INCORRECT_DATA_ENTERED_CREDIT_AMOUNT);
        }
        if(!creditData.getInterestRate().matches(FLOATING_POINT_DATA)) {
            errorMessages.add(RESPONSE_MESSAGE_INCORRECT_DATA_ENTERED_INTEREST_RATE);
        }
        if(!creditData.getTimingCredit().matches(WHOLE_NUMBERS_ONLY)) {
            errorMessages.add(RESPONSE_MESSAGE_INCORRECT_DATA_ENTERED_TIMING_CREDIT);
        }
        if(!creditData.getPrepayment().matches(FLOATING_POINT_DATA)) {
            errorMessages.add(RESPONSE_MESSAGE_INCORRECT_DATA_ENTERED_PREPAYMENT);
        }
        return errorMessages;
    }
}
