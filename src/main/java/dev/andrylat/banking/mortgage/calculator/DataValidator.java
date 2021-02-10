package dev.andrylat.banking.mortgage.calculator;

import java.util.List;

public interface DataValidator {
    public List<String> validate (String creditAmount, String interestRate, String timingCredit, String prepayment);
}
