/**
 * Taxable is an interface for dealing with
 * taxable items; items which have a VAT rate. 
 * Requires a method to return the rate.
 *
 * @author Colm Cahalane (ID 113326986)
 */
public interface Taxable {
    /**
     * All Valuable objects must have a specific VAT rate.
     * This method must return as a double the VAT rate of an object that implements it.
     *     
     * @return double The VAT rate of an implementing object.
     */
    public double getVatRate();
}