/*
Truman Forey - 2/13/25 - CSD 402 Assignment 8.2

This program is a simple exercise in learning how
to use the ArrayList utility. It will ask the user
to submit any number of integers, which will be
stored in an array. After the user submits the
number 0, a method will be called that finds the 
largest number. The program will then repeat.
 */
package com.example.csd402.asgnt8R;
import java.util.ArrayList; 
import java.util.Scanner;

public class TrumanArrayListTest {
    public String getGreeting() {
        return "Hello World!";
    }
    
    public static int integerMax(ArrayList<Integer> arr) {
        int highestValue = 0;
        // this declaration ensures that 0 will always be the value if nothing is submitted
        for (int j : arr) {
            if (j > highestValue) {
                highestValue = j;
            }
        }
        return highestValue;
    }
    
    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        int i = 0;
        int choice = 0;
        ArrayList<Integer> userIntList = new ArrayList<>();
        Scanner z1 = new Scanner(System.in);
        System.out.println("""
                           This program will ask you to submit any amount of numbers you like, 
                           and will return the highest value of all the numbers you submitted. 
                           The program will then loop.
                           """);
        while (0 == 0) {
            i = 0;
            userIntList.clear();
            while (i == 0) {
                choice = 0;
                System.out.println("Enter a number to add it to the Integer Array, or enter 0 to move on.");
                String z2 = z1.next();
                try {
                    choice = Integer.parseInt(z2);
                    if (choice == 0) {
                        userIntList.add(choice);
                        System.out.println("0 added to array. Now moving on.\n");
                        i = 1;
                    } else {
                        userIntList.add(choice);
                        System.out.println("Number successfully added to array.\n");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("That input is not acceptable. Please try again.\n");
                }
            }
            System.out.println("The largest number in the array is " + integerMax(userIntList) + ".");
            System.out.println("This program will now repeat itself.\n");
        }
    }
}
