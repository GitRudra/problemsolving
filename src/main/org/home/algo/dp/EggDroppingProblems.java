package org.home.algo.dp;

/**
 * The following is a description of the instance of this famous puzzle
 * involving n=2 eggs and a building with k=36 floors.
 * Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from,
 * and which will cause the eggs to break on landing. We make a few assumptions:
 *
 * …..An egg that survives a fall can be used again.
 * …..A broken egg must be discarded.
 * …..The effect of a fall is the same for all eggs.
 * …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
 * …..If an egg survives a fall then it would survive a shorter fall.
 * …..It is not ruled out that the first-floor windows break eggs,
 *    nor is it ruled out that the 36th-floor do not cause an egg to break.
 *
 * If only one egg is available and we wish to be sure of obtaining the right result,
 * the experiment can be carried out in only one way.
 * Drop the egg from the first-floor window; if it survives, drop it from the second floor window.
 * Continue upward until it breaks. In the worst case, this method may require 36 droppings.
 * Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?
 * The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped
 * so that total number of trials are minimized.
 */

public class EggDroppingProblems {

    /**
     * In this post, we will discuss solution to a general problem with n eggs and k floors.
     * The solution is to try dropping an egg from every floor (from 1 to k) and
     * recursively calculate the minimum number of droppings needed in worst case.
     * The floor which gives the minimum value in worst case is going to be part of the solution.
     * In the following solutions, we return the minimum number of trials in worst case;
     * these solutions can be easily modified to print floor numbers of every trials also.
     *
     * 1) Optimal Substructure:
     * When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.
     *
     * 1) If the egg breaks after dropping from xth floor, then we only need to check for floors
     *    lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
     * 2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for
     *    floors higher than x; so the problem reduces to k-x floors and n eggs.
     *
     * Since we need to minimize the number of trials in worst case, we take the maximum of two cases.
     * We consider the max of above two cases for every floor and choose the
     * floor which yields minimum number of trials.
     *
     *   k ==> Number of floors
     *   n ==> Number of Eggs
     *   eggDrop(n, k) ==> Minimum number of trials needed to find the critical
     *                     floor in worst case.
     *   eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)):
     *                  x in {1, 2, ..., k}}
     * @param n
     * @param k
     * @return
     */

    private static int dropEggRecUtil(int n, int k){
        //From zeroth floor we need zero times &
        //For 1st floor we need only one drop
        if(k==0 || k==1){
            return k;
        }
        //If we have only one egg and k floor
        if(n==1){
            return k;
        }
		
		int minValue = Integer.MAX_VALUE;
		int res = 0;
		for(int x=1;x<=k;x++){
		  res = Math.max(dropEggRecUtil(n-1,x-1),dropEggRecUtil(n,k-x));
		  if(res<minValue){
		      minValue = res;
          }
		}
		return minValue+1;
    }

    public static int dropEggRec(int n, int k){
        return dropEggRecUtil(n,k);
    }

    private static int eggDroppingIterativeUtil(int numberOfEggs, int numberOfFloors){
        int[][] dp =  new int[numberOfEggs+1][numberOfFloors+1];

        //From first floor the number of steps required is one
        //For zero floor the number of steps required is zro

        for(int i=0;i<=numberOfEggs;i++){
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for(int i=0;i<=numberOfFloors;i++){
            dp[1][i] = i;
        }

        int res = 0;
        for(int i=2;i<=numberOfEggs;i++){
            for(int j=2;j<=numberOfFloors;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int x=1;x<=j;x++){
                    res = 1 + Math.max(dp[i-1][x-1], dp[i][j-x]);
                    if (res < dp[i][j])
                        dp[i][j] = res;
                }
            }
        }

        return dp[numberOfEggs][numberOfFloors];
    }

    public static int eggDroppingIterative(int numberOfEggs, int noOfFloors){
        return eggDroppingIterativeUtil(numberOfEggs,noOfFloors);
    }
}
