package org.home.algo.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostFixExpressionEvaluatorTest {

    @Test
    public void testEvaluateExpressionOne() {
        String input = "23+";
        String expected = "5";
        String actual = PostFixExpressionEvaluator.evaluateExpression(input);
        assertEquals(expected,actual);

    }
    //"231*+9-"
    @Test
    public void testEvaluateExpressionTwo() {
        String input = "231*+9-";
        String expected = "-4";
        String actual = PostFixExpressionEvaluator.evaluateExpression(input);
        assertEquals(expected,actual);

    }

}