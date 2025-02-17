/*
Truman Forey - 2/16/25 - CSD 402 Assignment 9.2 - Program 2

This program is a simple exercise in file management in
Java. This program test for if a text file exists, 
and then either creates it or asks if the user would
like to delete it. In either case, the program will
write 10 random numbers to the file, and then read
the contents of the file.
 */
package com.example.csd402.asgnt92;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FileWritingAndReading {
    public String getGreeting() {
        return "Hello World!";
    }
    
    public static int getRandomNumber() {
        Random randomNum = new Random();
        int genNumber = randomNum.nextInt(899) + 100;
        return genNumber;
    }

    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        File dataFile = new File("data_file.txt");
        // System.out.println(getRandomNumber());
        String choice = "n";
        Scanner z1 = new Scanner(System.in);
        int c = 0;
        ///////////////////////////////////////////////////////////////////////////
        System.out.println("Creating file 'data_file.txt'.");
        try {
            if (dataFile.createNewFile()) {
                System.out.println("File successfully created.");
            } else {
                System.out.println("File already exists. Delete file and create new one? y/n");
                while (c == 0) {
                    choice = z1.next();
                    switch (choice) {
                        case "y" -> {
                            dataFile.delete();
                            dataFile.createNewFile();
                            System.out.println("File successfully created.\n");
                            c += 1;
                        }
                        case "n" -> {
                            System.out.println("File not deleted.\n");
                            c += 1;
                        }
                        default -> {
                            System.out.println("Invalid input. Please enter y or n.\n");
                        }
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////
            int w = 0;
            FileWriter numberWriter = new FileWriter("data_file.txt");
            System.out.println("This program will now write 10 random numbers between 100 to 999 to the file.");
            int randomNumber;
            while (w < 10) {
                randomNumber = getRandomNumber();
                numberWriter.write(randomNumber + " \n");
                w += 1;
            }
            numberWriter.close();
            System.out.println("Numbers successfully written.\n");
            //////////////////////////////////////////////////////////////////////////////
            System.out.println("Now printing contents of file.");
            Scanner numberReader = new Scanner(dataFile);
            while (numberReader.hasNextLine()) {
                String u = numberReader.nextLine();
                System.out.println(u);
            }
            numberReader.close();
            System.out.println("Contents of file successfully printed.\n");
            ///////////////////////////////////////////////////////////////////////////
            System.out.println("This program is now finished.");
            ///////////////////////////////////////////////////////////////////////////
        } catch (IOException e) {
            System.out.println("Exception Occured: " + e.getMessage());
        }
    }
}
