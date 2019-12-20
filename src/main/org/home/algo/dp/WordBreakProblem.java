package org.home.algo.dp;

import java.util.Set;

public class WordBreakProblem {


    /*public boolean isInDictionary(String input, Set<String> dictonary) {
        return dictonary.contains(input);
    }*/

    public boolean breakWordRecursively(String input, Set<String> dictonary) {
        if (input == null || input.length() == 0) {
            return true;
        }
        for (int i = 1; i <= input.length(); i++) {
            if (dictonary.contains(input.substring(0, i))
                    && breakWordRecursively(input.substring(i), dictonary)) {
                return true;
            }
        }
        return false;

    }
}
