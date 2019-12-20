package org.home.hackerrank;

import java.util.List;

public class ChocolateDistributor {
    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        Integer[] sArray = new Integer[s.size()];
        s.toArray(sArray);
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += sArray[i].intValue();
        }
        if (sum == d) {
            count++;
        }
        for (int j = m; j < sArray.length; j++) {
            sum = sum - sArray[j - m] + sArray[j].intValue();
            if (sum == d) {
                count++;
            }
        }

        return count;

    }
}
