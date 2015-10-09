/**
 * Class defining an abstract Bike with lights. It extends the abstract
 * Bike by adding lights to it on the front and rear sides. However, it
 * is not a complete and functional Bike as it lacks a frame.
 *
 * @author Colm Cahalane (ID 113326986) 
 */
public abstract class BikeWithLights extends Bike {
    private final FrontLight frontLight;
    private final RearLight rearLight;

    /**
     * Constructor for this BikeWithLights prototype which uses a super-
     * constructor to inherit the characteristics of the abstract Bike
     * class.
     * @return       A BikeWithLights object to be extended.
     */
    public BikeWithLights(){
        super();    // Constructs the superclass to be extended upon
        this.frontLight = new FrontLight();
        this.rearLight = new RearLight();
    }
    
    /**
     * Method which is to be used by child classes to extend upon;
     * it prints the components of the basic Bike by calling the
     * printComponents function of the superclass and then also the
     * two components that this class adds.
     */
    @Override
    public void printComponents(){
        // Starts by calling the printComponents method of the superclass
        // before printing specific components of this class
        super.printComponents();
        
        System.out.println( frontLight.getName() );
        System.out.println( rearLight.getName() );
    }

}
/**
 * A class to define the behaviour of a FrontLight. It does not have
 * any specific functionality in this version.
 */
class FrontLight extends BikeComponent{ }

/**
 * A class to define the behaviour of a RearLight. It does not have
 * any specific functionality in this version.
 */
class RearLight extends BikeComponent{ }