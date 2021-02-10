package dev.andrylat.banking.mortgage.calculator;

import java.util.ArrayList;
import java.util.List;

public class MortgageDataValidator implements DataValidator{
    
    private static final String RESPONSE_MESSAGE_INCORRECT_DATA_ENTERED 
                                    = "Invalid data entered. Possibly a character or letter entered";
    
    @Override
    public List<String> validate (String creditAmount, String interestRate, String timingCredit, String prepayment) {
        List<String> errorMessages = new ArrayList<>();
        
        if(!creditAmount.matches("\\d+(\\.\\d{1,2})?")) {
            errorMessages.add("����� �������");
        }
        if(!interestRate.matches("\\d+(\\.\\d{1,2})?")) {
            errorMessages.add("���������� ������");
        }
        if(!timingCredit.matches("\\d+")) {
            errorMessages.add("���� ���������(�� ����� �� ����� �����, ���� ������)");
        }
        if(!prepayment.matches("\\d+(\\.\\d{1,2})?")) {
            errorMessages.add("�����");
        }
        return errorMessages;
    }    
}
