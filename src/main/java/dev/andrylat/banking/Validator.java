package dev.andrylat.banking;

import java.util.List;

import dev.andrylat.banking.mortgage.calculator.InitialCreditData;

public interface Validator<E> {
	
    public List<String> validate (E data);

}
