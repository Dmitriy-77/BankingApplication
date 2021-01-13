package dev.andrylat.banking.card.validators;

public interface NumberValidator {
	
    public boolean validate(int[] digitsOfCardNumber);
}
