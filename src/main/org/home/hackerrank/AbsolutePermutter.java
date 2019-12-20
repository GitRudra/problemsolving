package org.home.hackerrank;

public class AbsolutePermutter {
    public static int[] absolutePermutation(int n, int k) {
        if (n % 2 == 1 || n % (2 * k) == 0) {
            return new int[]{-1};
        }


        return null;
    }

    private static void generatePermutation(int[] input, int nStart, int nEnd, int k) {
        int[] result = new int[2 * k];

//        for(int i=0;i<)
    }
}
