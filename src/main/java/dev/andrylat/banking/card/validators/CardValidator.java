package dev.andrylat.banking.card.validators;

import java.util.List;

public interface CardValidator {
    public List<String> validate(String cardNumber);
}
