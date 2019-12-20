package org.home.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubStringWithNonRepeatingCharacterTest {

    @Test
    public void lengthOfLongestSubstringOne() {
        String s = "pwwkew";
        int expected = 3;
        int actual = LongestSubStringWithNonRepeatingCharacter.lengthOfLongestSubstring(s);
        assertEquals(expected,actual);
    }
    @Test
    public void lengthOfLongestSubstringTwo() {
        String s = "bbbbbb";
        int expected = 1;
        int actual = LongestSubStringWithNonRepeatingCharacter.lengthOfLongestSubstring(s);
        assertEquals(expected,actual);
    }
    @Test
    public void lengthOfLongestSubstringThree() {
        String s = "abcabcabb";
        int expected = 3;
        int actual = LongestSubStringWithNonRepeatingCharacter.lengthOfLongestSubstring(s);
        assertEquals(expected,actual);
    }

    @Test
    public void lengthOfLongestSubstringFour() {
        String s = "dvdf";
        int expected = 3;
        int actual = LongestSubStringWithNonRepeatingCharacter.lengthOfLongestSubstring(s);
        assertEquals(expected,actual);
    }
}