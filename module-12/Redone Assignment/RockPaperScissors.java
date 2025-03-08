/*
Truman Forey - 3/5/25 - CSD 402 Assignment 2.2 REDO

This is a redo of the module 2.2 assignment, fixing
any previous issues with the program.

This program is a simple experiment to learn the basics
of Java - particularly, how to handle user input and
variable output. This program emulates Rock-Paper-Scissors,
and asks the user to input one of the three options. The 
program will then randomly choose one of the options and
compare it against the user's choice. The appropriate
result message will then be displayed. The program will
then loop.
 */
package com.example.csd402.asgnt2;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        System.out.println("This program simulates a game of rock-paper-scissors.");
        while (0 == 0) {
            Scanner z = new Scanner(System.in);
            int player_choice = 0;
            int i = 0;
            while (i == 0) {
                System.out.println("Please enter your selection:\n1. Rock\n2. Paper\n3. Scissors");
                String w2 = z.nextLine();
                player_choice = Integer.parseInt(w2);
                if (player_choice > 0 && player_choice < 4) {
                    i = 1; // this checks if user input is valid and sets i to 1 if input is valid
                } else {
                    System.out.println("That input is not acceptable. Please try again.");
                }
            }
            Random rand = new Random();
            int computer_choice = rand.nextInt(3); // generates a random number of 0, 1, or 2
            computer_choice += 1; // adjusts the random number to be more dev-friendly
            String player_choice_word = "";
            switch (player_choice) {
                case 1 -> player_choice_word = "Rock";
                case 2 -> player_choice_word = "Paper";
                case 3 -> player_choice_word = "Scissors";
            }
            String computer_choice_word = "";
            switch (computer_choice) {
                case 1 -> computer_choice_word = "Rock";
                case 2 -> computer_choice_word = "Paper";
                case 3 -> computer_choice_word = "Scissors";
            }
            // these two switches associate the user's choice (which is an int) with a string that can be displayed
            System.out.println("You have selected " + player_choice_word + ".");
            System.out.println("The computer has selected " + computer_choice_word + ".");
            int resolution_case = 0;
            /*
            "resolution case" is basically the results of the comparison between player and computer choice
            0 = draw
            1 = player wins
            2 = computer wins
            */
            if (player_choice == computer_choice) { // checks for draw first, since that's simplest
                resolution_case = 0;
            } else if (computer_choice == 1 && player_choice == 3) { // checks if computer chose rock and player chose scissors
                resolution_case = 2;
            } else if ((player_choice > computer_choice) || (player_choice == 1 && computer_choice == 3)) { // checks for all winning scenarios for the player
                /*
                the fact that numbers are associated with each choice was a deliberate decision to enable this easier check
                
                while this isn't a very robust method of checking for victory, the previous 2 if statements prevent it from raising false positives/negatives
                */
                resolution_case = 1;
            } else { // all other scenarios are a loss for the player
                resolution_case = 2;
            }
            switch (resolution_case) {
                case 0 -> System.out.println("It was a draw.");
                case 1 -> System.out.println("You won!");
                case 2 -> System.out.println("You lost...");
            }
            System.out.println("\n--This program will now repeat itself.--\n");
        }
    }
}
