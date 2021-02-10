package dev.andrylat.banking.mortgage.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPayments {
	private double creditAmount;
	private double interestRate;
	private double timingCredit;
	private double prepayment;
    
    private static final double AMOUNT_MONTH_IN_YEAR = 12;
    private static final double ONE_HUNDRED_PERCENT = 100;
    String perviyVznos = "Perviy Vznos - ";
    String summaCredita = "Summa Credita - ";
    String amountMonthPlateja = "Amount Month Plateja - ";
    String osnovnoyPlatej = "Osnovnoy Platej - ";
    String obshiyPlatej = "Obshiy Platej v mesac- ";
    String egemesyachniyPlatejPoProcentam = "Egemesyachniy Platej Po Procentam - ";
    String ostatokPlatega = "Ostatok Platega - ";
    
	public List<String> calculator (String creditAmount, String interestRate, String timingCredit, String prepayment) {
        List<String> result =  new ArrayList<>();
        
        this.creditAmount = convertStringToDouble(creditAmount);
        this.interestRate = convertStringToDouble(interestRate);
        this.timingCredit = convertStringToDouble(timingCredit);
        this.prepayment = convertStringToDouble(prepayment);
	    
        double perviyVznos = this.creditAmount*this.prepayment/ONE_HUNDRED_PERCENT;
        double summaCredita = this.creditAmount-perviyVznos;
        double amountMonthPlateja = this.timingCredit*AMOUNT_MONTH_IN_YEAR;
        double osnovnoyPlatej = summaCredita/amountMonthPlateja;
        double summaViplachenyhProcentov;
        double ostatokPlatega = summaCredita;
        
        result.add(this.perviyVznos + Double.toString(perviyVznos));
        result.add(this.summaCredita + Double.toString(summaCredita));
        
        for(int i = 0; i < amountMonthPlateja; i++) {
            
            double egemesyachniyPlatejPoProcentam = ostatokPlatega * this.interestRate / ONE_HUNDRED_PERCENT / AMOUNT_MONTH_IN_YEAR;
            double obshiyPlatej = egemesyachniyPlatejPoProcentam + osnovnoyPlatej;
            ostatokPlatega = ostatokPlatega - osnovnoyPlatej;            
            
            result.add(this.obshiyPlatej + Double.toString(obshiyPlatej) + "; " 
                          + this.ostatokPlatega + Double.toString(ostatokPlatega));
        }
	    return result;
	}
	
	private Double convertStringToDouble (String data) {
        Double value = Double.parseDouble(data);
        
        return value;
	}
}
