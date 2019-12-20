package org.home.algo.dp;

/**
 * Given a sequence, find the length of the longest palindromic sub sequence
 * As another example, if the given sequence is “BBABCBCAB”,
 * then the output should be 7 as “BABCBAB” is the longest palindromic sub seuqnce in it.
 * “BBBBB” and “BBCBB” are also palindromic sub sequences of the given sequence,
 * but not the longest ones.
 *
 * The naive solution for this problem is to generate all subsequences of the given sequence
 * and find the longest palindromic sub sequence. This solution is exponential in term of time complexity.
 *
 * Let us see how this problem possesses both important properties of a Dynamic Programming (DP) Problem
 * and can efficiently solved using Dynamic Programming.
 *
 * 1) Optimal Substructure:
 * Let X[0..n-1] be the input sequence of length n and
 * L(0, n-1) be the length of the longest palindromic sub sequence of X[0..n-1].
 *
 * If last and first characters of X are same, then L(0, n-1) = L(1, n-2) + 2.
 * Else L(0, n-1) = MAX (L(1, n-1), L(0, n-2)).
 *
 * // Every single character is a palindrome of length 1
 * L(i, i) = 1 for all indexes i in given sequence
 *
 * // IF first and last characters are not same
 * If (X[i] != X[j])  L(i, j) =  max{L(i + 1, j),L(i, j - 1)}
 *
 * // If there are only 2 characters and both are same
 * Else if (j == i + 1) L(i, j) = 2
 *
 * // If there are more than two characters, and first and last
 * // characters are same
 * Else L(i, j) =  L(i + 1, j - 1) + 2
 * 2) Overlapping Subproblems
 * Following is simple recursive implementation of the LPS problem.
 */
public class LongestPalindromeSubSequence {

    public static int findLongestPalindromeSubSequence(final String inputStr) {
        if (inputStr == null || inputStr.length() == 0) {
            return 0;
        }
        if (inputStr.length() == 1) {
            return 1;
        }

        int len = inputStr.length();

        int[][] lcss = new int[len][len];

        //Case:1 Sub Sequence length = 1
        for (int i = 0; i < len; i++) {
            lcss[i][i] = 1;
        }

        //Sub sequence length
        int sl = 2;
        int j = 0;
        for (; sl <= len; sl++) {
            for (int i = 0; i < len - sl + 1; i++) {
                j = i + sl - 1;
                if (inputStr.charAt(i) == inputStr.charAt(j)) {
                    if (sl == 2) {
                        lcss[i][j] = 2;
                    } else {
                        lcss[i][j] = lcss[i + 1][j - 1] + 2;
                    }
                } else {
                    lcss[i][j] = Math.max(lcss[i + 1][j], lcss[i][j - 1]);
                }
            }
        }
        return lcss[0][len - 1];
    }
}
