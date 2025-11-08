package com.example.mycalculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class MathEvalTest {

    /** Test MathEval.eval */
    @Test
    public void testMathEval() {
        // Test operations
        assertEquals("3", MathEval.eval("1+2"));  // addition
        assertEquals("1", MathEval.eval("5-4"));  // subtraction
        assertEquals("12", MathEval.eval("3*4")); // multiplication
        assertEquals("3", MathEval.eval("6/2"));  // division

        // Decimal result
        assertEquals("1.5", MathEval.eval("3/2"));
        assertEquals("4.5", MathEval.eval("1.5+3"));

        // Strips trailing .0 for integers
        assertEquals("5", MathEval.eval("2*2.5"));
        assertEquals("1", MathEval.eval("1.0"));

        // Invalid expression
        assertEquals("Error", MathEval.eval("2+/2"));
        assertEquals("Error", MathEval.eval("1/0"));
        assertEquals("Error", MathEval.eval("abc"));
    }

}
