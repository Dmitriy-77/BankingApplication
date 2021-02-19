package dev.andrylat.banking.mortgage.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPayments {
    private static final double AMOUNT_MONTH_IN_YEAR = 12;
    private static final double ONE_HUNDRED_PERCENT = 100;
    
    private static final String FIRST_INSTALLMENT = "First installment - ";// ѕервоначальный взнос
    private static final String CREDIT_AMOUNT = "Credit amount - ";//сумма кредита
    private static final String MONTHS_PAYMENT = "Months of payment - ";
    private static final String MAIN_PAYMENT = "Main payment - ";//основной платЄж по телу кредита
    private static final String OVERALL_PAYMENT = "Overall payment- ";//общий платЄж
    private static final String INTEREST_PAYMENT = "Interest payment - ";//ежемес€чны платЄж по процентам
    private static final String LOAN_BALANCE = "Loan balance - "; //остаток платежа(остаток по кредиту)
    
    public List<String> calculator (CreditData creditData) {
        List<String> result =  new ArrayList<>();
        
        double creditAmount = convertStringToDouble(creditData.getCreditAmount());
        double interestRate = convertStringToDouble(creditData.getInterestRate());
        double timingCredit = convertStringToDouble(creditData.getTimingCredit());
        double prepayment = convertStringToDouble(creditData.getPrepayment());
	    
        double firstInstallment = creditAmount * prepayment / ONE_HUNDRED_PERCENT;
        double creditAmmountWithoutPayment = creditAmount - firstInstallment;
        double amountMonthPayment = timingCredit * AMOUNT_MONTH_IN_YEAR;
        double mainPayment = creditAmmountWithoutPayment / amountMonthPayment;
        double summaViplachenyhProcentov;
        double loanBalance = creditAmmountWithoutPayment;
        
        result.add(FIRST_INSTALLMENT + Double.toString(firstInstallment));
        result.add(CREDIT_AMOUNT + Double.toString(creditAmmountWithoutPayment));
        
        for(int i = 0; i < amountMonthPayment; i++) {
            
            double egemesyachniyPlatejPoProcentam = loanBalance * interestRate / ONE_HUNDRED_PERCENT / AMOUNT_MONTH_IN_YEAR;
            double obshiyPlatej = egemesyachniyPlatejPoProcentam + mainPayment;
            loanBalance = loanBalance - mainPayment;            
            
            result.add(obshiyPlatej + Double.toString(obshiyPlatej) + "; " 
                          + loanBalance + Double.toString(loanBalance));
        }
	    return result;
	}
	
    private Double convertStringToDouble (String data) {
        Double value = Double.parseDouble(data);
        
        return value;
	}
}
