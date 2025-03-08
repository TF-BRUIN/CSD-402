/*
Truman Forey - 3/7/25 - CSD 402 Assignment 12.2

This program is a more advanced test of Java, using techniques like
method overloading, nested loops, and a variety of smaller skills.
This program calculates the cost of a yearly auto service visit twice - 
once based on default values, and another based on the input of the 
user. The user will then be able to print different variations of the
cost, or otherwise restart or exit the program.
 */
package com.example.csd402.asngt12;

import java.util.Scanner;
import java.text.DecimalFormat;

public class YearlyAutoService {
    public String getGreeting() {
        return "Hello World!";
    }
    
    static double defaultStandardService = 183.95;
    static double defaultOilChange = 55.80;
    static double defaultTireRotation = 28.59;
    static double defaultCouponDiscount = 0.2;
    static DecimalFormat rounding = new DecimalFormat("#.##"); 
    
    public static double yearlyService() {
        double totalCharges = defaultStandardService;
        return totalCharges;
    }
    
    public static double yearlyService(double oilChange) {
        double totalCharges = defaultStandardService + oilChange;
        return totalCharges;
    }
    
    public static double yearlyService(double oilChange, double tireRotation) {
        double totalCharges = defaultStandardService + oilChange + tireRotation;
        return totalCharges;
    }
    
    public static String yearlyService(double oilChange, double tireRotation, double couponDiscount) {
        double initialCharges = defaultStandardService + oilChange + tireRotation;
        double discountedCharges = initialCharges * (1 - couponDiscount);
        String totalCharges = rounding.format(discountedCharges); // had to make this method return string instead of double to compensate for decimals
        return totalCharges;
    }

    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        
        System.out.println("This program will calculate an estimated charge for a yearly auto service visit, based on the information the user provides.");
        System.out.println("This program will first run all four methods with 'default' values as a test.");
        System.out.println("--------------------------------------------------------------");
        System.out.println("1. Standard service, no add-ons - $" + 
                yearlyService());
        System.out.println("2. Service + oil change - $" + 
                yearlyService(defaultOilChange));
        System.out.println("3. Service + oil change + tire rotation - $" + 
                yearlyService(defaultOilChange, defaultTireRotation));
        System.out.println("4. Service + oil change + tire rotation, with coupon - $" + 
                yearlyService(defaultOilChange, defaultTireRotation, defaultCouponDiscount));
        // formatted these printlns weird just to make it fit better to a smaller window
        // there's no mechanical difference as far as I know
        System.out.println("--------------------------------------------------------------");
        
        int loop = 0;
        double userOilChange = 0;
        double userTireRotation = 0;
        double userCouponDiscount = 0;
        double choice = 0;
        int i1;
        int i2;
        int i3;
        String defaultValue = "x";
        String visitMessage = "A yearly auto service visit will cost $";
        
        Scanner z1 = new Scanner(System.in);
        String z2;
        
        while (loop == 0) { // causes program to loop infinitely until user ends it
            System.out.println("Please enter the following information, or enter 'x' to use the default values.");
            System.out.println("The standard service charge - $183.95 - cannot be changed.\n");
            
            i1 = 0;
            i2 = 0;
            i3 = 0;
            
            choice = 0;
            z2 = "";
            System.out.println("Enter the oil change fee, or 'x' to use the default value.");
            while (i1 == 0) {
                z2 = z1.next();
                if (defaultValue.equals(z2)) {
                    userOilChange = defaultOilChange;
                    i1 += 1;
                    System.out.println("Using default value - " + defaultOilChange + ".\n");
                } else {
                    try {
                        choice = Double.parseDouble(z2);
                        userOilChange = choice;
                        i1 += 1;
                        System.out.println("Oil change fee set successfully.\n");
                    } catch (NumberFormatException e) {
                        System.out.println("Not a valid choice, please try again.");
                    }
                }
            }
            
            choice = 0;
            z2 = "";
            System.out.println("Enter the tire rotation charge, or 'x' to use the default value.");
            while (i2 == 0) {
                z2 = z1.next();
                if (defaultValue.equals(z2)) {
                    userTireRotation = defaultTireRotation;
                    i2 += 1;
                    System.out.println("Using default value - " + defaultTireRotation + ".\n");
                } else {
                    try {
                        choice = Double.parseDouble(z2);
                        userTireRotation = choice;
                        i2 += 1;
                        System.out.println("Tire rotation charge set successfully.\n");
                    } catch (NumberFormatException e) {
                        System.out.println("Not a valid choice, please try again.");
                    }
                }
            }
            
            choice = 0;
            z2 = "";
            System.out.println("Enter the coupon discount, or 'x' to use the default value.");
            System.out.println("Note that this value should be a percentage expressed as a decimal - ie, 0.2 is equal to a 20% discount.");
            while (i3 == 0) {
                z2 = z1.next();
                if (defaultValue.equals(z2)) {
                    userCouponDiscount = defaultCouponDiscount;
                    i3 += 1;
                    System.out.println("Using default value - " + defaultCouponDiscount + ".\n");
                } else {
                    try {
                        choice = Double.parseDouble(z2);
                        userCouponDiscount = choice;
                        i3 += 1;
                        System.out.println("Coupon discount set successfully.\n");
                    } catch (NumberFormatException e) {
                        System.out.println("Not a valid choice, please try again.");
                    }
                }
            }
            
            int decision = 0; // using a separate choice value because original choice was a double, so making safe
            z2 = "";
            int j = 0;
            int k = 0;
            System.out.println("All values set successfully.\n");
            
            while (k == 0) {
                j = 0;
                while (j == 0) {
                    System.out.println(
                            """
                            Please choose which values to use to calculate cost.
                            1. Service Charge
                            2. Service Charge + Oil Change
                            3. Service Charge + Oil Change + Tire Rotation
                            4. Service Charge + Oil Change + Tire Rotation, with Coupon Discount
                            5. Restart Program
                            6. End Program
                            """
                    );
                    z2 = z1.next();
                    try {
                        decision = Integer.parseInt(z2);
                        if (0 < decision && decision < 7) {
                            j += 1;
                        } else {
                            System.out.println("Not a valid choice, please try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Not a valid choice, please try again.");
                    }
                }
                
                // String visitMessage = "A yearly auto service visit will cost $";
                // initialized this Stringoutside the loops since it never needs to be changed
                
                switch (decision) {
                    case 1 -> System.out.println(visitMessage + yearlyService() + ".\n");
                    case 2 -> System.out.println(visitMessage + yearlyService(userOilChange) + ".\n");
                    case 3 -> System.out.println(visitMessage + yearlyService(userOilChange, userTireRotation) + ".\n");
                    case 4 -> System.out.println(visitMessage + yearlyService(userOilChange, userTireRotation, userCouponDiscount) + ".\n");
                    case 5 -> k += 1; // this ends the message display loops but keeps the program loop going
                    case 6 -> { // this ends both loops and ends the program
                        k += 1;
                        loop += 1;
                    }
                }
            }
            
            if (loop == 0) { // this if/else declares what's happening for sake of clarity
                System.out.println("\n-- This program will now loop. --\n");
            } else {
                System.out.println("\n-- Closing program. --\n");
            }
        }
    }
}
