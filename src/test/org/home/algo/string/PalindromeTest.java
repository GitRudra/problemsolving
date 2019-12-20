package org.home.algo.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void checkAndGetPalindromeLength1() {
        Palindrome pal = new Palindrome();
        String input = "abba";
        String expected = "YES EVEN";
        String actual = pal.checkAndGetPalindromeLength(input);
        assertEquals(expected,actual);

    }

    @Test
    public void checkAndGetPalindromeLength2() {
        Palindrome pal = new Palindrome();
        String input = "aba";
        String expected = "YES ODD";
        String actual = pal.checkAndGetPalindromeLength(input);
        assertEquals(expected,actual);

    }

    @Test
    public void checkAndGetPalindromeLength3() {
        Palindrome pal = new Palindrome();
        String input = "abca";
        String expected = "NO";
        String actual = pal.checkAndGetPalindromeLength(input);
        assertEquals(expected,actual);

    }

    @Test
    public void checkAndGetPalindromeLength4() {
        int x = 8;
        System.out.println(Integer.toString(x,2));
        System.out.println(Integer.bitCount(x));
        x = 4;
        System.out.println(Integer.toString(x,2));
        System.out.println(Integer.bitCount(x));

    }
}