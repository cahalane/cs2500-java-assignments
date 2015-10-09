/**
 * ConcreteMenuItem is a generic concrete class that implements
 * the MenuItem interface, offering some re-usable code that we
 * can use in similar objects and classes.
 *
 * In this class, we find methods that return the menu item's name,
 * price, VAT Rate, taste quality and a description that can be used
 * by the menu: as such it fulfils all requirements of the MenuItem
 * interface.
 *
 * @author Colm Cahalane (ID 113326986)
 */
public class ConcreteMenuItem implements MenuItem {
    /**
     * ConcreteMenuItem uses a default Vat Rate of 0.23
     * but we have a separate constructor for menu items
     * that do not obey this default rate.
     */
    private static final double DEFAULT_VAT_RATE = 0.23;

    /**
     * Strings used when creating a menu item description,
     * which we use when we're actually outputting the menu.
     */
    private static final String TASTES_GOOD_MESSAGE = "Tastes good! ";
    private static final String TASTES_BAD_MESSAGE  = "Tastes bad. ";

    /**
     * Class instance attributes, made private.
     */
    private double price;
    private double vatRate;
    private final boolean tastesGood;
    private final String name;

    /**
     * Constructor for a Concrete Menu Item
     * using the default VAT Rate.
     *
     * Redirects to the "full constructor", by providing the default
     * VAT rate as an argument.
     * 
     * @param  price      double      A user provided price value.
     * @param  tastesGood boolean     A user provided "tastes good" value.
     * @param  name       string      A user-provided (assumed unique) name.
     * 
     * @return            A generic ConcreteMenuItem with the user provided
     *                    values.
     */
    public ConcreteMenuItem(final double price, final boolean tastesGood,
                            final String name){
        this(price, tastesGood, name, DEFAULT_VAT_RATE);
    }

    /**
     * Constructor for a Concrete Menu Item
     * using a provided VAT Rate.
     * 
     * @param  price      double      A user provided price value.
     * @param  tastesGood boolean     A user provided "tastes good" value.
     * @param  name       string      A user-provided (assumed unique) name.
     * @param  vatRate    double      A rate of VAT to be used in taxing.
     * 
     * @return            A generic ConcreteMenuItem with the attributes
     *                    set to the above values.
     */
    public ConcreteMenuItem(final double price, final boolean tastesGood, 
                    final String name, final double vatRate){
        this.vatRate = vatRate;
        this.price = price;
        this.tastesGood = tastesGood;
        this.name = name;
    }

    /**
     * Gets a string description of the item to use in Menu.
     * 
     * @return A description of the form
     *         "Name. Tastes Good/Bad. VAT Rate: value. Price: value."
     */
    @Override
    public String getDescription(){
        // Initialise as blank.
        String outputString = "";

        // Adds the name of the object and punctuation.
        outputString += this.getName() + ". ";

        // Adds a message to the description depending on the taste quality.
        outputString += ( this.getTaste() ) ?
                        TASTES_GOOD_MESSAGE :
                        TASTES_BAD_MESSAGE;

        // Adds the VAT rate of the object and punctuation.
        outputString += "VAT Rate: "
            + this.getVatRate() + ". ";

        // Adds the price of the object and punctuation.
        outputString += "Price: " 
            + this.getPrice() + ". ";

        return outputString;
    }

    /**
     * User-facing public method to return the name of the object.
     * 
     * @return String: value of this.name
     */
    @Override
    public String getName(){
        return this.name;
    }

    /**
     * User-facing public method to return the VAT Rate of the object.
     * 
     * @return double: value of this.vatRate
     */
    @Override
    public double getVatRate(){
        return this.vatRate;
    }

    /**
     * User-facing public method to return the price of the object.
     * 
     * @return double: value of this.price
     */
    @Override
    public double getPrice(){
        return this.price;
    }

    /**
     * User-facing public method to return the quality of the object,
     * where "true" indicates if the object tastes good, and "false"
     * indicates if the object tastes bad.
     * 
     * @return boolean: value of this.tastesGood
     */
    @Override
    public boolean getTaste(){
        return this.tastesGood;
    }
}