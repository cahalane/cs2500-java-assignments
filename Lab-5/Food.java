/**
 * Food is an interface for dealing with Food items on the menu.
 * In practice, the methods required for dealing with Food 
 * are exactly the same ones we already implement for 
 * MenuItems; but defining a Food interface gives us the 
 * benefits of using polymorphism.
 *
 * This interface provides helps us create classes that can
 * act as Food objects and be treated as such by the menu.
 *
 * This interface extends MenuItem but is otherwise empty.
 *
 * @author Colm Cahalane (ID 113326986)
 */
public interface Food extends MenuItem { }
