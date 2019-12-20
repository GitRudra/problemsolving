package org.home.docs;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecompressStringTest {

    @Test
    public void decompressStringOne() {
         String input = "3[abc]4[ab]c";
         String expected = "abcabcabcababababc";
         String actual = DecompressString.decompressString(input);
         assertEquals(expected,actual);
    }

    @Test
    public void decompressStringTwo() {
        String input = "10[a]";
        String expected = "aaaaaaaaaa";
        String actual = DecompressString.decompressString(input);
        assertEquals(expected,actual);
    }

    @Test
    public void decompressStringThree() {
        String input = "2[3[a]b]";
        String expected = "aaabaaab";
        String actual = DecompressString.decompressString(input);
        assertEquals(expected,actual);
    }

    @Test
    public void decompressStringFour() {
        String input = "1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[xx]]]]]]]]]]]]]]]]]]]]";
        String expected = "xx";
        String actual = DecompressString.decompressString(input);
        assertEquals(expected,actual);
    }
}