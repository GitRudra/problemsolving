package org.home.algo.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParenthesesMatcherTest {

    ParenthesesMatcher matcher;
    @Before
    public void setUp() throws Exception {
        matcher = new ParenthesesMatcher();
    }

    @Test
    public void matchParenthesesOne() {
        String input = "()";
        assertTrue(matcher.matchParentheses(input));
    }

    @Test
    public void matchParenthesesTwo() {
        String input = ")(";
        assertFalse(matcher.matchParentheses(input));
    }

}