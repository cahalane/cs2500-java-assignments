import java.util.ArrayList;

/**
 * This file defines a stack-based Calculator class, and a function that
 * tests the class in main(). The calculator performs operation using the
 * values that are on the top of the stack.
 *
 * The stack is an ArrayList with a permanently defined top-of-stack at
 * index 0.
 *
 * @author  Colm Cahalane (113326986)
 */

public class Calculator{
    /**
     * Rather than the stack expanding outwards, I let index 0 represent
     * the top of the stack; meaning all objects are added to, removed from
     * and ordered starting at zero. This in my mind is logical as we do not
     * have to continually increment/decrement a stack pointer variable.
     */
    private static final int INDEX_OF_TOP_OF_STACK = 0;

    /**
     * I have defined some error messages for the program as class-specfic
     * constants. The program will not halt execution on an out-of-bounds
     * error but instead warn the user about it and proceed onwards.
     */
    private static final String BINARY_OPERATION_ERROR_MSG 
            = "There are not two valid values on the stack. ";
    private static final String UNARY_OPERATION_ERROR_MSG 
            = "There is not a valid value on top of the stack. ";
    private static final String OPERATION_NOT_ATTEMPTED_MSG 
            = "The operation was not attempted. ";

    /**
     * The Calculator uses a stack to store operands.
     * Rather than implement a new Stack class, I'm using an ArrayList
     * as it has all of the useful methods that I require for the
     * calculator to work. 
     */
    private ArrayList<Integer> stack;

    /**
     * Constructs a new Calculator with an empty stack.
     * @return Calculator with empty stack.
     */
    public Calculator(){

        stack = new ArrayList<Integer>();
    }

    /**
     * The main function that defines the operation of the program.
     * This is a test case. It creates a Calculator object and
     * pushes values to the stack and performs operations until
     * it produces the result of the equation (3 x (3 x 2 + 1)) x 2.
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.pushValue(3);
        calc.pushValue(2);
        calc.multiply();    // Gives us 3 x 2
        calc.pushValue(1);
        calc.add();         // Gives us 3 x 2 + 1
        calc.pushValue(3);
        calc.multiply();    // Gives us 3 x (3 x 2 + 1)
        calc.pushValue(2);
        calc.multiply();    // Gives us (3 x (3 x 2 + 1)) x 2

        System.out.println( calc.readValue() ); // Show result.
    }

    /**
     * Places an integer value at the top of the stack.
     * @param value Integer value to place on top of stack.
     */
    public void pushValue(final int value){
        stack.add(INDEX_OF_TOP_OF_STACK, value);
    }

    /**
     * Removes a value from the top of the stack, if possible.
     * 
     * If no value exists on top of the stack, prints an error message
     * as a side effect.
     */
    public void popValue(){
        if( unaryOperationIsErrorFree() ){
            stack.remove(INDEX_OF_TOP_OF_STACK);
        } else {
            System.err.println( UNARY_OPERATION_ERROR_MSG +
                                OPERATION_NOT_ATTEMPTED_MSG );
        }
    }

    /**
     * Returns the current value of the top of the stack without changing it.
     *
     * If no value exists on top of the stack, prints an error message
     * as a side effect.
     * 
     * @return An integer value representing the top of the stack, or
     *         zero if the there is no value at top of the stack.
     */
    public int readValue(){
        int returnValue;

        if( unaryOperationIsErrorFree() ){
            returnValue = stack.get(INDEX_OF_TOP_OF_STACK);
        } else {
            System.err.println( UNARY_OPERATION_ERROR_MSG +
                                "A value of 0 was returned." );
            returnValue = 0;
        }

        return returnValue;
    }

    /**
     * Increments the current value of the top of the stack.
     *
     * If no value exists on top of the stack, prints an error message
     * as a side effect.
     */
    public void increment(){
        if( unaryOperationIsErrorFree() ){
            // Get the value at the top of the stack, increment it.
            int value = stack.get(INDEX_OF_TOP_OF_STACK);
            value++;

            // Place this value back on the top of the stack!
            stack.set(INDEX_OF_TOP_OF_STACK, value);
        } else {
            System.err.println( UNARY_OPERATION_ERROR_MSG +
                                OPERATION_NOT_ATTEMPTED_MSG );
        }
    }

