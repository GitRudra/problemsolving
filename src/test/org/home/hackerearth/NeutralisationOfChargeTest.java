package org.home.hackerearth;

import org.junit.Test;

import static org.junit.Assert.*;

public class NeutralisationOfChargeTest {

    @Test
    public void neutraliseChargeOne() {
        String input = "aaacbbcccd";
        String expected = "ad";
        String actual = NeutralisationOfCharge.neutraliseCharge(input);
        assertEquals(expected,actual);
    }

    @Test
    public void neutraliseChargeTwo() {
        String input = "abbbaaaababaaabbbabbbabbaaaabababbbbbbbababbbabaaaaabbbbaabbaabbbabbaabbbabaaaabaabbaaaaabbaababbbab";
        String expected = "babababababababa";
        String actual = NeutralisationOfCharge.neutraliseCharge(input);
        assertEquals(expected,actual);
    }

    @Test
    public void neutraliseChargeThree() {
        String input = "bababababababababb";
        String expected = "babababababababa";
        String actual = NeutralisationOfCharge.neutraliseCharge(input);
        assertEquals(expected,actual);
    }

}