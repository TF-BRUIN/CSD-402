/*
 * This source file was generated by the Gradle 'init' task
 */
package com.example.testproject03;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        //System.out.println("Hello World Again!");
        int waterMass = 0;
        int initTemp = 0;
        int finalTemp = 0;
        int z1 = 0;
        while (z1 == 0) {
            Scanner w1 = new Scanner(System.in);
            int z2 = 0;
            while (z2 == 0) {
                try {
                    System.out.println("Please enter the weight of the body of water in kilograms >");
                    String w2 = w1.nextLine();
                    waterMass = Integer.parseInt(w2);
                    z2 = 1;
                }
                catch(Exception e) {
                    System.out.println("That input is not acceptable. Please try again.");
                }
            }
            
            Scanner iT1 = new Scanner(System.in);
            int z3 = 0;
            while (z3 == 0) {
                try {
                    System.out.println("Please enter the initial temperature in Celsius >");
                    String iT2 = iT1.nextLine();
                    initTemp = Integer.parseInt(iT2);
                    z3 += 1;
                }
                catch(Exception e) {
                    System.out.println("That input is not acceptable. Please try again.");
                }
            }
            
            Scanner fT1 = new Scanner(System.in);
            int z4 = 0;
            while (z4 == 0) {
                try {
                    System.out.println("Please enter the final temperature in Celsius >");
                    String fT2 = fT1.nextLine();
                    finalTemp = Integer.parseInt(fT2);
                    z4 += 1;
                }
                catch(Exception e) {
                   System.out.println("That input is not acceptable. Please try again."); 
                }
            }
            
            int tempChange = finalTemp - initTemp;
            //System.out.println("Temperature Change is " + tempChange);
            int Q = waterMass * tempChange * 4184;
        
            System.out.println("The amount of energy needed to heat a " + waterMass + 
                    " kg body of water by " + tempChange + 
                    "C degrees is " + Q + " Joules.");
            System.out.println("This program will now repeat itself. \n");
        }
    }
}
