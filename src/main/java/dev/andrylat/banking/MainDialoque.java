package dev.andrylat.banking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainDialoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Card validation: enter 1");
        System.out.println("Mortgage calculation: enter 2");
        
        String inputNumber = scanner.nextLine();
        
        ResponseService.responseManager.get(inputNumber).start();
    }
}
