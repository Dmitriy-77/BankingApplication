package Banking_Utilities;

import java.util.Scanner;

public class CardChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardNumderChecker cardNumberChecker = new CardNumderChecker();
        
        System.out.println("Enter card number");
        
        String cardNumber = scanner.nextLine();
        String result = cardNumberChecker.processCheckDigit(cardNumber);
        
        System.out.println(result);
    }
}
