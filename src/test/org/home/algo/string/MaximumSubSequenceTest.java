package org.home.algo.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MaximumSubSequenceTest {

    @Test
    public void isSubSequenceOne() {
        String str = "abppplee";
        String subSeq = "apple";
        assertTrue(MaximumSubSequence.isSubSequence(str,subSeq));
    }

    @Test
    public void isSubSequenceTwo() {
        String str = "abppplee";
        String subSeq = "bale";
        assertFalse(MaximumSubSequence.isSubSequence(str,subSeq));
    }
    @Test
    public void isSubSequenceThree() {
        String str = "abppplee";
        String subSeq = "kangroo";
        assertFalse(MaximumSubSequence.isSubSequence(str,subSeq));
    }

    @Test
    public void findLongestSubSequence() {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("able");
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("bale");
        dictionary.add("kangaroo");

        String word = "abppplee";
        String expected = "apple";
        String actual = MaximumSubSequence.findLongestSubSequence(dictionary,word);
        assertEquals(expected,actual);


    }
}