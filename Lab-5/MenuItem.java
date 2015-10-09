/**
 * MenuItem.java : defines an interface for dealing with
 * MenuItem objects. In practice, the methods required for
 * dealing with MenuItems are almost the same ones we
 * already implement for Consumable, Valuable and Taxable ;
 * but defining a MenuItem interface gives us the benefits
 * of using polymorphism.
 *
 * This interface extends Consumable, Valuable and Taxable.
 *
 * It also adds an additional requirement for a method
 * called "getDescription" that returns the description
 * of an object for use in a menu.
 *
 * @author Colm Cahalane (ID 113326986)
 */
public interface MenuItem extends Consumable, Valuable, Taxable {
    /**
     * MenuItems must be able to be included on a printable
     * Menu. As a result, MenuItems must be able to return
     * this description somehow.
     * This description could possibly include its Name,
     * taste quality, VAT rate, and price.
     * 
     * @return String: a description of this menu item.
     */
    public String getDescription();
}