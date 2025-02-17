/*
Truman Forey - 2/16/25 - CSD 402 Assignment 9.2 - Program 1

This program is a simple exercise in throwing and catching
errors, as well as printing a custom error message. This
program will create an ArrayList to demonstrate this with,
print all of the items within the ArrayList, and then ask
the user to select which number within the list to reprint.
If the user submits a valid input, it will be printed as normal.
If the input is invalid, a custom error will be thrown.
The program will then loop.
 */
package com.example.csd402.asgnt91;
import java.util.ArrayList; 
import java.util.Scanner;

public class OutOfBoundsArrayList {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        ArrayList<String> countryArray = new ArrayList<>();
        countryArray.add("United States is located in North America.");
        countryArray.add("United Kingdom is located in western Europe.");
        countryArray.add("Canada is located in North America.");
        countryArray.add("Mexico is located in North and Central America.");
        countryArray.add("France is located in western Europe.");
        countryArray.add("Germany is located in western and central Europe.");
        countryArray.add("Spain is located in western Europe.");
        countryArray.add("Australia is located in Oceania.");
        countryArray.add("Brazil is located in South America.");
        countryArray.add("China is located in east Asia.");
        int i = 1;
        for (String c : countryArray) {
            System.out.println(i + ". " + c);
            i += 1;
        }
        System.out.println("");
        int h = 0;
        int choice = 0;
        Scanner z1 = new Scanner(System.in);
        while (h == 0) {
            System.out.println("Choose which number (1-10) in the array to reprint.");
            String z2 = z1.next();
            try {
                choice = Integer.parseInt(z2); // this is my example of Autoboxing, turning String into Integer
                if (0 < choice && choice < 11) {
                    System.out.println(choice + ". " + countryArray.get(choice - 1));
                    // choice is subtracted by 1 to compensate for lists starting at 0
                } else {
                    throw new Exception ("Out of Bounds.");
                }
            }
            catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
            System.out.println("");
        }
    }
}
