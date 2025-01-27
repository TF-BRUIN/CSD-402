/*
Truman Forey - 1/26/25 - CSD 402 Assignment 4.2

This program is an exercise to learn arrays, methods, and
overloaded methods within Java. Users will be prompted to 
choose between four different arrays, and the average result 
of that array withh be provided. The program will then loop.
 */

package com.example.csd402.asgnt4;
import java.util.Scanner;
import java.util.Arrays;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }
    static short average(short[] array) {
        short sum = 0;
        /*variable names are intentionally vague as to make 
        them applicable across all variations of average()*/
        short length = (short) array.length;
        for (short nums : array) {
            sum += nums;
        }
        short averageResult = (short) (sum / length);
        return averageResult;
    }
    static int average(int[] array) {
        int sum = 0;
        int length = (int) array.length;
        for (int nums : array) {
            sum += nums;
        }
        int averageResult = (int) (sum / length);
        return averageResult;
    }
    static long average(long[] array) {
        long sum = 0;
        long length = (long) array.length;
        for (long nums : array) {
            sum += nums;
        }
        long averageResult = (long) (sum / length);
        return averageResult;
    }
    static double average(double[] array) {
        double sum = 0;
        double length = (double) array.length;
        for (double nums : array) {
            sum += nums;
        }
        double averageResult = (double) (sum / length);
        return averageResult;
    }
    //I'm wondering if it might've possible to make a singular method for all call scenarios, but I decided not to overcomplicate this

    public static void main(String[] args) {
        
        short[] array_short = {10, 20, 30};
        int[] array_int = {1, 2, 3, 4, 5, 6, 7};
        long[] array_long = {15, 30, 45, 60};
        double[] array_double = {5, 15, 35, 55, 90};
        
        System.out.println("This program returns the average value of a selected array, each with different value types.");
        while (0 == 0) {
            Scanner z1 = new Scanner(System.in);
            int i = 0;
            int choice = 0;
            while (i == 0) {
                choice = 0;
                System.out.println(
                        "Please select which average you would like to see: " 
                        + "\n1. Short - " + Arrays.toString(array_short)
                        + "\n2. Integer - " + Arrays.toString(array_int)
                        + "\n3. Long - " + Arrays.toString(array_long)
                        + "\n4. Double - " + Arrays.toString(array_double)
                ); // I get a suggestion this could've been converted into a text block, but that makes it harder to concat the arrays
                String z2 = z1.next(); //I was having so much trouble with this line until I switch from nextLine/nextInt to just next
                try {
                    choice = Integer.parseInt(z2);
                    if (choice > 0 && choice < 5) {
                        i = 1;
                    } else {
                        System.out.println("\nThat input is not acceptable. Please try again.\n");
                        choice = 0;
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("\nThat input is not acceptable. Please try again.\n");
                    choice = 0;
                }
            }
            System.out.println("\n");
            switch (choice) { // I get a suggestion here to use rule switch instead, but it works fine as-is and I refuse to learn
                case 1:
                    short short_average = average(array_short);
                    System.out.println("The short average is " + short_average);
                    break;
                case 2:
                    int int_average = average(array_int);
                    System.out.println("The int average is " + int_average);
                    break;
                case 3:
                    long long_average = average(array_long);
                    System.out.println("The long average is " + long_average);
                    break;
                case 4:
                    double double_average = average(array_double);
                    System.out.println("The double average is " + double_average);
                    break;
            }
            System.out.println("\nThis program will now loop.\n"); 
        }
    }
}
