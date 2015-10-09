/**
 * TapWater is a class that defines how a Tap Water object should;
 * behave on the menu; unlike other items found on the menu,
 * it is free and has a VAT rate of 0%. 
 *
 * @author Colm Cahalane (ID 113326986)
 */
public class TapWater implements Beverage {

    /**
     * Constant class-specific values fed to the
     * constructor for the ConcreteMenuItem.
     */
    private static final double PRICE_OF_ITEM = 0.00;
    private static final boolean ITEM_TASTES_GOOD = true;
    private static final String NAME_OF_ITEM = "Tap Water";
    private static final double VAT_RATE = 0.00;

    /**
     * Behaviour in the TapWater class (and all similar classes)
     * is implemented by constructing a ConcreteMenuItem that
     * implements the behaviour of the MenuItem interface.
     */
    private final ConcreteMenuItem item;

    /**
     * Constructor for a TapWater object. Creates a ConcreteMenuItem
     * using the class-specific constants and uses it to implement
     * the object's behaviour.
     * 
     * @return A TapWater object.
     */
    public TapWater(){
        this.item = new ConcreteMenuItem(PRICE_OF_ITEM, ITEM_TASTES_GOOD,
                                         NAME_OF_ITEM, VAT_RATE);
    }

    /**
     * Gets a string description of the item to use in Menu.
     * 
     * @return A description of the form
     *         "Name. Tastes Good/Bad. VAT Rate: value. Price: value."
     */
    @Override
    public String getDescription(){
        return item.getDescription();
    }

    /**
     * User-facing public method to return the name of the object
     * as returned from the ConcreteMenuItem object that implements
     * the object's behaviour.
     * 
     * @return String: value of the object's name.
     */
    @Override
    public String getName(){
        return item.getName();
    }

    /**
     * User-facing public method to return the VAT Rate of the object
     * as returned from the ConcreteMenuItem object that implements
     * the object's behaviour.
     * 
     * @return double: value of the object's vatRate.
     */
    @Override
    public double getVatRate(){
        return item.getVatRate();
    }


    /**
     * User-facing public method to return the price of the object
     * as returned from the ConcreteMenuItem object that implements
     * the object's behaviour.
     * 
     * @return double: value of the object's price.
     */
    @Override
    public double getPrice(){
        return item.getPrice();
    }


    /**
     * User-facing public method to return the quality of the object,
     * where "true" indicates if the object tastes good, and "false"
     * indicates if the object tastes bad. Returned from the
     * ConcreteMenuItem object that implements the object's behaviour.
     * 
     * @return boolean: value of the object's tastesGood.
     */
    @Override
    public boolean getTaste(){
        return item.getTaste();
    }
}

