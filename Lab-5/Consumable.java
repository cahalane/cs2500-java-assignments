/**
 * Consumable is interface for dealing with consumable items;
 * i.e. named items that have a taste quality.
 *
 * This interface requires that Consumable items are able to return
 * a name and a taste quality value through public methods.
 *
 * @author Colm Cahalane (ID 113326986)
 */
public interface Consumable {
    /**
     * All Consumable items must have a name as a string value.
     * This method must return as a string the name of an object that implements it.
     * 
     * @return String: the name of the object.
     */
    public String getName();

    /**
     * All Consumable items must have a taste quality.
     * We implement this as a Boolean, where "true" indicates that
     * the object tastes good and "false" indicates that the object
     * tastes bad.
     * This method must return a boolean that follows the above
     * convention.
     * 
     * @return boolean: the taste quality of the object.
     */
    public boolean getTaste();
}