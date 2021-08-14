package dev.andrylat.banking.mortgage.calculator;

public class LoanCalculationData {

	private static double firstInstallment;
    private static double finalLoanAmount;
    private static double amountMonthPayment;
    private static double mainPaymentPerMonth;
        
    public double getFirstInstallment() {
        return firstInstallment;
    }
    public void setFirstInstallment(double firstInstallment) {
        this.firstInstallment = firstInstallment;
    }
    public double getFinalLoanAmount() {
        return finalLoanAmount;
    }
    public void setFinalLoanAmount(double finalLoanAmount) {
        this.finalLoanAmount = finalLoanAmount;
    }
    public double getAmountMonthPayment() {
        return amountMonthPayment;
    }
    public void setAmountMonthPayment(double amountMonthPayment) {
        this.amountMonthPayment = amountMonthPayment;
    }
    public double getMainPaymentPerMonth() {
        return mainPaymentPerMonth;
    }
    public void setMainPaymentPerMonth(double mainPaymentPerMonth) {
        this.mainPaymentPerMonth = mainPaymentPerMonth;
    }    
}
