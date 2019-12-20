package org.home.algo.greedy;

import java.util.List;

public class CircularGasStation {
    /**
     * Let xi be the amount of gas available at station i minus the amount of gas required to go to next station.
     *
     * A requirement is Σ xi ≥ 0 (enough gas to complete a full circle).
     *
     * Consider Si = x1 + x2 + ... + xi
     *
     * Note that Sn ≥ 0.
     *
     * Now pick the smallest (or even largest will do, making it easier to write code for) k such that Sk is the least and start at the station next to it.
     *
     * Now for k < j ≤ n, we have the gas in tank = Sj - Sk ≥ 0.
     *
     * for 1 ≤ j ≤ k, we have gas in tank = xk+1 + .. + xn + x1 + x2 + .. + xj = Sn - Sk + Sj ≥ 0.
     *
     * Thus starting at k+1 will ensure there is enough gas accumulated at each station to get to the next station.
     * @param pumpCapacity
     * @param travelCost
     * @return
     */
    public static int canCompleteCircuit(final List<Integer> pumpCapacity, final List<Integer> travelCost) {
        int sum = 0;
        int position = 0;
        int min_sum = 0;

        for(int i=0;i<pumpCapacity.size();i++){
            sum += pumpCapacity.get(i) - travelCost.get(i);
            if(sum < min_sum){
                min_sum = sum;
                position = (i+1)%pumpCapacity.size();
            }
        }

        if(sum >=0){
            return position;
        }else {
            return -1;
        }

    }
}
