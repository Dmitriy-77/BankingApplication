package dev.andrylat.banking.card.validators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardNumderValidatorTest {
    private final String LETTER_OR_CHAR_IN_CARD_NUMBER = "h213243736267129";
    private final String INCORRECT_AMOUNT_DIGITS_IN_CARD_NUMBER = "521324373626712";
    private final String SIMBOL_AND_AMOUNT_DIGITS_IN_CARD_NUMBER = "h52";
    private final String CARD_NUMBER_IS_NOT_CORRECT = "5313243736267129";
    
    private final String REPLY_MESSAGE_NOT_CORRECT = "Card number is not correct";
    private final String REPLY_MESSAGE_ENTERED_LETTER_OR_CHAR = "You entered a letter or char";
    private final String REPLY_MESSAGE_ENTERED_INCORRECT_AMOUNT_DIGITS = "You entered incorrect ammount of digits";
    
    private CardValidator validator;
    
    private List<String> expected;
    private List<String> actual;
    
    @BeforeEach
    public void creatNewCardNumberValidator () {    
        validator = new CardNumderValidator();
    }
    
    @BeforeEach
    public void creatNewListExpectedAndListActual () {
        expected = new ArrayList<String>();
        actual = new ArrayList<String>();
    }
    
    @Test
    public void validateShouldReturnListOfErrorMessage_YouEnteredALetterOrChar() {
        actual = validator.validate(LETTER_OR_CHAR_IN_CARD_NUMBER);
        expected.add(REPLY_MESSAGE_ENTERED_LETTER_OR_CHAR);
        
        assertLinesMatch(expected, actual);
	}
    
    @Test
    public void validateShouldReturnListOfErrorMessage_CardNumberIsNotCorrect() {
        actual = validator.validate(CARD_NUMBER_IS_NOT_CORRECT);
        expected.add(REPLY_MESSAGE_NOT_CORRECT);
        
        assertLinesMatch(expected, actual);
	}
    
    @Test
    public void validateShouldReturnListOfErrorMessage_YouEnteredIncorrectAmmountOfDigits() {
        actual = validator.validate(INCORRECT_AMOUNT_DIGITS_IN_CARD_NUMBER);
        expected.add(REPLY_MESSAGE_ENTERED_INCORRECT_AMOUNT_DIGITS);
        
        assertLinesMatch(expected, actual);
	}
    
    @Test
    public void validateShouldReturnListOfErrorMessage_YouEnteredIncorrectAmmountOfDigitsAndLetterOrChar() {
        actual = validator.validate(SIMBOL_AND_AMOUNT_DIGITS_IN_CARD_NUMBER);
        expected.add(REPLY_MESSAGE_ENTERED_LETTER_OR_CHAR);
        expected.add(REPLY_MESSAGE_ENTERED_INCORRECT_AMOUNT_DIGITS);
        
        assertLinesMatch(expected, actual);
	}    
}
