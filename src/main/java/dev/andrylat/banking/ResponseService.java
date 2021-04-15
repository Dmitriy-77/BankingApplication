package dev.andrylat.banking;

import java.util.HashMap;
import java.util.Map;

import dev.andrylat.banking.card.validators.CardChecker;
import dev.andrylat.banking.mortgage.calculator.MortgageCalculator;

public class ResponseService {
    
    private static final String CARD_CHECKER_REQUEST = "1";
    private static final String MORTGAGE_CALCULATOR_REQUEST = "2";
    
    public static Map<String, Dialoque> responseManager = new HashMap<>();
    
    static {        
        responseManager.put(CARD_CHECKER_REQUEST, new CardChecker());        
        responseManager.put(MORTGAGE_CALCULATOR_REQUEST, new MortgageCalculator());
    }
}
