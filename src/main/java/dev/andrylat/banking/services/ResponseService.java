package dev.andrylat.banking.services;

import java.util.HashMap;
import java.util.Map;

import dev.andrylat.banking.card.CardCheckerDialoque;
import dev.andrylat.banking.interfaces.Dialoque;
import dev.andrylat.banking.mortgage.MortgageCalculatorDialoque;

public class ResponseService {
    
    private static final String CARD_CHECKER_REQUEST = "1";
    private static final String MORTGAGE_CALCULATOR_REQUEST = "2";
    
    public static Map<String, Dialoque> responseManager = new HashMap<>();
    
    static {        
        responseManager.put(CARD_CHECKER_REQUEST, new CardCheckerDialoque());        
        responseManager.put(MORTGAGE_CALCULATOR_REQUEST, new MortgageCalculatorDialoque());
    }
}
