package org.home.algo.misc;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionConverterTest {

    @Test
    public void postfixToInfixConverter() {
        ExpressionConverter converter = new ExpressionConverter();
        String postfix = "ab+cd/*";
        String expected = "(a+b)*c/d";
        String actual = converter.postfixToInfixConverter(postfix);
        assertEquals(expected,actual);
    }

    @Test
    public void testPrefixToInfixConverterOne() {
        ExpressionConverter converter = new ExpressionConverter();
        String prefix = "*+AB-CD";
        String expected = "(A+B)*(C-D)";
        String actual = converter.prefixToInfixConverter(prefix);
        assertEquals(expected,actual);
    }
}