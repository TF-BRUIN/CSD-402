/*
 * This source file was generated by the Gradle 'init' task
 */
package com.example.csd402.asgnt10;

public class UseDivision {
    public String getGreeting() {
        return "Hello World!";
    }
    
    abstract static class Division {
        String divisionName;
        int accountNumber;
        
        public Division(String divisionName, int accountNumber) {
            this.divisionName = divisionName;
            this.accountNumber = accountNumber;
        }
        
        public abstract void display();
    }
    
    static class InternationalDivision extends Division {
        String country;
        String language;
        
        public InternationalDivision(String divisionName, int accountNumber, String country, String language) {
            super(divisionName, accountNumber);
            this.country = country;
            this.language = language;
        }
        
        @Override
        public void display() {
            System.out.println("International Division: " + divisionName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Country: " + country);
            System.out.println("Language: " + language);
            System.out.println("");
        }
    }
    
    static class DomesticDivision extends Division {
        String state;
        
        public DomesticDivision(String divisionName, int accountNumber, String state) {
            super(divisionName, accountNumber);
            this.state = state;
        }
        
        @Override
        public void display() {
            System.out.println("Domestic Division: " + divisionName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("State: " + state);
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        InternationalDivision intDivision01 = new InternationalDivision("Rio de Janeiro Branch", 10001, "Brazil", "Portuguese");
        InternationalDivision intDivision02 = new InternationalDivision("London Branch", 10002, "United Kingdom", "English");
        DomesticDivision domDivision01 = new DomesticDivision("Omaha Branch", 10101, "Nebraska");
        DomesticDivision domDivision02 = new DomesticDivision("NYC Branch", 10201, "New York");
        
        intDivision01.display();
        intDivision02.display();
        domDivision01.display();
        domDivision02.display();
    }
}
