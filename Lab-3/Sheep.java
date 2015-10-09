/**
* This file defines a Sheep class.
* A Sheep can identify itself, recognise its two most recent children,
* reproduce and respond to calls.
*
* Assignment: 3
*
* @author Colm Cahalane (ID 113326986)
*/
public class Sheep {
    /**
     * A class constant controls the number of children a
     * Sheep object can remember.
     */
    private static final int NUMBER_OF_MEMORABLE_CHILDREN = 2;

    /**
     * The Sheep class has two instance variables: its own name
     * and an array used to store object references to its children.
     */
    private final String name;
    private Sheep[] children = new Sheep[NUMBER_OF_MEMORABLE_CHILDREN];

    /**
    * Constructor for sheep with a given, unique name.
    *
    * @param inputName A user-supplied unique name for the sheep.
    * @return  A new sheep object.
    */
    public Sheep(final String inputName) {
        this.name = inputName;
    }

    /**
    * A method by which the sheep identifies itself. We implement this
    * by printing the string representation of the sheep.
    *
    * The string representation that we use for this sheep is custom.
    * We define it in the toString() method.
    */
    public void identify() {
        System.out.println(this);
    }

    /**
    * A method by which we call a specific sheep by name.
    * The object invokes the private recognise(String) with the input.
    * If the user input matches the sheep's internal name, it will bleat()
    * back.
    *
    * @param inputName A name that the user uses to try to call sheep.
    */
    public void call(final String inputName) {
        this.recognise(inputName);
    }
    /**
    * A method by which a sheep examines if its name matches a supplied name.
    * Private method; users can access this using the method call(String).
    * 
    * @param inputName A String name to be compared to the sheep's own name.
    */
    private void recognise(final String inputName) {
        if ( inputName.equals(name) ) {
            this.bleat();
        }
    }

    /**
     * A call to the user from the sheep.
     * Triggered when a user calls the sheep.
     */
    private static void bleat() {
        System.out.println("Bleat!");
    }

    /**
    * A method by which a sheep reproduces; creating a new Sheep and
    * making this a part of the sheep's internal array of its own children.
    *
    * @param inputName A name to be given to the new child sheep
    * @return A brand new sheep object. 
    */
    public Sheep reproduce(final String inputName) {
        for ( int i = 1 ; i != NUMBER_OF_MEMORABLE_CHILDREN ; i++ ) {
            // Move eacb child a position forward while this is possible...
            children[i] = children[i-1];
        }
        
        // Create a new child sheep in the first position.
        children[0] = new Sheep(inputName);

        // Return the new Sheep object reference to the user.
        return children[0];
    }

    /**
    * A method by which a sheep attempts to see if it recognises another.
    * The user supplies a Sheep object and this is compared to Sheep 
    * objects in the Children array. If a sheep recognises its child, it 
    * prints. Otherwise, it points out it doesn't know the other sheep.
    *
    * @param inputSheep A Sheep object to compare to the instance's children.
    */
    public void recognise(final Sheep inputSheep) {
        boolean recognisedChild = false;

        for( int i=0; i != NUMBER_OF_MEMORABLE_CHILDREN; i++ ){
            if( inputSheep.equals( children[i] ) ){
                // If the inputted Sheep object reference
                // corresponds to one of the Children objects
                recognisedChild = true;
            }
        }

        System.out.println(
                (recognisedChild) ?
                ("\"" + inputSheep.name + "\" is my child.") :
                ("I don't recognise \"" + inputSheep.name + "\".")
        );
    }

    /**
     * Overrides the default Object.toString() method.
     * More suitable to Sheep objects as it returns the sheep's own name.
     *
     * @return String in the format of "I am a sheep. My name is [name]." 
     */
    public String toString(){
        return ("I am a Sheep. My name is " + name + ".");
    }

}