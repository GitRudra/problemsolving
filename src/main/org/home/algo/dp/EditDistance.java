package org.home.algo.dp;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *  1.Insert
 *  2.Remove
 *  3.Replace
 * All of the above operations are of equal cost
 */
public class EditDistance {

    /**
     * The idea is process all characters one by one staring
     * either from left or right sides of both strings.
     * Let us traverse from right corner,
     * there are two possibilities for every pair of character
     * being traversed.
     *
     * m: Length of str1 (first string)
     * n: Length of str2 (second string)
     *
     * If last characters of two strings are same, nothing much to do.
     *   Ignore last characters and get count for remaining strings.
     *   So we recur for lengths m-1 and n-1.
     * Else (If last characters are not same),
     *   we consider all operations on ‘str1’,
     *   consider all three operations on last character of first string,
     *   recursively compute minimum cost for all three operations and
     *   take minimum of three values.
     *     Insert: Recur for m and n-1
     *     Remove: Recur for m-1 and n
     *     Replace: Recur for m-1 and n-1
     * @param str1 the source string
     * @param str2 the destination string
     * @param len1 length of source string
     * @param len2 length of destination string
     * @return min operation required
     */
    private static int editDistanceRecursiveUtil(String str1,
                                                 String str2,
                                                 int len1,
                                                 int len2) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (len1 == 0) {
            return len2;
        }

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (len2 == 0) {
            return len1;
        }

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
            return editDistanceRecursiveUtil(str1, str2, len1 - 1, len2 - 1);
        } else {
            // If last characters are not same, consider all three
            // operations on last character of first string, recursively
            // compute minimum cost for all three operations and take
            // minimum of three values.
            return 1+Math.min(Math.min(
                    editDistanceRecursiveUtil(str1, str2, len1 - 1, len2), //remove
                    editDistanceRecursiveUtil(str1, str2, len1, len2 - 1)), //insert
                    editDistanceRecursiveUtil(str1, str2, len1 - 1, len2 - 1)); //replace
        }
    }

    /**
     * Driver function
     * @param str1
     * @param str2
     * @return
     */
    public static int editDistanceRecursive(String str1, String str2){
        if((str1 == null || str1.length() ==0) &&
                (str2 == null || str2.length() ==0)){
            return 0;
        }
        return editDistanceRecursiveUtil(str1,str2, str1.length(),str2.length());
    }

    /**
     * DP solution for edit distance.
     * @param str1
     * @param str2
     * @return
     */
    public static int editDistanceIterative(String str1, String str2){
        if(str1.length() ==0 && str2.length()==0){
            return -1;
        }
        int len1 = str1.length();
        int len2 =  str2.length();
        int[][] editDp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0){
                    editDp[i][j] = j;
                }else if(j==0){
                    editDp[i][j] = i;
                }else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    editDp[i][j] = editDp[i-1][j-1];
                }else{
                    editDp[i][j] = 1+Math.min(
                            Math.min(editDp[i-1][j],editDp[i][j-1]),
                            editDp[i-1][j-1]
                    );
                }
            }
        }
        return editDp[len1][len2];
    }


}
