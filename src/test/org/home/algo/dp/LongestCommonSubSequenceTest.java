package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubSequenceTest {

    @Test
    public void findLongestCommonSubSequenceRecursivelyOne() {
        LongestCommonSubSequence lcs = new LongestCommonSubSequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int expected =4;
        int actual = lcs.findLongestCommonSubSequenceRecursively(s1,s2);
        assertEquals(expected,actual);
    }

    @Test
    public void findLongestCommonSubSequenceTabularOne() {
        LongestCommonSubSequence lcs = new LongestCommonSubSequence();
        String s1 = "abcde";
        String s2 = "ace";
        int expected =3;
        int actual = lcs.lcsUtilTabular(s1,s2);
        assertEquals(expected,actual);
    }

    @Test
    public void findLongestCommonSubSequenceTabularTwo() {
        LongestCommonSubSequence lcs = new LongestCommonSubSequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int expected =4;
        int actual = lcs.lcsUtilTabular(s1,s2);
        assertEquals(expected,actual);
    }
}