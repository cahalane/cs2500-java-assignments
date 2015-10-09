/**
 * Valuable is  an interface for dealing with
 * items that have a price value.
 * Requires a method to return the price value.
 *
 * @author Colm Cahalane (ID 113326986)
 */

public interface Valuable {
    /**
     * All Valuable objects must have a specific price.
     * This method must return as a double the price of an object that implements it.
     *     
     * @return double The VAT rate of an implementing object.
     */
    public double getPrice();
}