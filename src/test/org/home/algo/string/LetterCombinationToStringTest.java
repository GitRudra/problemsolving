package org.home.algo.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LetterCombinationToStringTest {

    @Test
    public void letterCombinationsOne() {
        String digits = "23";
        LetterCombinationToString combinator = new LetterCombinationToString();
        System.out.println(combinator.letterCombinations(digits));
    }

    @Test
    public void letterCombinationsTwo() {
        String digits = "";
        LetterCombinationToString combinator = new LetterCombinationToString();
        System.out.println(combinator.letterCombinations(digits));
    }
}