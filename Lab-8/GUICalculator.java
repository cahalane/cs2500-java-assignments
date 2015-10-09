import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
/**
 * A GUI Calculator application in Java that allows for two operands to be input
 * and an operation to be performed, displaying the result.
 * 
 * @author Colm Cahalane (ID: 113326986)
 */
public class GUICalculator {
    /**
     * A GUI Calculator must have fields for the two possible operands
     * (here referred to as x and y) and a label for the result output.
     */
    final private JTextField xField;
    final private JTextField yField;
    final private JLabel resultField;

    private static final int BUTTON_COULMN_WIDTH = 4;
    private static final int INDEX_FIRST_ELEMENT = 0;
    private static final int INDEX_SECOND_ELEMENT = 1;
    private static final int NUMBER_OF_OPERANDS_IN_UNARY_OPERATION = 1;
    private static final int NUMBER_OF_OPERANDS_IN_BINARY_OPERATION = 2;

    /**
     * The emumerated type Operator stores various mathematical operations,
     * symbols by which they are referred to and the logic by which they are
     * applied.
     */
    private enum Operator {
        PLUS("+", true, true) {
            public double apply(double[] operands){
                double result;

                if( operands.length == NUMBER_OF_OPERANDS_IN_UNARY_OPERATION )
                {
                    // Only one operand has been supplied.
                    // The operation is unary.
                    result = ( +operands[INDEX_FIRST_ELEMENT] ) ;
                } else {
                    // The operation is binary.
                    result = ( operands[INDEX_FIRST_ELEMENT]+
                               operands[INDEX_SECOND_ELEMENT] );
                }

                return result;
            }
        }, MINUS("-", true, true) {
            public double apply(double[] operands){
                double result;

                if( operands.length == NUMBER_OF_OPERANDS_IN_UNARY_OPERATION )
                {
                    // Only one operand has been supplied.
                    // The operation is unary.
                    result = ( -operands[INDEX_FIRST_ELEMENT] );
                } else {
                    // The operation is binary.
                    result = operands[INDEX_FIRST_ELEMENT] -
                             operands[INDEX_SECOND_ELEMENT]; 
                }

                return result;
            }
        }, MULTIPLY("*", false, true) {
            public double apply(double[] operands){
                return operands[INDEX_FIRST_ELEMENT] *
                       operands[INDEX_SECOND_ELEMENT]; 
            }
        }, DIVIDE("/", false, true) {
            public double apply(double[] operands) {
                return operands[INDEX_FIRST_ELEMENT] /
                       operands[INDEX_SECOND_ELEMENT]; 
            }
        }, SQRT("√", true, false) {
            public double apply(double[] operands) { 
                return Math.sqrt(operands[INDEX_FIRST_ELEMENT]);
            }
        }, EXPONENT("xʸ", false, true){
            public double apply(double[] operands) { 
                return Math.pow(operands[INDEX_FIRST_ELEMENT],
                                operands[INDEX_SECOND_ELEMENT]);
            }
        }, RECIPROCAL("1/x", true, false) {
            public double apply(double[] operands) { 
                return 1/operands[INDEX_FIRST_ELEMENT];
            }
        };

        // Each operation must have a reference symbol.
        private final String symbol;
        
        // Each operation must be able to be identified as having unary or binary
        // operations or both; we need this to perform checks later on in the
        // program.
        private final boolean hasUnaryOperation;
        private final boolean hasBinaryOperation;

        public boolean hasUnaryOperation(){
            return hasUnaryOperation;
        }
        public boolean hasBinaryOperation(){
            return hasBinaryOperation;
        }

        // The operation must contain logic for it to be applied on one or more
        // operands.
        public abstract double apply( double[] operands );

        Operator( String symbol, boolean hasUnaryOperation,
                  boolean hasBinaryOperation ) {
            this.symbol = symbol;
            this.hasUnaryOperation = hasUnaryOperation;
            this.hasBinaryOperation = hasBinaryOperation;
        }
        @Override public String toString( ) { return symbol; }
    }

