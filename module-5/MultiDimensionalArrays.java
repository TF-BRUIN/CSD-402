/*
Truman Forey - 1/29/25 - CSD 402 Assignment 5.2

This program is an exercise to learn multi-dimensional
arrays and how to navigate them in a practical way. First,
this program will list the two different types of arrays
(int and double) and ask the user which one they would
like to see the highest and lowest numbers of. The program
will then repeat.
 */

package com.example.csd402.asgnt5;
import java.util.Scanner;
import java.util.Arrays;

public class MultiDimensionalArrays {
    public String getGreeting() {
        return "Hello World!";
    }
    static int intArray[][] = {
        {14, 9, 10, 12, 8},
        {20, 9, 2, 8, 5},
        {7, 3, 0, 10, 5}
    };
    static double doubleArray[][] = {
        {0.3, 6.6, 9.4, 3.9, 5.3},
        {8.7, 0.9, 4.3, 9.9, 0.1},
        {4.0, 9.1, 2.7, 1.8, 3.2}
    };
    
    public static int[] locateLargest (double[][] arrayParam) {
        int row = 0, col = 0;
        double maximumValue = arrayParam[0][0];
        for (int i = 0; i < arrayParam.length; i++) {
            for (int j = 0; j <arrayParam[i].length; j++) {
                if (arrayParam[i][j] > maximumValue) {
                    maximumValue = arrayParam[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return new int[]{row, col};
    }
    public static int[] locateLargest (int[][] arrayParam) {
        int row = 0, col = 0;
        int maximumValue = arrayParam[0][0];
        for (int i = 0; i < arrayParam.length; i++) {
            for (int j = 0; j <arrayParam[i].length; j++) {
                if (arrayParam[i][j] > maximumValue) {
                    maximumValue = arrayParam[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return new int[]{row, col};
    }

    public static int[] locateSmallest (double[][] arrayParam) {
        int row = 0, col = 0;
        double minimumValue = arrayParam[0][0];
        for (int i = 0; i < arrayParam.length; i++) {
            for (int j = 0; j < arrayParam[i].length; j++) {
                if (arrayParam[i][j] < minimumValue) {
                    minimumValue = arrayParam[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return new int[]{row, col};
    }
    public static int[] locateSmallest (int[][] arrayParam) {
        int row = 0, col = 0;
        int minimumValue = arrayParam[0][0];
        for (int i = 0; i < arrayParam.length; i++) {
            for (int j = 0; j < arrayParam[i].length; j++) {
                if (arrayParam[i][j] < minimumValue) {
                    minimumValue = arrayParam[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return new int[]{row, col};
    }
    //I'm aware most of these methods are just copy+pasted, but ain't that just most coding?
    //There's probably some way to make them overlap in some way, but this'll work for now.
    
    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        //I copied most of this segment form Assignment 4.2 since it's already well-built for handling this type os assignment.
        //Apologies if this is frowned upon, but if it works, it works.
        System.out.println("This program returns the highest and lowest value of a selected array, both with a different value type.");
        while (0 == 0) {
            Scanner z1 = new Scanner(System.in);
            int i = 0;
            int choice = 0;
            while (i == 0) {
                choice = 0;
                System.out.println(
                        "Please select which array you would like to use: " 
                        + "\n1. Integer Array - " + Arrays.toString(intArray[0]) 
                                + ", " + Arrays.toString(intArray[1]) + ", " + Arrays.toString(intArray[2])
                        + "\n2. Double Array - " + Arrays.toString(doubleArray[0])
                                + ", " + Arrays.toString(doubleArray[1]) + ", " + Arrays.toString(doubleArray[2])
                        // this is admittedly probably a very inefficient way to print multi-layered arrays
                ); // I get a suggestion this could've been converted into a text block, but that makes it harder to concat
                String z2 = z1.next();
                try {
                    choice = Integer.parseInt(z2);
                    if (choice > 0 && choice < 3) {
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
                System.out.println("");
                int[] largest;
                int[] smallest;
                switch (choice) { // I get a suggestion here to use rule switch instead, but it works fine as-is and I refuse to learn
                    case 1:
                        largest = locateLargest(intArray);
                        smallest = locateSmallest(intArray);
                        System.out.println("The location of the highest value of this array is " + Arrays.toString(largest));
                        System.out.println("The location of the smallest value of this array is " + Arrays.toString(smallest));
                        break;
                    case 2:
                        largest = locateLargest(doubleArray);
                        smallest = locateSmallest(doubleArray);
                        System.out.println("The location of the highest value of this array is " + Arrays.toString(largest));
                        System.out.println("The location of the smallest value of this array is " + Arrays.toString(smallest));
                        break;
                }
            }
            System.out.println("\nThis program will now loop.\n");
        }
    }
}
