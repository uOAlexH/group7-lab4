package com.example.mycalculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainActivityTest {

    /** Test MainActivity.evaluate */
    @Test
    public void testEvaluate() throws Exception {

        // Test operator replacements
        assertEquals("6", MainActivity.evaluate("2×3"));
        assertEquals("5", MainActivity.evaluate("10÷2"));

        // Test negative sign functionality
        assertEquals("-3", MainActivity.evaluate("-6+3"));
        assertEquals("1", MainActivity.evaluate("--1"));

        // Empty string returns "0"
        assertEquals("0", MainActivity.evaluate(""));

        // Test errors
        assertEquals("Error", MainActivity.evaluate("1÷0")); // div by 0
        assertEquals("Error", MainActivity.evaluate("abc")); // non-arithmetic string
    }
}


