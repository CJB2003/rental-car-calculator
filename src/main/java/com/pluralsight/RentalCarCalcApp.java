package com.pluralsight;
import java.util.*;

public class RentalCarCalcApp {

    //Create scanner to capture user input
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for pickup date
        System.out.println("What day would you like to pick this up? ");
        String pickupDate = myScanner.nextLine();
        //Ask user for how many days they're renting it
        System.out.println("How many days for the rental? ");
        int numberDays = myScanner.nextInt();
        myScanner.nextLine();
        //Ask whether user wants an electronic tag
        System.out.println("Would you like an electronic tag for $3.95/day? (Yes/No) ");
        String tagQuestion = myScanner.nextLine();
        //Ask whether user wants a GPS
        System.out.println("Would you like a GPS for $2.95/day? (Yes/No) ");
        String gpsQuestion = myScanner.nextLine();
        //Ask user whether they want roadside assistance
        System.out.println("Would you like roadside assistance for $3.95/day? (Yes/No) ");
        String roadsideQuestion = myScanner.nextLine();
        //Ask for user age
        System.out.println("What is your age? ");
        int userAge = myScanner.nextInt();

        //Initialize car rent variable and calculate it, surcharge, and options
        double basePrice = calculateBasePrice(numberDays);
        double rentSurcharge = 0.3;
        double optionCost = calculateOptionCost(tagQuestion, gpsQuestion, roadsideQuestion, numberDays);

        //If user under 25, they receive a surcharge
        if (userAge < 25) {
            System.out.println("You're underaged so there is a surcharge with your total price.");
            basePrice = basePrice + (basePrice * rentSurcharge) + optionCost;
        }
        //Otherwise, they pay for regular price including any option costs
        else {
            System.out.println("You pay for base price and any other option costs.");
            basePrice = basePrice + optionCost;
        }
        //initialize a total cost variable and store the value we got from our calculation
        double totalCost = basePrice;
        System.out.printf("Your total will be: $%.2f", totalCost);

    }

    public static double calculateBasePrice(int numDays) {

        return 29.99 * numDays;
    }

    public static double calculateOptionCost(String tollTag, String GPS, String RA, int numDays) {
        double optionCost = 0;
        double tagPrice = 3.95;
        double gpsPrice = 2.95;
        double roadsidePrice = 3.95;

        if (tollTag.equalsIgnoreCase("Yes")) {
            optionCost += tagPrice;
        }
        if (GPS.equalsIgnoreCase("Yes")) {
            optionCost += gpsPrice;
        }
        if (RA.equalsIgnoreCase("Yes")) {
            optionCost += roadsidePrice;
        }
        optionCost *= numDays;
        System.out.printf("%.2f\n", optionCost);

        return optionCost;
    }
}
