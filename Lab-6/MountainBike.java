/**
 * Class defining a concrete Mountain. A MountainBike expands the
 * abstract template for a basic Bike by adding a LowFrame.
 * It is as such a complete and functional bike.
 *
 * @author Colm Cahalane (ID 113326986) 
 */
public final class MountainBike extends Bike {
    private final LowFrame frame;

    /**
     * Constructor for this Mountain object which uses a super-
     * constructor to form the general aspects of a basic Bike.
     * @return       A fully-formed MountainBike.
     */
    public MountainBike(){
        super();    // Constructs the superclass to be extended upon
        this.frame = new LowFrame();
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
    }

}

/**
 * A class to define the behaviour of a LowFrame. It does not have
 * any specific functionality in this version.
 */
class LowFrame extends BikeComponent{ }