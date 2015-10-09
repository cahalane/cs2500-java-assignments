/**
* Name: Colm Cahalane
* Number: 113326986
* Assignment: 1.
* Purpose:  This program demonstrates a simple Temperature class
*           in Java; initialized with a Kelvin value and able to
*           return values in different temperature formats.
*           This file defines the Temperature class used in applciations.
**/

// Class for representing temperature values.
public class Temperature{

    /* A temperature value in Kelvin; the value will be provided
    *  by the input to our constructor function.
    *  This is final; the stored temperature can not be modified.
    */
    private final double KELVIN_VALUE;

    // printKelvin() simply prints that stored value.
    public void printKelvin(){
        System.out.println(KELVIN_VALUE + "K");
    }

    // This function prints the stored value, converted to celcius.
    public void printCelcius(){
        final double CELCIUS_VALUE = (KELVIN_VALUE - 273.15);
        System.out.println( CELCIUS_VALUE + "°C");
    }

    // This function prints the stored value, converted to Fahrenheit.
    public void printFahrenheit(){
        final double FAHRENHEIT_VALUE = (KELVIN_VALUE - 273.15)*1.8 + 32;
        System.out.println( FAHRENHEIT_VALUE + "°F" ); 
    }

    // Constructor. Creates a Temperature object using an input Kelvin value. 
    public Temperature(double inputKelvinValue){
        this.KELVIN_VALUE = inputKelvinValue;
    }
}