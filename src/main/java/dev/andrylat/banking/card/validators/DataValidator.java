package dev.andrylat.banking.card.validators;

import java.util.List;

public interface DataValidator {
	
	public List<String> validate(String cardNumber);
}
