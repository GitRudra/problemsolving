package org.home.algo.dp;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordBreakProblemTest {

    @Test
    public void isInDictonary() {
    }

    @Test
    public void testBreakWordRecursivelyOne() {
        Set<String> dictionary = getDictionaryOne();
        String input = "ilikesamsung";
        WordBreakProblem solver = new WordBreakProblem();
        assertTrue(solver.breakWordRecursively(input, dictionary));
    }

    @Test
    public void testBreakWordRecursivelyTwo() {
        Set<String> dictionary = getDictionaryOne();
        String input = "ilikenokia";
        WordBreakProblem solver = new WordBreakProblem();
        assertFalse(solver.breakWordRecursively(input, dictionary));
    }

    private Set<String> getDictionaryOne() {
        Set<String> dictionary = new HashSet();
        dictionary.add("mobile");
        dictionary.add("samsung");
        dictionary.add("sam");
        dictionary.add("sung");
        dictionary.add("man");
        dictionary.add("mango");
        dictionary.add("icecream");
        dictionary.add("and");
        dictionary.add("go");
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("ice");
        dictionary.add("cream");

        return dictionary;
    }
}