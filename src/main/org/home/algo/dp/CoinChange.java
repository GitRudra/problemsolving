package org.home.algo.dp;

import java.util.Arrays;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of
 * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 * The order of coins doesn’t matter.
 *
 * For example, for N = 4 and S = {1,2,3},
 * there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 * For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange {

    /**
     *
     * @param coins array of available coins
     * @param numberOfCoins number of types of coin.
     * @param amount target amount which need to pay
     * @return number of possible way.
     */
    public int findCoinChangeRecursively(int[] coins,int numberOfCoins, int amount){
        if(coins==null || coins.length==0){
            return -1;
        }
        return findCoinChangesUtil(coins,numberOfCoins,amount);
    }

    private int findCoinChangesUtil(int[] coins,int numberOfCoins, int amount){
        // If amount is zero then it is a solution so return 1
        if(amount==0){
            return 1;
        }

        //if remaining amount is negative then that is not a solution.
        if(amount<0){
            return 0;
        }

        // If no currency type found but remaining amount is greater than zero, then there is
        // no solution.
        if(numberOfCoins<=0 && amount>=1){
            return 0;
        }
        return findCoinChangeRecursively(coins,numberOfCoins-1,amount)
                +findCoinChangeRecursively(coins,numberOfCoins,amount-coins[numberOfCoins-1]);
    }

    public int coinChangeDPSolution(int[] coins, int numberOfCoins, int targetSum){
        int[] table = new int[targetSum+1];

        Arrays.fill(table,0);

        table[0] = 1;

        for(int i= 0;i<numberOfCoins;i++ ){
            for(int j = coins[i];j<=targetSum;j++){
                table[j] += table[j-coins[i]];
            }
        }

        return table[targetSum];
    }
}
