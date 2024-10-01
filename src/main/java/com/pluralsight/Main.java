package com.pluralsight;
import java.util.Scanner;
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Declaring the variables to store sandwich prices
        // Scanner for user input

        // Constants for costs
        final double BASIC_RENTAL_COST_PER_DAY = 29.99;
        final double TOLL_TAG_COST_PER_DAY = 3.95;
        final double GPS_COST_PER_DAY = 2.95;
        final double ROADSIDE_ASSISTANCE_COST_PER_DAY = 3.95;
        final double UNDERAGE_SURCHARGE_PERCENTAGE = 0.30;
        final int UNDERAGE_THRESHOLD = 25;


        // Prompt for rental information
        System.out.print("Enter the pickup date (e.g., YYYY-MM-DD): ");
        String pickupDate = scanner.nextLine();

        System.out.print("Enter the number of days for the rental: ");
        int rentalDays = scanner.nextInt();

        System.out.print("Do you want an electronic toll tag at $3.95/day (yes/no)? ");
        scanner.nextLine(); // Consume newline left-over
        String tollTagChoice = scanner.nextLine();

        System.out.print("Do you want a GPS at $2.95/day (yes/no)? ");
        String gpsChoice = scanner.nextLine();

        System.out.print("Do you want roadside assistance at $3.95/day (yes/no)? ");
        String roadsideAssistanceChoice = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Calculate basic rental cost
        double basicRentalCost = BASIC_RENTAL_COST_PER_DAY * rentalDays;

        // Calculate options cost
        double optionsCost = 0.0;
        if (tollTagChoice.equalsIgnoreCase("yes")) {
            optionsCost += TOLL_TAG_COST_PER_DAY * rentalDays;
        }
        if (gpsChoice.equalsIgnoreCase("yes")) {
            optionsCost += GPS_COST_PER_DAY * rentalDays;
        }
        if (roadsideAssistanceChoice.equalsIgnoreCase("yes")) {
            optionsCost += ROADSIDE_ASSISTANCE_COST_PER_DAY * rentalDays;
        }

        // Calculate underage surcharge if applicable
        double underageSurcharge = 0.0;
        if (age < UNDERAGE_THRESHOLD) {
            underageSurcharge = basicRentalCost * UNDERAGE_SURCHARGE_PERCENTAGE;
        }

        // Calculate total cost
        double totalCost = basicRentalCost + optionsCost + underageSurcharge;

        // Display the costs
        System.out.printf("Basic car rental cost: $%.2f%n", basicRentalCost);
        System.out.printf("Options cost: $%.2f%n", optionsCost);
        System.out.printf("Underage driver surcharge: $%.2f%n", underageSurcharge);
        System.out.printf("Total cost: $%.2f%n", totalCost);

        // Close the scanner
        scanner.close();
    }
}