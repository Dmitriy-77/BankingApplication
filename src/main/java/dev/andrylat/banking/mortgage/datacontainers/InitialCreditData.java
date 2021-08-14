package dev.andrylat.banking.mortgage.datacontainers;

public class InitialCreditData {
    
    private String creditAmount;
    private String interestRate;
    private String timingCredit;
    private String prepayment;
    
    public String getCreditAmount() {
        return creditAmount;
    }
    
    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }
    
    public String getInterestRate() {
        return interestRate;
    }
    
    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }
    
    public String getTimingCredit() {
        return timingCredit;
    }
    
    public void setTimingCredit(String timingCredit) {
        this.timingCredit = timingCredit;
    }
    
    public String getPrepayment() {
        return prepayment;
    }
    
    public void setPrepayment(String prepayment) {
        this.prepayment = prepayment;
    }
}
