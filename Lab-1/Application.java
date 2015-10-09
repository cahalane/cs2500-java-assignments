/**
* Name: Colm Cahalane
* Number: 113326986
* Assignment: 1.
* Purpose:  This program demonstrates a simple Temperature class
*           in Java; initialized with a Kelvin value and able to
*           return values in different temperature formats.
*           This class defines an Application that uses Temperature objects.
**/

public class Application{
    // Main. This defines the executable program that the end-user will see.
    public static void main(String[] args) {

        /* Creates a Temperature object, userTemp.
        *  As this is only a non-interactive demonstration, 
        *  the object created will always use the value 5.
        */
        final Temperature userTemp = new Temperature(5);
        
        // Here we provide examples of the instance methods of the object.
        userTemp.printKelvin();
        userTemp.printCelcius();
        userTemp.printFahrenheit();

        return;
    }
}