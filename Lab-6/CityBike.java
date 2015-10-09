/**
 * Class defining a concrete CityBike. A CityBike expands the
 * template for a bike with lights by adding a high frame and a carrier.
 * It is as such a complete and functional bike.
 *
 * @author Colm Cahalane (ID 113326986) 
 */
public final class CityBike extends BikeWithLights {
    private HighFrame frame;
    private Carrier carrier;

    /**
     * Constructor for this CityBike object which uses super-constructors
     * to form the general aspects of a BikeWithLights, and a basic Bike.
     * @return       A fully-formed CityBike.
     */
    public CityBike(){
        super();    // Constructs the superclass to be extended upon
        this.frame = new HighFrame();
        this.carrier = new Carrier();
    }

    /**
     * Method by which this particular bike prints its components.
     * It does this by calling the printComponents method of the super-
     * class, but then also prints the specific components of this class.
     */
    @Override
    public void printComponents(){
        // Starts by calling the printComponents method of the superclass
        // before printing specific components of this class
        super.printComponents();

        System.out.println( frame.getName() );
        System.out.println( carrier.getName() );
    }

}
/**
 * A class to define the behaviour of a HighFrame. It does not have
 * any specific functionality in this version.
 */
class HighFrame extends BikeComponent{ }

/**
 * A class to define the behaviour of a Carrier. It does not have
 * any specific functionality in this version.
 */
class Carrier extends BikeComponent{ }