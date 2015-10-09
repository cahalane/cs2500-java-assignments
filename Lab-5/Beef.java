/**
 * Beef is a class which defines the behaviour for Beef objects,
 * which we base on the Food interface.
 *
 * There is no requirement to document this class,
 * but a fully-documented similar class can be found under
 * the TapWater.java file.
 *
 * @author Colm Cahalane (ID 113326986)
 */
public class Beef implements Food {
    private static final double PRICE_OF_ITEM = 15.00;
    private static final boolean ITEM_TASTES_GOOD = true;
    private static final String NAME_OF_ITEM = "Beef";

    private final ConcreteMenuItem item;

    public Beef(){
        this.item = new ConcreteMenuItem(PRICE_OF_ITEM, ITEM_TASTES_GOOD, NAME_OF_ITEM);
    }

    @Override
    public String getDescription(){
        return item.getDescription();
    }

    @Override
    public String getName(){
        return item.getName();
    }

    @Override
    public double getVatRate(){
        return item.getVatRate();
    }

    @Override
    public double getPrice(){
        return item.getPrice();
    }

    @Override
    public boolean getTaste(){
        return item.getTaste();
    }
}