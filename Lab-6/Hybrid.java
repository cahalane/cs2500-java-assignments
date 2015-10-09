/**
 * Class defining a concrete Hybrid bike. A Hybrid bike expands the
 * template for a bike with lights by adding a Medium-sized frame.
 * It is as such a complete and functional bike.
 *
 * @author Colm Cahalane (ID 113326986) 
 */
public final class Hybrid extends BikeWithLights {
    private final MediumFrame frame;

    /**
     * Constructor for this Hybrid object which uses super-constructors
     * to form the general aspects of a BikeWithLights, and a basic Bike.
     * @return       A fully-formed Hybrid bike.
     */
    public Hybrid(){
        super();
        this.frame = new MediumFrame();
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
 * A class to define the behaviour of a MediumFrame. It does not have
 * any specific functionality in this version.
 */
class MediumFrame extends BikeComponent{ }