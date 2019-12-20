package org.home.hackerearth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AkashAndGcdTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void scenarioOne() {
        int[] input = {3,4,3};
        AkashAndGcd solver = new AkashAndGcd(input);
        assertEquals(13, solver.cQuery(1,2));
        assertEquals(18, solver.cQuery(1,3));
        assertEquals(5, solver.cQuery(3,3));
        solver.uQuery(1,4);
        assertEquals(21, solver.cQuery(1,3));
        assertEquals(16, solver.cQuery(1,2));

    }

    @Test
    public void uQuery() {
    }
}