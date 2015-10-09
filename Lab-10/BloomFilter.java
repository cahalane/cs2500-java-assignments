import java.math.BigInteger;

/**
 * Basic implementation of a Bloom Filter which allows for
 * a fairly accurate probabilistic check to see if a string
 * is a member of a set.
 * @author Colm Cahalane (ID: 113326986)
 */
public class BloomFilter {
    private final static int[] PRIMES =
                            {2, 3, 5, 7, 11, 13, 17, 19};
    private final static int INITIAL_HASH_CODE = 1;
    private final Bitmap bitmap;
    private final int bitmapCapacity;
    private final int numberOfHashFunctions;

    /**
     * Constructor for a Bloom Filter with some user-defined
     * preferences. 
     *
     * @param  bitmapCapacity        Size of Bitmap to use
     * @param  numberOfHashFunctions Number of hash functions to
     *                               be used in implementation.
     */

    public BloomFilter(int bitmapCapacity, int numberOfHashFunctions){
        this.bitmapCapacity = bitmapCapacity;
        this.bitmap = new Bitmap(bitmapCapacity);
        this.numberOfHashFunctions = numberOfHashFunctions;
    }


    /**
     * Hashes a string.
     * @param  toHash     String that needs to be hashed.
     * @param  whichPrime A number to decide which prime number
     *                    to use.
     * @return            An integer hash for this specific number.
     */
    private int hashString( String toHash, int whichPrime ){
        int hashCode = INITIAL_HASH_CODE;

        for( int index = 0; index < toHash.length(); index++ ){
            // Generates a hashCode based on each character in the
            // string and a Prime from our list as 
            hashCode = hashCode * PRIMES[whichPrime%PRIMES.length]
                                + (int)toHash.charAt(index);
        }

        return hashCode;
    }

	/**
	 * Returns an index to be set\checked within the bitmap.
	 *
     * @param  toHash     String that needs to be hashed.
     * @param  whichPrime A number to decide which prime number
     *                    to use.
     * @return            An integer index for this string in a Boom filter.
	 */
    private int getIndex( String toHash, int whichPrime ){
        return hashString(toHash, whichPrime) % bitmapCapacity;
    }

    /**
     * Adds a string to the Bloom Filter by setting bitmap values using
     * many hash functions.
     *
     * @param  string     String that needs to be hashed.
     */
    public void add( String string ){
        for(int i=0; i<numberOfHashFunctions; i++){
            bitmap.set( getIndex(string.toLowerCase(), i) );
        }
    }

    /**
     * Checks for the presence of a string in the Bloom Filter using
     * many hash functions.
     *
     * @param  string     String that needs to be hashed.
     */
    public boolean contains( String string ){
        for(int i=0; i<numberOfHashFunctions; i++){
            if(! bitmap.contains( getIndex(string.toLowerCase(), i) ) ){
                return false;
            }
        }
        return true;
    }

    /**
     * A Bitmap which we use to implement the Bloom Filter.
     */
    private class Bitmap{
        private final int[] bits;

        // max_int - 1 used to form a mask. 
        private static final int MASK = Integer.SIZE - 1;
		private final int SHIFT;

        /**
         * Constructor for a bitmap of given capacity.
         *     
         * @param  capacity An integer value determining the capacity.
         * @return          Reference to this Bitmap object.
         */
        public Bitmap(int capacity){
            // Creates an array of at least one int, designed so that
            // for a value capacity, any value capacity/32 + 1 integers is 
            // required to construct the bitmap.
            bits = new int[(capacity + Integer.SIZE - 1) / Integer.SIZE];
			SHIFT = Integer.numberOfTrailingZeros(MASK+1);
        }

        /**
         * Sets a value in the bitmap at a given inded.
         * @param index Value to set in the bitmap.
         */
        public void set(int index){
            // Sets a bit in the bitmap, somehow.
            int indexOfIntegerToSet = index/Integer.SIZE;
            index = index % Integer.SIZE;

            int value = 0x1 << index;
            bits[index >> SHIFT] = bits[index >> SHIFT] | value;
        }

        /**
         * Checks if a value in the bitmap is set.
         * @param  index Index in the bitmap of the value to set.
         * @return       true/false if/if not set.
         */
        public boolean contains(int index){
            // bitwise comparison to check the value
			// at specified index within an array of integers.
            return (bits[ index >> SHIFT ] & (1 << (index & MASK))) != 0;
        }
    }
}