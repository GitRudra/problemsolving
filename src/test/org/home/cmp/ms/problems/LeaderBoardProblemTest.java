package org.home.cmp.ms.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeaderBoardProblemTest {

    @Test
    void climbingLeaderboardOne() {
        int scores[] = {100, 100, 50, 40, 40, 20, 10};
        int[] alices = {5,25,50,120};
        LeaderBoardProblem lbp = new LeaderBoardProblem();
        int[] result = lbp.climbingLeaderboard(scores,alices);
        int[] expected = {6,4,2,1};
        assertArrayEquals(expected,result);
    }

    @Test
    void climbingLeaderboardTwo() {
        int scores[] = {100,90,90,80,75,60};
        int[] alices = {50,65,77,90,102};
        LeaderBoardProblem lbp = new LeaderBoardProblem();
        int[] result = lbp.climbingLeaderboard(scores,alices);
        int[] expected = {6,5,4,2,1};
        assertArrayEquals(result,expected);
    }

    @Test
    void createLeaderBoard() {
        Integer scores[] = {100, 100, 50, 40, 40, 20, 10};
        LeaderBoardProblem lbp = new LeaderBoardProblem();
       // List<LeaderBoardProblem.LeaderBoardEntry> leaders = lbp.createLeaderBoard(scores);
       // System.out.println(leaders);
    }
}