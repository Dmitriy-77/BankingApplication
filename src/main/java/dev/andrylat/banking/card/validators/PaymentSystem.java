package dev.andrylat.banking.card.validators;

public enum PaymentSystem {
    MIR("2", "Mir"),
    AMERICAN_EXPRESS("3", "AmericanExpress"),
    VISA("4", "Visa"),
    MASTER_CARD("5", "MasterCard"),
    CHINA_UNION_PAY("6","ChinaUnionPay");
    
    String name;
    String identifier;
    
    PaymentSystem(String identifier, String name) {
        this.name = name;
        this.identifier = identifier;
    }
    
    public static String showNamePaymentSystem(String cardNumber) {        
        String result = null;
        
        for(PaymentSystem paymentSystem: PaymentSystem.values()) {
            if(cardNumber.startsWith(paymentSystem.identifier)) {
                result = paymentSystem.name;
            }        	
        }
        
        return result;
    }
}