    /**
     * Decrements the current value of the top of the stack.
     *
     * If no value exists on top of the stack, prints an error message
     * as a side effect.
     */
    public void decrement(){
        if( unaryOperationIsErrorFree() ){
            //Get the value at the top of the stack, decrement it.
            int value = stack.get(INDEX_OF_TOP_OF_STACK);
            value--;

            // Place this value back on the top of the stack!
            stack.set(INDEX_OF_TOP_OF_STACK, value);
        } else {
            System.err.println( UNARY_OPERATION_ERROR_MSG +
                                OPERATION_NOT_ATTEMPTED_MSG );
        }
    }

    /**
     * Adds the two values at the top of the stack.
     * Replaces these two values with result if successful.
     *
     * If no values exist in the top two positions of the stack,
     * prints an error message as a side effect, and does not
     * attempt the operation.
     */
    public void add(){
        if( binaryOperationIsErrorFree() ) {    
            int result = stack.get( INDEX_OF_TOP_OF_STACK )
                       + stack.get( INDEX_OF_TOP_OF_STACK + 1 );
        
            putBinaryResultOnStack(result);
        } else {
            System.err.println( BINARY_OPERATION_ERROR_MSG +
                                OPERATION_NOT_ATTEMPTED_MSG );
        }
    }

    /**
     * Subtracts the two values at the top of the stack.
     * Replaces these two values with result if successful.
     *
     * If no values exist in the top two positions of the stack,
     * prints an error message as a side effect, and does not
     * attempt the operation.
     */
    public void subtract(){
        if( binaryOperationIsErrorFree() ) {        
            int result = stack.get( INDEX_OF_TOP_OF_STACK )
                       - stack.get( INDEX_OF_TOP_OF_STACK + 1 );
        
            putBinaryResultOnStack(result);
        } else {
            System.err.println( BINARY_OPERATION_ERROR_MSG +
                                OPERATION_NOT_ATTEMPTED_MSG );
        }
    }

    /**
     * Multiplies the two values at the top of the stack.
     * Replaces these two values with result if successful.
     *
     * If no values exist in the top two positions of the stack,
     * prints an error message as a side effect, and does not
     * attempt the operation.
     */
    public void multiply(){
        if( binaryOperationIsErrorFree() ) {        
            int result = stack.get( INDEX_OF_TOP_OF_STACK )
                       * stack.get( INDEX_OF_TOP_OF_STACK + 1 );
        
            putBinaryResultOnStack(result);
        } else {
            System.err.println( BINARY_OPERATION_ERROR_MSG +
                                OPERATION_NOT_ATTEMPTED_MSG );
        }
    }

    /**
     * Divides the two values at the top of the stack.
     * Replaces these two values with result if successful.
     *
     * If no values exist in the top two positions of the stack,
     * prints an error message as a side effect, and does not
     * attempt the operation.
     */
    public void divide(){
        if( binaryOperationIsErrorFree() ) {        
            int result = stack.get( INDEX_OF_TOP_OF_STACK )
                       / stack.get( INDEX_OF_TOP_OF_STACK + 1 );
        
            putBinaryResultOnStack(result);
        } else {
            System.err.println( BINARY_OPERATION_ERROR_MSG +
                                OPERATION_NOT_ATTEMPTED_MSG );
        }
    }

    /**
     * Repalces the values in the top two positions of the stack with 
     * a result. Used by binary operations like add(), subtract() etc.
     *
     * @param value An integer result of a binary Calculator operation.
     */
    private void putBinaryResultOnStack(final int value){
        stack.set(INDEX_OF_TOP_OF_STACK, value);  // Puts result on top of stack
        stack.remove(INDEX_OF_TOP_OF_STACK + 1);  // Destroys old value on stack
    }

    /**
     * A check used by unary operations in the calculator to see
     * if a value exists at the top of the stack; that is, if the
     * size of the stack is greater than 0.
     * 
     * @return A boolean value indicating if is a value
     *         on top of the stack.
     */
    private boolean unaryOperationIsErrorFree(){
        return (stack.size() > 0);
    }

    /**
     * A check used by binary operations in the calculator to see
     * if values exist at the top two positions of the stack; that
     * is, if the size of the stack is greater than 1.
     * 
     * @return A boolean value indicating if there are
     *         values on top of the stack.
     */
    private boolean binaryOperationIsErrorFree(){
        return (stack.size() > 1);
    }

}