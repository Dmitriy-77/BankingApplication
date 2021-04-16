package dev.andrylat.banking.interfaces;

import java.util.List;

import dev.andrylat.banking.mortgage.datacontainers.InitialCreditData;

public interface Validator<E> {
	
    public List<String> validate (E data);

}