    /**
     * Instantiates a windowed GUI Calculator that takes in two operands
     * and allows you to perform a variety of operations. This method defines
     * the user-facing interface that is seen.
     */
    public GUICalculator(){
        
        // Construct a frame to display the application.
        final JFrame frame = new JFrame();
        frame.setLayout( new FlowLayout() );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
        
        final JPanel mainPanel = new JPanel( new GridLayout(0,1) );
        frame.getContentPane().add(mainPanel);

        
        // Create text fields to input and display the values of X and Y operands
        // and a label for the result.
        xField = new JTextField();
        final JPanel xFieldPanel = new JPanel( new GridLayout(1,2) );
        final JLabel xLabel = new JLabel("x =", JLabel.CENTER);
        xFieldPanel.add(xLabel);
        xFieldPanel.add(xField);

        yField = new JTextField();
        final JPanel yFieldPanel = new JPanel( new GridLayout(1,2) );
        final JLabel yLabel = new JLabel("y =", JLabel.CENTER);
        yFieldPanel.add(yLabel);
        yFieldPanel.add(yField);

        resultField = new JLabel("", JLabel.CENTER);
        final JPanel resultFieldPanel = new JPanel( new GridLayout(1,2) );
        final JLabel resultLabel = new JLabel("result =", JLabel.CENTER);
        resultFieldPanel.add(resultLabel);
        resultFieldPanel.add(resultField);

        // Add all of these to the main display frame.
        mainPanel.add(xFieldPanel);
        mainPanel.add(yFieldPanel);
        mainPanel.add(resultFieldPanel);
        
        // Create a panel on which to display the buttons.
        JPanel buttonPanel = new JPanel( new GridLayout(0,BUTTON_COULMN_WIDTH) );

        // Creates a variable that counts buttons that we can use to manage the
        // number of buttons that appear in a row.
        int buttonIndex = 0;
        
        // Create buttons for each of the operations which we can run, adding
        // them to the panel in rows according to the set BUTTON_COULMN_WIDTH.
        for( Operator operator : Operator.values() ){
            buttonIndex++;
            MathButton button = new MathButton(operator);
            buttonPanel.add(button);
            if(buttonIndex == BUTTON_COULMN_WIDTH){
                mainPanel.add(buttonPanel);
                buttonPanel = new JPanel( new GridLayout(0,BUTTON_COULMN_WIDTH) );
            }
        }

        // If there's a row of buttons not yet added, add them!
        if(buttonIndex != BUTTON_COULMN_WIDTH){
            mainPanel.add(buttonPanel);
        }
        
        // Pack the UI.
        frame.pack();
    }

    /**
     * Main user-facing application. Simply creates a new GUICalculator object
     * that is displayed to the user.
     * @param args  Command-line arguments, unused. 
     */
    public static void main(String[] args){
        new GUICalculator();
    }

    /**
     * MathButton is an extension of JButton that implements the execution
     * and display of mathematical operations within this application.
     * It displays a mathematical symbol and listens for a user action
     * (button click). On performing this action, it collects the operands
     * and packages them to be passed to the operator's apply() method.
     */
    private class MathButton extends JButton implements ActionListener{
        Operator operator;

        // String to be placed in the result box on an error occuring.
        private static final String ERROR = "ERROR";

        /**
         * Creates a MathButton to display and execute the supplied Operator.
         * @param operator  Operator to be implemented.
         */
        public MathButton(Operator operator){
            super( operator.toString() );
            this.operator = operator;
            addActionListener(this);
        }

        /**
         * actionPerformed: upon a button click by a user, apply
         * this button's operation, taking in operands from the JTextField
         * objects and presenting the result to the user in a label.
         * @param event 
         */
        public void actionPerformed(ActionEvent event){
            // Button has been pressed. Attempt a mathematical operation.

            if( !xField.getText().isEmpty() ){
                if( !yField.getText().isEmpty() && operator.hasBinaryOperation() ){
                    // Perform Binary Opreation
                    try {
                        double[] operands = 
                             new double[NUMBER_OF_OPERANDS_IN_BINARY_OPERATION];
                        // Attempt to seek the operand values. Will result in
                        // the 
                        double xVal = Double.parseDouble( xField.getText() );
                        double yVal = Double.parseDouble( yField.getText() );
                        operands[INDEX_FIRST_ELEMENT] = xVal;
                        operands[INDEX_SECOND_ELEMENT] = yVal;
                        double result = operator.apply(operands);
                        resultField.setText( Double.toString(result) );
                    } catch (Exception e) {
                        // Operation failed; possibly the supplied values
                        // were badly formed or the operation was illegal.
                        onError();
                    }

                } else if ( operator.hasUnaryOperation() ){
                    // Perform Unary Operation
                    try {
                        // Attempt to seek the X value.
                        double xVal = Double.parseDouble( xField.getText() );
                        
                        // Create a package array for operands.
                        double[] operands =
                              new double[NUMBER_OF_OPERANDS_IN_UNARY_OPERATION];
                        operands[INDEX_FIRST_ELEMENT] = xVal;
                        
                        // Attempt to apply the operation; "try" block acts as
                        // fallback on any error.
                        double result = operator.apply(operands);
                        resultField.setText( Double.toString(result) );
                    } catch (Exception e) {
                        // Operation failed; possibly the supplied value
                        // was badly formed or the operation was illegal.
                        onError();
                    }
                } else {
                    // Attempting to call a binary-only operation with
                    // only one value.
                    onError();
                }
            } else {
                // No value was written in the X field.
                onError();
            }
        }

        /**
         * Fallback function to run when an error occurs.
         * In this version of the program it simply writes an error message
         * to the error field.
         */
        private void onError(){
            // Simplest fallback: write a simple error message to the result label.
            resultField.setText(ERROR);
        }
    }
}