package dev.andrylat.banking.card.validators;

public enum PaymentSystem {
    MIR("2", "Mir"), AMERICAN_EXPRESS("3", "AmericanExpress"),
    VISA("4", "Visa"), MASTER_CARD("5", "MasterCard"), CHINA_UNION_PAY("6","ChinaUnionPay");
	
	String name;
	String identifier;
    
    PaymentSystem(String identifier, String name) {
	    this.name = name;
	    this.identifier = identifier;
    }
    
    public static String identifierPaymentSystem(String cardNumber) {
        String identifier = convertCardNumberToIdentifier(cardNumber);
        String namePaymenSystem = namePaymentSystem(identifier);
        
        return namePaymenSystem;
    }
    
    private static String namePaymentSystem(String identifier) {
        String result = "Payment system not defined";
        
        for(PaymentSystem paymentSystem: PaymentSystem.values()) 
            if(identifier.equals(paymentSystem.identifier)) {
        	    result = paymentSystem.name;
            }
        
        return result;	
    }
    
    private static String convertCardNumberToIdentifier(String cardNumber) {
        int identifierIndex = 0;
        String delimetr = "";
        String[] identifier = cardNumber.split(delimetr);
        
        return identifier[identifierIndex];
    }
}
