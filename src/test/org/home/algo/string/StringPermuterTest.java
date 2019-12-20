package org.home.algo.string;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StringPermuterTest {

    @Test
    public void findLexicographicPermutation() {
    }

    @Test
    public void permuteString() {
    }

    @Test
    public void permuter() {
    }

    @Test
    public void combinationOfBalancedParenthesis() {
        int n = 3;
        ArrayList<String> expected = new ArrayList<>();
        expected.add("()()()");
        expected.add("()(())");
        expected.add("(())()");
        expected.add("(()())");
        expected.add("((()))");
        ArrayList<String> actual = StringPermuter.combinationOfBalancedParenthesis(n);
        actual.forEach(e-> System.out.println(e));
        assertEquals(expected,actual);

    }
}