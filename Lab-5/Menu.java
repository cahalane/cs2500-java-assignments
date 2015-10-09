import java.util.ArrayList;

/**
 * A Menu is a collection of MenuItems which are arranged
 * into separate sections for Food and Beverages. New Food
 * and Beverage items can be added to the menu and it can
 * be displayed to the user.
 *
 * This class also defines a test case in the main() where
 * a sample menu is created and displayed.
 *
 * @author Colm Cahalane (ID 113326986)
 */
public class Menu {

    /**
     * We implement the menu as a pair of ArrayLists
     * which individually handle all food and beverages
     * that are to be added to the menu.
     */
    private ArrayList<Beverage> beverageMenu;
    private ArrayList<Food> foodMenu;

    /**
     * This method adds a Food item to the Food menu.
     * 
     * @param foodItem A Food type item to be added to the menu. 
     */
    public void addItem( final Food foodItem ){
        foodMenu.add( foodItem );
    }

    /**
     * This method adds a Beverage item to the Beverage menu.
     * 
     * @param bevItem A Beverage type item to be added to the menu. 
     */
    public void addItem( final Beverage bevItem ){
        beverageMenu.add( bevItem );
    }

    /**
     * A constructor for Menu objects.
     * @return A Menu object with two blank sub-menus
     *         for Food and Beverage objects.
     */
    public Menu(){
        this.beverageMenu = new ArrayList<Beverage>();
        this.foodMenu = new ArrayList<Food>();
    }

    /**
     * Outputs the menu in its current form, split into Food and 
     * Beverage sub-sections.
     * Operates by calling the getMenuItemDescription() method
     * from the FoodItem class.
     */
    public void displayMenu(){
        // Prints line by line the contents of the Food Section
        // under the heading "FOOD".
        System.out.println("FOOD");
        for( Food foodItem : foodMenu ){         
            System.out.println( foodItem.getDescription() );
        }

        // Prints line by line the contents of the Beverage Section
        // under the heading "BEVERAGES".
        System.out.println("BEVERAGES");
        for( Beverage bevItem : beverageMenu ){
            System.out.println( bevItem.getDescription() );
        }
    }

    /**
     * Main, defining the executable interface shown to the user.
     * Here we implement a very basic testing program. It adds many
     * types of menu items to the Menu's different sections.
     */
    public static void main(String[] args) {
        // Creates a new Menu.
        Menu menu = new Menu();

        // Adds items to a menu.
        // We'll add one of each of the object references
        // of the menu item classes we've defined.
        menu.addItem( new Boxty() );
        menu.addItem( new Beef() );
        menu.addItem( new IrishStew() );
        menu.addItem( new TapWater() );
        menu.addItem( new Lemonade() );

        // Display the created menu.
        menu.displayMenu();
    }
}