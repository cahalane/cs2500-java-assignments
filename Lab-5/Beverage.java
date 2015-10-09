/**
 * Beverage is an interface for dealing with beverages on the menu. 
 * In practice, the methods required for dealing with Beverages
 * are exactly the same ones we already implement for MenuItems; 
 * but defining a Beverage *interface gives us the benefits
 * of using polymorphism.
 *
 * This interface provides helps us create classes that can
 * act as Beverage objects and be treated as such by the menu.
 *
 * @author Colm Cahalane (ID 113326986)
 */
public interface Beverage extends MenuItem { }