import java.util.Scanner;

/**
 * Basic implementation of a Bloom Filter-based
 * spell checker that using a simple user-facing
 * example.
 * @author Colm Cahalane (ID: 113326986)
 */
public class SpellChecker{

    /**
     * Main function. Creates a bloom filter using argument input,
     * allows the user to input features, and keeps the program running
     * until told to quit.
     * @param args     Array of command-line arguments.
     *                 [number of bits] [number of hashes] [number of words]
     */
    public static void main(String[] args) {
        // values must be initialised
        int numOfBits = 0;
        int numOfHashes = 0;
        int numOfWords = 0;
        try{  
            numOfBits = Integer.parseInt(args[0]);
            numOfHashes = Integer.parseInt(args[1]);
            numOfWords = Integer.parseInt(args[2]);
        } catch (Exception e){
            // If this fails, input does not exist or is malformed
            // Hence we must quit.
            System.err.println("Usage: java SpellChecker" +
                " [number of bits] [number of hashes] [number of words]");
            System.exit(1);
        }

        // Constructs bloomfilter based on user variables.
        BloomFilter bloom = new BloomFilter(numOfBits, numOfHashes);
        // Constructs a means of user input.
        Scanner scanner = new Scanner( System.in );

        System.out.println();
        System.out.println("Please enter strings to be recognised by the "
                            + "SpellChecker");
        // For up until the number of words specified, each line becomes
        // a recognised phrase within the bloom filter.
        for(int counter = 0; counter < numOfWords; counter++){
            bloom.add( scanner.nextLine() );
        }

        System.out.println();
        System.out.println("All strings have been loaded in to the SpellChecker.");
        System.out.println("Now, enter words that you would wish to test.");
        System.out.println("Type \"quit\" to quit at any time.");
        System.out.println("====================================================");

        // Until the uesr specifies a quit, check each word they input
        // for being in the bloom filter with necessary message.
        boolean keepGoing = true;
        while(keepGoing){
            String word = scanner.nextLine();
            if( word.equals( "quit" ) ){
                keepGoing = false;
            } else if( bloom.contains( word ) ){
                System.out.println("Success!");
            } else {
                System.out.println("Fail!");
            }
            System.out.println();
        }
    }
}