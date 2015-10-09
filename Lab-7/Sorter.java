import java.util.*;

/**
 * Sorter is a class which contains methods relating to the sorting
 * of ArrayLists of comparable values. It uses the QuickSort algorithm
 * to do so.
 *
 * It has a publicly accessible sort(ArrayList) function, and a number
 * of private methods that this method uses.
 *
 * It also has a public-facing test interface that is used to show the
 * sorting algorithm at work.
 *
 * @author Colm Cahalane (ID 113326986) 
 */
public class Sorter {

    // Some constant values which we shall use throughout the
    // class.
    private static final int INDEX_OF_START_OF_ARRAYLIST = 0;
    private static final int COMPARETO_VALUE_FOR_EQUAL_OBJECTS = 0;
    private static final int OFFSET_BY_ONE = 1;
    private static final int MAX_SIZE_OF_TESTING_ARRAYLIST = 3;

    /**
     * Returns a sorted copy of the inputted arrayList. Note; this is
     * used as the intial function, meaning it takes in the parameter
     * of a single ArrayList. It calls the recursive sort(array,lo,hi)
     * which performs all of the logic inside.
     * 
     * @param  toSort An arraylist that needs to be sorted
     * @return        The arraylist sorted in ascending numerical order
     */
    public static void sort(ArrayList<Comparable> toSort){
        sort( toSort, 
              INDEX_OF_START_OF_ARRAYLIST, 
              toSort.size()-OFFSET_BY_ONE );
    }

    /*  HOW QUICKSORT WORKS:
      
      if the arraylist we are sorting has one or zero elements
          it is already sorted
          do nothing
      else
         we select a pivot point, generally as the midpoint of the
         arraylist that we are sorting

            partition:
               we re-order the array so that values smaller than that
               at the pivot go to the left side of the pivot and all
               values larger than that at the pivot go to the right of it
               return index of pivot

          then we recursively sort the two "slices" of the array
          that exist either side of the partition such that eventually
          the entire array has been sorted
    */
    /**
     * Given an arraylist and low/high values for the range in which to
     * operate, we will use quicksort methods to sort that range of the
     * array. This function will recursively call itself as required.
     * @param toSort An ArrayList containing the range to be sorted.
     * @param lo     Index of the start of the range to sort.
     * @param hi     Index of the end of the range to sort.
     */
    private static void sort(ArrayList<Comparable> toSort,
                                          int lo, int hi){

        /**************************************************************/

        // lo<hi is the easiest way to check if this "slice" of 
        // the arraylist has one or zero elements:
        // lo==hi at size one, lo>hi at size zero        
        if (lo<hi){
            // We commence sorting using the method listed above (and
            // commented on in the "Partition" function) to generate two
            // partitions that in turn will also need to be sorted.
            int partition = partition(toSort,lo,hi);
            sort( toSort, lo, partition-OFFSET_BY_ONE );
            sort( toSort, partition+OFFSET_BY_ONE, hi );
        }
        //else, do nothing!
    }

    /**
     * Given an arraylist to sort and a range of this arraylist in which
     * to operate, this function will determine a pivot value, placing
     * all values lower than the pivot value before the pivot point and 
     * all values greater than the pivot value after the pivot point.
     * It returns the index of the pivot point following this procedure,
     * allowing the arraylist to be recursively sorted (see Sort function)
     * 
     * @param  toSort ArrayList that needs to be sorted.
     * @param  lo     Index of the lower boundary in which this function
     *                should operate.
     * @param  hi     Index of the higher boundary in which this function
     *                should operate.
     * @return        Index of the pivot point following the execution
     *                of this function.
     */
    private static int partition(ArrayList<Comparable> toSort,
                                             int lo, int hi){
        // We select the midpoint of the array slice, choosing that
        // value as the index of the pivot.
        // We use (hi+lo >>> 1) instead of (hi+lo)/2 as it is less
        // susceptible to integer error.
        int pivotIndex = (hi+lo) >>> 1;

        // We'll take this value now for the sake of future comparisons.
        Comparable pivotValue = toSort.get(pivotIndex);

        // We place the pivot initially at toSort[hi]
        swap( toSort, pivotIndex, hi);

        // We start the index of the partition at the low point.
        // this is because we will increment this counter as we
        // progress through the array.
        int partition = lo;

        for( int index = lo; index < hi; index++ ){
            // Looping through the array, we see if the pivot value
            // we have chosen is greater than (or equal to) the value at
            // the index we are scanning...
            if( pivotValue.compareTo( toSort.get(index) ) >= 
                              COMPARETO_VALUE_FOR_EQUAL_OBJECTS ){
                // If the value at the current index is less than or
                // the pivot, it must therefore be moved to the left 
                // side of the pivot in the array; we move it to the 
                // current partition point. The partition point is then 
                // incrememnted to prepare for the next such move.
                swap( toSort, partition, index );
                partition++;
            }
        }

        // Once the above loop is finished, the pivot value should be
        // placed in the point of the array where we determined our
        // partition point to be, so all values before it are lower
        // and all values after it are higher. 
        swap( toSort, partition, hi );

        // We return the partition index so that smaller arrays
        // can be recursively sorted.
        return partition;
    }

    /**
     * Provides a user-facing testing interface for the sorting algorithm
     * defined in this class. It generates an array of variable size
     * containing integers of variable value, prints their value,
     * sorts the array, and reprints that value. 
     * @param args An array of command-line arguments supplied to the
     *             program. In this program, it shall not be used.
     */
    public static void main(String[] args){
        ArrayList<Comparable> array = new ArrayList<Comparable>();
        Random rng = new Random();

        // Creates an arraylist of integers of a random length between
        // zero and three, and fills it with random integers.
        int arrayLength = rng.nextInt(
                                      MAX_SIZE_OF_TESTING_ARRAYLIST +
                                      OFFSET_BY_ONE ); 
        for(int index = 0; index < arrayLength; index++){
            
            array.add( rng.nextInt() );

        }

        printArray(array);
        sort( array );
        printArray( array );
    }

    /**
     * Given an Arraylist, this function will print a representation
     * of the contents therein by printing the toString representation
     * of each with spacing between curly brackets.
     * @param array The array that we wish to print out.
     */
    private static void printArray(ArrayList<Comparable> array){
        System.out.print("{   ");
        for(Comparable toPrint : array){
            System.out.print(toPrint);

            System.out.print("   ");
        }
        System.out.println("}");
    }

    /**
     * Given an arraylist and two index values, this function shall
     * swap the values at the two indexes.
     * 
     * @param arrayList   The arraylist containing the values to be
     *                    swapped.
     * @param indexOne The index of the first value to be swapped.
     * @param indexTwo The index of the second value to be swapped.
     */
    private static void swap( ArrayList<Comparable> arrayList,
                              int indexOne, int indexTwo ) {
        Comparable variableOne = arrayList.get(indexOne);
        Comparable variableTwo = arrayList.get(indexTwo);
        arrayList.set(indexOne, variableTwo);
        arrayList.set(indexTwo, variableOne);
    }

}