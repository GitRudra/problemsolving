package org.home.cmp.ms.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeaderBoardProblem {

    public int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] ranks = generateRank(scores);
        int res[] = new int[alice.length];
        int currentIndex = scores.length-1;
        for(int i=0;i<alice.length;i++){
            currentIndex = searchPosition(scores,ranks,res,i,alice[i],currentIndex);
        }

        return res;
    }

    public int searchPosition(int[] scores,int[] ranks, int[] res, int resIndex,int key, int searchStartIndex){
        Boolean foundPos = false;
        int index=0;
        for(int i=searchStartIndex;i>=0;i--){
            if(scores[i]>key){
                res[resIndex] = ranks[i]+1;
                foundPos = true;
                index = i;
                break;
            }else if(scores[i]==key){
                res[resIndex] = ranks[i];
                foundPos = true;
                index = i-1;
                break;
            }
        }
        if(!foundPos){
            index = 0;
            res[resIndex] =1;
        }
        return  index;
    }

    public int[] generateRank(int[] scores){
        int[] ranks = new int[scores.length];
        int rank = 1;
        int currentScore = scores[0];
        for(int i=0;i<scores.length;i++){
            if(scores[i]==currentScore){
                ranks[i]=rank;
            }else{
                rank+=1;
                currentScore = scores[i];
                ranks[i]=rank;
            }
        }
        return ranks;
    }

}
