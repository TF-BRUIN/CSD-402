/*
Truman Forey - 1/31/25 - CSD 402 Assignment 6.2

This program is an exercise to learn various applications of objects
and classes. This program will create two Objects - one using a no-
argument (or "default") constructor, and one that takes 4 arguments
that the user will be prompted to input. Then it will print similar
test methods (getters and setters) for both objects before looping.
 */
package com.example.csd402.asgnt6;
import java.util.Scanner;

public class Fan {
    public String getGreeting() {
        return "Hello World!";
    }
    
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    
    private int SPEED;
    private boolean ON_STATUS;
    private int RADIUS;
    private String COLOR;
    
    public Fan() {
        this.SPEED = STOPPED;
        this.ON_STATUS = false;
        this.RADIUS = 6;
        this.COLOR = "white";
    }
    
    public Fan(int NewSpeed, boolean NewStatus, int NewRadius, String NewColor) {
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
        return ReturnValue.toString();
    }
    
    public static void main(String[] args) {
        //System.out.println(new Fan().getGreeting());
        //had to initialize all these variables with default values so later lines could use them without complaining
        Fan FanDefault = new Fan();
        int CustomSpeed = 0;
        boolean CustomStatus = false;
        int CustomRadius = 6;
        String CustomColor = "white";
        System.out.println("""
                           This program will ask you to input certain for fields for a 'Fan' object.
                           Then it will ask you to choose what actions you would like to take,
                           which will either be to edit the fields of the custom object
                           or compare it to those of a default Fan object.
                           """);
        Scanner z1 = new Scanner(System.in);
        int i = 0;
        int choice = 0;
        // CUSTOM STATUS BLOCK //////////////////////////////////////////////////////////////////////////
        i = 0;
        choice = 0;
        while (i == 0) {
            System.out.println("""
                Please enter whether you would like the fan to be on or off. Enter the number of your option.
                1. On
                2. Off""");
            String z2 = z1.next();
            try {
                choice = Integer.parseInt(z2);
                if (choice > 0 && choice < 3) {
                    i = 1;
                    if (choice == 1) {
                        CustomStatus = true;
                    } else {
                        CustomStatus = false;
                    }
                } else {
                    System.out.println("That input is not acceptable. Please try again.\n");
                    choice = 0;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("That input is not acceptable. Please try again.\n");
                choice = 0;
            }
        }
        // CUSTOM SPEED BLOCK ///////////////////////////////////////////////////////////////////////////
        i = 0;
        choice = 0;
        if (CustomStatus == false) {
            System.out.println("Since you chose for the fan to be turned off, the fan's speed will automatically be set to stopped");
            CustomSpeed = 0;
        } else {
            while (i == 0) {
                System.out.println("""
                    Please choose the speed you would like the fan to be at. Enter the number of your option.
                    1. Slow
                    2. Medium
                    3. Fast""");
                String z2 = z1.next();
                try {
                    choice = Integer.parseInt(z2);
                    if (choice > 0 && choice < 4) {
                        i = 1;
                        switch (choice) {
                            case 1 -> CustomSpeed = SLOW;
                            case 2 -> CustomSpeed = MEDIUM;
                            case 3 -> CustomSpeed = FAST;
                        }
                    } else {
                        System.out.println("That input is not acceptable. Please try again.\n");
                        choice = 0;
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("That input is not acceptable. Please try again.\n");
                    choice = 0;
                }
            }
        }
        // CUSTOM RADIUS BLOCK //////////////////////////////////////////////////////////////////////////
        i = 0;
        choice = 0;
        while (i == 0) {
            System.out.println("""
                Please enter the radius of a singular fan blade, in centimeters.""");
            String z2 = z1.next();
            try {
                choice = Integer.parseInt(z2);
                i = 1;
                CustomRadius = choice;
            }
            catch (NumberFormatException e) {
                System.out.println("That input is not acceptable. Please try again.\n");
                choice = 0;
            }
        }
        // CUSTOM COLOR BLOCK ///////////////////////////////////////////////////////////////////////////
        i = 0;
        while (i == 0) {
            System.out.println("""
                Please enter the color of the fan.""");
            String StringChoice = z1.next();
            try {
                i = 1;
                CustomColor = StringChoice;
            }
            catch (NumberFormatException e) {
                System.out.println("That input is not acceptable. Please try again.\n");
                choice = 0;
            }
        }
        // END OF CUSTOM BLOCK //////////////////////////////////////////////////////////////////////////
        Fan FanCustom = new Fan(CustomSpeed, CustomStatus, CustomRadius, CustomColor);
        System.out.println("All custom inputs have been successfully accepted. Here are the descriptions of the two fans:");
        System.out.println("Default Fan: " + FanDefault.toString());
        System.out.println("Custom Fan: " + FanCustom.toString());
        System.out.println("\nYou will now be given a variety of options to test your custom object's class methods.\n");
        while (0 == 0) {
            System.out.println("""
                               1. Re-Print Default and Custom Fan Comparison
                               2. Get Custom Fan's Speed
                               3. Set Custom Fan's Speed
                               4. Get Custom Fan's On/Off Status
                               5. Set Custom Fan's On/Off Status
                               6. Get Custom Fan's Radius
                               7. Set Custom Fan's Radius
                               8. Get Custom Fan's Color
                               9. Set Custom Fan's Color""");
            i = 0;
            choice = 0;
            while (i == 0) {
                String z2 = z1.next();
                try {
                    choice = Integer.parseInt(z2);
                    if (choice > 0 && choice < 10) {
                        i = 1;
                    } else {
                        System.out.println("That input is not acceptable. Please try again.\n");
                        choice = 0;
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("That input is not acceptable. Please try again.\n");
                    choice = 0;
                }
            }
            switch (choice) {//I copied the Set code (cases 3, 5, 7, 9) from the original inputs. 
                            //If I wanted to optimize this code, I could've made the set functions include this code, 
                            //but I don't think it was necessary for this assignment
                case 1 -> {
                    System.out.println("Default Fan: " + FanDefault.toString());
                    System.out.println("Custom Fan: " + FanCustom.toString());
                }
                case 2 -> {System.out.println("Custom Fan Speed: " + FanCustom.GetSpeed());}
                case 3 -> {
                    i = 0;
                    choice = 0;
                    if (FanCustom.ON_STATUS == false) {
                        System.out.println("Since you chose for the fan to be turned off, the fan's speed will remain at stopped. Turn the fan on to change speed.");
                    } else {
                        while (i == 0) {
                            System.out.println("""
                                Please choose the speed you would like the fan to be at. Enter the number of your option.
                                1. Slow
                                2. Medium
                                3. Fast""");
                            String z2 = z1.next();
                            try {
                                choice = Integer.parseInt(z2);
                                if (choice > 0 && choice < 4) {
                                    i = 1;
                                    switch (choice) {
                                        case 1 -> FanCustom.SPEED = SLOW;
                                        case 2 -> FanCustom.SPEED = MEDIUM;
                                        case 3 -> FanCustom.SPEED = FAST;
                                    }
                                } else {
                                    System.out.println("That input is not acceptable. Please try again.\n");
                                    choice = 0;
                                }
                            }
                            catch (NumberFormatException e) {
                                System.out.println("That input is not acceptable. Please try again.\n");
                                choice = 0;
                            }
                        }
                    }
                }
                case 4 -> {System.out.println("Custom Fan On/Off Status: " + FanCustom.GetON());}
                case 5 -> {
                    i = 0;
                    while (i == 0) {
                        System.out.println("""
                            Please enter whether you would like the fan to be on or off. Enter the number of your option.
                            1. On
                            2. Off""");
                        String z2 = z1.next();
                        try {
                            choice = Integer.parseInt(z2);
                            if (choice > 0 && choice < 3) {
                                i = 1;
                                if (choice == 1) {
                                    FanCustom.SetON(true);
                                } else {
                                    FanCustom.SetON(false);
                                }
                            } else {
                                System.out.println("That input is not acceptable. Please try again.\n");
                                choice = 0;
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.println("That input is not acceptable. Please try again.\n");
                            choice = 0;
                        }
                    }
                }
                case 6 -> {System.out.println("Custom Fan Radius: " + FanCustom.GetRadius());}
                case 7 -> {
                    i = 0;
                    choice = 0;
                    while (i == 0) {
                        System.out.println("""
                            Please enter the radius of a singular fan blade, in centimeters.""");
                        String z2 = z1.next();
                        try {
                            choice = Integer.parseInt(z2);
                            i = 1;
                            FanCustom.SetRadius(choice);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("That input is not acceptable. Please try again.\n");
                            choice = 0;
                        }
                    }
                }
                case 8 -> {System.out.println("Custom Fan Color: " + FanCustom.GetColor());}
                case 9 -> {i = 0;
                    while (i == 0) {
                        System.out.println("""
                            Please enter the color of the fan.""");
                        String StringChoice = z1.next();
                        try {
                            i = 1;
                            FanCustom.SetColor(StringChoice);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("That input is not acceptable. Please try again.\n");
                            choice = 0;
                        }
                    }
                }
            }
            System.out.println("");
        }
    }
}

