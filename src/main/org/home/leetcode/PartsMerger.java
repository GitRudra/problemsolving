package org.home.leetcode;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class PartsMerger {

    /**
     * The problem is we need to merge parts and need to build one single product.
     * We can merge two parts at a time and merge cost is the sum of parts cost.
     * After merging the parts
     * @param numOfParts
     * @param parts
     * @return
     */
    int minimumTime(int numOfParts, List<Integer> parts) {
        if(numOfParts == 0){
            return 0;
        }
        if(numOfParts ==1){
            return parts.get(0);
        }
        if(numOfParts ==2){
            return parts.get(0)+parts.get(1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue(parts);
        int x,y;
        int res = 0;
        while(queue.size()>1){
            x = queue.poll();
            y = queue.poll();
            queue.add(x+y);
            res+=(x+y);
        }
        return res;
    }
}
