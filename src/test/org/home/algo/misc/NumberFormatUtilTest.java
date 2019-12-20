package org.home.algo.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberFormatUtilTest {

    @Test
    public void isValidHexadecimal() throws Exception {
        String input = "00FF";
        assertTrue(NumberFormatUtil.isValidHexadecimal(input));
    }
}