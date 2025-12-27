package com.airtribe.learntrack.util;

import java.util.Scanner;

public class InputValidator {

    // Validate integer input (menu choice, IDs, etc.)
    public static int readInt(Scanner sc, String message) {
        int value;

        while (true) {
            System.out.print(message);
            try {
                value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
            }
        }
    }

    // Validate non-empty string input
    public static String readString(Scanner sc, String message) {
        String input;

        while (true) {
            System.out.print(message);
            input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("❌ Input cannot be empty. Please try again.");
            }
        }
    }

    // Validate yes/no input
    public static boolean readYesNo(Scanner sc, String message) {
        while (true) {
            System.out.print(message + " (yes/no): ");
            String input = sc.nextLine().trim().toLowerCase();

            if (input.equals("yes")) {
                return true
            }
        }
    }
}