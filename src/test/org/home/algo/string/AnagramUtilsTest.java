package org.home.algo.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramUtilsTest {

    @Test
    public void isTwoStringAnagramOne() {
        String str1 = "geeks";
        String str2 = "egske";
        assertTrue(AnagramUtils.isTwoStringAnagram(str1, str2));
    }

    @Test
    public void isTwoStringAnagramTwo() {
        String str1 = "aa";
        String str2 = "bb";
        assertFalse(AnagramUtils.isTwoStringAnagram(str1, str2));
    }

    @Test
    public void isTwoStringAnagram() {
        String str1 = "geeks";
        String str2 = "egske";
        assertTrue(AnagramUtils.isTwoStringAnagram(str1, str2));
    }

    @Test
    public void printAnagramStringTogether() {
        String arr[] = {"geeksquiz", "geeksforgeeks",
                "abcd", "forgeeksgeeks",
                "zuiqkeegs"};
        int n = arr.length;
        AnagramUtils.printAnagramStringTogether(arr);
    }

    @Test
    public void removeMinimumCharacterToConvertAnagram() {
        String str1 = "bcadeh", str2 = "hea";
        int expected = 3;
        int actual = AnagramUtils.removeMinimumCharacterToConvertAnagram(str1,str2);
        assertEquals(expected,actual);
    }

    @Test
    public void removeMinimumCharacterToConvertAnagramTwo() {
        String str1 = "bca", str2 = "abc";
        int expected = 0;
        int actual = AnagramUtils.removeMinimumCharacterToConvertAnagram(str1,str2);
        assertEquals(expected,actual);
    }

    @Test
    public void removeMinimumCharacterToConvertAnagramThree() {
        String str1 = "cddgk", str2 = "gcd";
        int expected = 2;
        int actual = AnagramUtils.removeMinimumCharacterToConvertAnagram(str1,str2);
        assertEquals(expected,actual);
    }
}