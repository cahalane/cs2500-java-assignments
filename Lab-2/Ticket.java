/**
* Name: Colm Patrick Cahalane
* Number: 113326986
* Assignment: 2.
* Purpose: This defines the Ticket class and the Ticket Sales system.
* When executed, we ask if the user is or is not a child.
* Based on their answer, we create the relevant ticket, and
* print its information to the user.
**/

import java.util.Scanner; //required to read user input.

public class Ticket{
    // Instance variables effecting calculations.
    // We assume all ticket prices are integer Euro values.
    private static final int BASE_PRICE = 50;
    private static final int CHILDRENS_DISCOUNT = 10;

    // String commonly reused in the interface, defined for convenience.
    private static final String SEPARATOR = "=============================================";

    // Price of the ticket, can change.
    private int ticketPrice;

    // Reflects if the owner of a ticket is a child.
    private final boolean userIsChild; 

    public static void main(String[] args) {

        //  This method defines the interface that is seen by the user when
        //  they are purchasing a ticket. Here, we need to ask them if they are
        //  an adult or a child. Depending on their response, we'll create and print
        //  details of the relevant ticket. 

        System.out.println(SEPARATOR);
        boolean validInput = false;       // Allows us to loop until valid input.
        boolean inputUserIsChild = false; // Default is to assume adult user.

        while ( !validInput ) {
            System.out.println("Welcome to Ticketmaster.");
            System.out.print("Are you a child (Y/N)? ");

            // We accept user input here.
            final Scanner userInput = new Scanner(System.in);
            
            //We take the first "word" of user input and accept either case.
            String inputString = userInput.next().toUpperCase();

            if ( inputString.equals("N") ){
                // Value is N, meaning the user is not a child.
                // This is a valid input, and default behaviour.
                validInput = true;
            } else if (inputString.equals("Y")) {
                // Input value is Y, meaning the user is a child.
                // This is a valid input but we must change state.
                validInput = true;
                inputUserIsChild = true;
            } else {
                // The input is unrecognised. We print an error
                System.out.println("Wrong input: only Y and N are allowed inputs.");
            }
        }

        Ticket userTicket = new Ticket(inputUserIsChild);

        userTicket.printTicket();

    }

    public Ticket(final boolean inputUserIsChild){
        // This method constructs a new Ticket object based on if the user
        //  is a child. We establish a status variable (userIsChild) and
        //  a variable for the ticket price; we'll apply discounts here. 

        // Status variable to determine if the user is a child.
        // Set from user input.
        userIsChild = inputUserIsChild;

        // Initial ticket price set from static variable
        ticketPrice = BASE_PRICE;

        if(userIsChild){
            // User is a child so we need to discount their ticket.
            ticketPrice = ticketPrice - CHILDRENS_DISCOUNT;
        }
    }

    public void printTicket(){
        System.out.println(SEPARATOR);
        System.out.println("Base Price:\t = " + BASE_PRICE + " " + "Euro");

        if(userIsChild){
            // If user is a child, a children's discount was included on construction
            // and we must include this discount in our summary of the price.
            
            System.out.println("Discount:\t = " + CHILDRENS_DISCOUNT + " " + "Euro");
        }

        System.out.println("---------------------");
        System.out.println("Total Price:\t = " + ticketPrice + " " + "Euro");
        System.out.println(SEPARATOR);
    }
}