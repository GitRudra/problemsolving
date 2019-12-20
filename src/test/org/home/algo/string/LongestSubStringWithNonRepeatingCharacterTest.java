package org.home.algo.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubStringWithNonRepeatingCharacterTest {

    @Test
    public void lengthOfLongestSubstring() {
        String input = "abcabcbb";
        int expected = 3;
        int actual = LongestSubStringWithNonRepeatingCharacter.lengthOfLongestSubstring(input);
        assertEquals(expected,actual);
    }
}