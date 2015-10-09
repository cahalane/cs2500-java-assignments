import java.util.ArrayList;

/**
* This file defines a Sheep class created for Assignment 3 ,
* A field is where sheep are produced and interact with one another.
*
* Assignment: 3
*
* @author Colm Cahalane (ID 113326986)
*/

public class Field {

    /**
     * Sheep in a field are stored in a sheepInField array.
     */
    private static ArrayList<Sheep> sheepInField = new ArrayList<Sheep>( );

    /**
     * This is a main() method which defines the interface shown to the
     * user. This is a testing environment, in which a "Mother" sheep is
     * created and reproduces to create other sheep.
     *
     * Each sheep identifies itself in turn.
     * Sheep other than the "mother" will be sent to the "mother"
     * to be recognised.
     */
    public static void main(String[] args) {
        sheepInField.add( new Sheep("Dolly") );

        // We'll make a separate reference to this for simplicity.
        Sheep dolly = sheepInField.get(0);

        // We call our new sheep by its name.
        dolly.call("Dolly");

        // The mother sheep reproduces to fill the Field.
        sheepInField.add( dolly.reproduce("Bembo") );
        sheepInField.add( dolly.reproduce("Daisy") );
        sheepInField.add( dolly.reproduce("Patsy") );

        // We ask each sheep in the Field to identify itself in turn.
        for(Sheep currSheep : sheepInField){
            currSheep.identify();
        }

        // We ask each the Mother sheep to identify its children.
        for( int i=1; i != sheepInField.size() ; i++){
            dolly.recognise( sheepInField.get(i) );
        }

    }

}