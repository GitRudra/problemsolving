package org.home.ds.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The cost of a stock on each day is given in an array,
 * find the max profit that you can make by buying and selling in those days.
 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 * the maximum profit can earned by buying on day 0, selling on day 3.
 * Again buy on day 4 and sell on day 6.
 * If the given array of prices is sorted in decreasing order,
 * then profit cannot be earned at all.
 */
public class StockBuySellProblem {
    class Interval {
        int buy;
        int sell;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return buy == interval.buy &&
                    sell == interval.sell;
        }

        @Override
        public int hashCode() {
            return Objects.hash(buy, sell);
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "buy=" + buy +
                    ", sell=" + sell +
                    '}';
        }
    }

    /**If we are allowed to buy and sell only once, then we can use following algorithm.
     * "Maximum difference between two elements."
     * Here we are allowed to buy and sell multiple times.
     * Following is algorithm for this problem.
     * <li>
     *     <ol>Find the local minima and store it as starting index.
     *     If not exists, return.</ol>
     *     <ol>Find the local maxima. and store it as ending index.
     *     If we reach the end, set the end as ending index.</ol>
     *     <ol>Update the solution (Increment count of buy sell pairs)</ol>
     *     <ol>Repeat the above steps if end is not reached.</ol>
     * </li>
     *
     * @param prices array of prices
     * @return
     */
    public List<Interval> findMaximumProfit(int[] prices){

        if(prices == null || prices.length ==0){
            return Collections.EMPTY_LIST;
        }
        int i=0;
        int n  = prices.length;
        ArrayList<Interval> solutions = new ArrayList<>();
        while(i<n-1){
            while(i<n-1 && prices[i]>=prices[i+1]){
                i++;
            }
            if(i== n-1){
                return Collections.EMPTY_LIST;
            }
            Interval interval = new Interval();
            interval.buy = i;
            i++;
            while(i<=n-1 && prices[i]>=prices[i-1]){
                i++;
            }
            interval.sell = i-1;
            solutions.add(interval);
        }
        return solutions;
    }
}
