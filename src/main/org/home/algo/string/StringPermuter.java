package org.home.algo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is responsible for all string permutation related problems
 */
public class StringPermuter {

    private void permuteLexicographically(char[] input,
                                          String str,
                                          List<String> resultList) {
        if (str.length() == input.length) {
            //System.out.println(str);
            resultList.add(str);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            permuteLexicographically(input, str + input[i], resultList);
        }
    }

    public List<String> findLexicographicPermutation(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        char[] inputCharArray = input.toCharArray();
        Arrays.sort(inputCharArray);
        List<String> results = new ArrayList<>();
        permuteLexicographically(inputCharArray, "", results);
        return results;
    }

    private void swap(char[] input, int x, int y) {
        char ch = input[x];
        input[x] = input[y];
        input[y] = ch;
    }

    /**
     * Helper method to do the permutation of string.
     * The method works on the basis of Backtracking
     *
     * @param input  the input string as character array.
     * @param start  the start index of the array
     * @param end    the end index of the array
     * @param result List of permutation.
     */
    public void permuteString(char[] input,
                              int start,
                              int end,
                              List<String> result) {
        if (start == end) {
            result.add(String.valueOf(input));
            return;
        } else {
            for (int i = start; i <= end; i++) {
                swap(input, start, i);
                permuteString(input, start + 1, end, result);
                swap(input, start, i);
            }
        }

    }

    /**
     * A permutation, also called an “arrangement number” or “order,” i
     * s a rearrangement of the elements of an ordered
     * list S into a one-to-one correspondence with S itself.
     * A string of length n has n! permutation.
     * Below are the permutations of string ABC.
     * ABC ACB BAC BCA CBA CAB
     * <p>
     * Algorithm Paradigm: Backtracking
     * Time Complexity: O(n*n!) Note that there are n! permutations and
     * it requires O(n) time to print a a permutation.
     *
     * @param input
     * @return
     */
    public List<String> permuter(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        List<String> results = new ArrayList<>();
        permuteString(input.toCharArray(), 0, input.length() - 1, results);
        return results;
    }

    public static void main(String[] args) {
        StringPermuter obj = new StringPermuter();
        System.out.println(obj.findLexicographicPermutation("ABC"));
        System.out.println(obj.permuter("ABC"));
    }

    /**
     * Write a function to generate all possible n pairs of balanced parentheses.
     * Input : n=1
     * Output: {}
     * <p>
     * Input : n=2
     * Output:
     * {}{}
     * {{}}
     *
     * @param n
     * @return
     */
    public static ArrayList<String> combinationOfBalancedParenthesis(int n) {
        ArrayList<String> results = new ArrayList<>();
        if (n == 0) {
            return results;
        }

        char[] arr = new char[2 * n];
        balancedParenthesesGenerator(arr, results, 0, n, 0, 0);

        return results;
    }

    /**
     * Keep track of counts of open and close brackets.
     * <p>
     * Initialize these counts as 0.
     * Recursively call the balancedParenthesesGenerator() function
     * until open bracket count is less than the given n.
     * If open bracket count becomes more than the close bracket count,
     * then put a closing bracket and recursively call for the remaining brackets.
     * If open bracket count is less than n,
     * then put an opening bracket and call balancedParenthesesGenerator for the remaining brackets.
     *
     * @param arr        the character array to store braces
     * @param results    store the list of combinations
     * @param pos        current position in {@code arr}
     * @param n          number of pairs
     * @param openCount  count of open braces
     * @param closeCount count of closing braces
     */
    private static void balancedParenthesesGenerator(char[] arr,
                                                     List<String> results,
                                                     int pos,
                                                     int n,
                                                     int openCount,
                                                     int closeCount) {
        if (closeCount == n) {
            results.add(new String(arr));
            return;
        }
        if (openCount > closeCount) {
            arr[pos] = ')';
            balancedParenthesesGenerator(arr,
                    results,
                    pos + 1,
                    n,
                    openCount,
                    closeCount + 1);
        }
        if (openCount < n) {
            arr[pos] = '(';
            balancedParenthesesGenerator(arr,
                    results,
                    pos + 1,
                    n,
                    openCount + 1,
                    closeCount);
        }
    }
}
