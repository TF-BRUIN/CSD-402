/*
Truman Forey - 2/8/25 - CSD 402 Assignment 7.2

This program is an exercise to further enhance my understanding
of java object-oriented programming. This program builds on
the code used in the module 6 assignment, and compiles 3 fan
objects into an array that is used to demonstrate how object
methods can be used interchangeably.
 */
package com.example.csd402.asgnt8;
import java.util.Scanner;
import java.util.ArrayList;

public class UseFans {
    public String getGreeting() {
        return "Hello World!";
    }
    
    public static class fanObject {    
        public static final int STOPPED = 0;
        public static final int SLOW = 1;
        public static final int MEDIUM = 2;
        public static final int FAST = 3;

        private int SPEED;
        private boolean ON_STATUS;
        private int RADIUS;
        private String COLOR;

        public fanObject() {
            this.SPEED = STOPPED;
            this.ON_STATUS = false;
            this.RADIUS = 6;
            this.COLOR = "white";
        }

        public fanObject(int NewSpeed, boolean NewStatus, int NewRadius, String NewColor) {
            this.SPEED = NewSpeed;
            this.ON_STATUS = NewStatus;
            this.RADIUS = NewRadius;
            this.COLOR = NewColor;
        }

        public String GetSpeed() {
            String ReturnValue = "";
            switch (this.SPEED) {
                case 0 -> ReturnValue = "STOPPED";
                case 1 -> ReturnValue = "SLOW";
                case 2 -> ReturnValue = "MEDIUM";
                case 3 -> ReturnValue = "FAST";
            }
            return ReturnValue;
        }
        public void SetSpeed(int NewSpeed) {
            //Fan.SPEED = NewSpeed;
            //above line was my first idea for SetSpeed(), but I decided to be thorough
            switch (NewSpeed) {
                case 0 -> this.SPEED = STOPPED;
                case 1 -> this.SPEED = SLOW;
                case 2 -> this.SPEED = MEDIUM;
                case 3 -> this.SPEED = FAST;
                //probably could've just used NewSpeed, but I set those as constants, might as well use them
            }
        }

        public String GetON() {
            String ReturnValue = "";
            if (this.ON_STATUS == true) {//I had so much trouble with these if/else statements before I realized I was using '=' instead of '=='
                ReturnValue = "On";
            } else {
                ReturnValue = "Off";
            }
            return ReturnValue;
        }
        public void SetON(boolean NewOn) {
            this.ON_STATUS = NewOn;
            if (ON_STATUS == false) {
                SetSpeed(0);
                System.out.println("Since you turned the fan off, the fan's speed has been set to 'Stopped'.");
            } else if (this.SPEED == 0) {
                SetSpeed(1);
                System.out.println("Since you turned the fan on, the fan's speed has been set to 'Slow'.");
            } //I didn't need to do this bit, but it felt appropriate
        }

        public String GetRadius() {
            return Integer.toString(RADIUS);
        }
        public void SetRadius(int NewRadius) {
            this.RADIUS = NewRadius;
        }

        public String GetColor() {
            return COLOR;
        }
        public void SetColor (String NewColor) {
            this.COLOR = NewColor;
        }

        @Override
        public String toString() {
            String ReturnValue = "";
            String BaseMessage = "This "+this.GetColor()+"-colored fan has blades with a "+this.GetRadius()+"-centimeter radius. ";
            String OnMessageVer = "Currently, this fan is on and at "+this.GetSpeed()+" speed.";
            String OffMessageVer = "Currently, this fan is off.";
            if (this.ON_STATUS == true) {//I realize I could've dropped the '== true' check and it will still work, but I like being thorough
                ReturnValue = BaseMessage.concat(OnMessageVer);
            } else {
                ReturnValue = BaseMessage.concat(OffMessageVer);
            }//I'm honestly very proud of the solution I came up with here, very elegant while still meeting requirements
            return ReturnValue;
        }
    }
    
    public static void displayAllFans(ArrayList<fanObject> arr) {
        for (fanObject i : arr) {
            System.out.println("Fan Speed: " + i.GetSpeed());
            System.out.println("Fan Status: " + i.GetON());
            System.out.println("Fan Radius: " + i.GetRadius());
            System.out.println("Fan Color: " + i.GetColor());
            System.out.println("-------------------------");
        }
    }
    
    public static void displayOneFan(ArrayList<fanObject> arr, int c) {
        c -= 1;
        System.out.println("Fan Speed: " + arr.get(c).GetSpeed());
        System.out.println("Fan Status: " + arr.get(c).GetON());
        System.out.println("Fan Radius: " + arr.get(c).GetRadius());
        System.out.println("Fan Color: " + arr.get(c).GetColor());
        System.out.println("-------------------------");
    }
    
    // RUNNING PROGRAM ///////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        ArrayList<fanObject> fanCollection = new ArrayList<>();

        fanObject FanNumber_1 = new fanObject();
        fanObject FanNumber_2 = new fanObject(3, true, 3, "green");
        fanObject FanNumber_3 = new fanObject(2, true, 10, "yellow");
        
        fanCollection.add(FanNumber_1);
        fanCollection.add(FanNumber_2);
        fanCollection.add(FanNumber_3);
        
        displayAllFans(fanCollection);
        
        while (0 == 0) {
            int i = 0;
            int choice = 0;
            Scanner z1 = new Scanner(System.in);
            while (i == 0) {
                choice = 0;
                System.out.println("""
                    Select which fan you would like to display:
                    1 - white fan
                    2 - green fan
                    3 - yellow fan""");
                String z2 = z1.next();
                try {
                    choice = Integer.parseInt(z2);
                    if (choice > 0 && choice < 4) {
                        i = 1;
                    } else {
                        System.out.println("That input is not acceptable. Please try again.\n");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("That input is not acceptable. Please try again.\n");
                }
            }
            System.out.println("-------------------------");
            displayOneFan(fanCollection, choice);
            System.out.println("This program will now repeat itself.");
        }
    }
}
