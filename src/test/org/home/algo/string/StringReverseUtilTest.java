package org.home.algo.string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringReverseUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void reverse() {
    }

    @Test
    public void reverseSentenceWordWise() {
    }

    @Test
    public void reverseSentenceWordWise1() {
        String input = "Oracle is Good Company";
        String expected = "Company Good is Oracle";
        String actual = StringReverseUtil.reverseSentenceWordWise(input);
        assertEquals(expected,actual);
    }

    @Test
    public void reverseSentenceWordWise2() {
        String input = "Oracle     is    Good       Company";
        String expected = "Company       Good    is     Oracle";
        String actual = StringReverseUtil.reverseSentenceWordWise(input);
        assertEquals(expected,actual);
    }
}