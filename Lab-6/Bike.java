/**
 * Class defining an abstract Bike. It contains all the
 * standard elements that a bike has by standard: its Brakes,
 * wheels, saddle and handlebar. It IS abstract however as
 * this basic bike should not be instantiated. It lacks a frame,
 * and is not a fully-formed bike.
 * All other models of bike are based on this Bike class.
 *
 * @author Colm Cahalane (ID 113326986) 
 */
public abstract class Bike {

    // String used in the user-facing interface.
    private static final String SEPARATOR = "=============";

    // Some Bike Components that we use in a basic bike.
    private final Brakes brakes;
    private final Wheels wheels;
    private final Saddle saddle;
    private final Handlebar handlebar;

    /**
     * Constructor for this abstract Bike object to be used by
	 * child classes for the purpose of expanding upon this Bike.
     * @return       A fully-formed Bike object to be extended.
     */
    public Bike(){
        this.brakes = new Brakes();
        this.wheels = new Wheels();
        this.saddle = new Saddle();
        this.handlebar = new Handlebar();
    }

    /**
     * Makes the Bike object print out its list of components.
     * This is used and "extended" by child classes which may
     * print additional components.
     */
    public void printComponents(){
        // Prints out name of type the bike.
        System.out.println( this.getName() );
        System.out.println( SEPARATOR );    // Decoration

        // Prints out the names of each of the types of components
        // that are specific to this bike.
		System.out.println( brakes.getName() );
		System.out.println( wheels.getName() );
		System.out.println( saddle.getName() );
		System.out.println( handlebar.getName() );
    }

    /**
     * Returns a string representation of the name of the bike.
	 * Here, we use the name of the class itself for simplicity.
     * This is FINAL. It should not be overriden at any point.
	 * @return String: name of class (type of bike)
     */
    public final String getName(){
        // Returns the value of getName from the class.
        return this.getClass().getName();
    }	
	
    /**
     * A simple user-facing interface for testing different kinds of
     * Bike objects. It creates a CityBike, Hybrid and MountainBike
     * and gets their component list.
     * 
     * @param args Array of string arguments. Here, it is unused.
     */
    public static void main(String[] args){
        System.out.println(); // Decoration

        // Initialise and create new test case Bikes
        CityBike cityBike = new CityBike();
        Hybrid hybrid = new Hybrid();
        MountainBike mountainBike = new MountainBike();

        // Each Bike in turn should print their components and
        // leave a newline space as a separator.
        cityBike.printComponents();
		System.out.println();

        hybrid.printComponents();
		System.out.println();

        mountainBike.printComponents();
		System.out.println();
	}
}
/**
 * A class defining the behaviour of individual bike Components. All
 * bike components extend this class. At the moment, a Bike component
 * can return its name.
 * This class is abstract. BikeComponents must be more clearly defined.
 */
abstract class BikeComponent {
    /**
     * A simple method by which a Bike Component returns its name.
     * It does this by returning the name of the class on which it is
     * based.
     * This is FINAL. The behaviour of such should not be overriden.
     * @return Name of Bike Component based on type.
     */
    public final String getName(){
        return this.getClass().getName();
    }
}

/**
 * A class to define the behaviour of Brakes. It does not have any
 * specific functionality in this version.
 */
class Brakes extends BikeComponent { }

/**
 * A class to define the behaviour of Wheels. It does not have any
 * specific functionality in this version.
 */
class Wheels extends BikeComponent { }

/**
 * A class to define the behaviour of a Saddle. It does not have any
 * specific functionality in this version.
 */
class Saddle extends BikeComponent { }

/**
 * A class to define the behaviour of Handlebars. It does not have any
 * specific functionality in this version.
 */
class Handlebar extends BikeComponent { }