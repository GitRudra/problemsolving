package org.home.algo.backtrack;

import org.junit.Test;

import static org.junit.Assert.*;

public class NQueenProblemSolverTest {

    @Test
    public void findNQueenSol() {
        int N=4;
        NQueenProblemSolver solver = new NQueenProblemSolver(N);
        solver.findNQueenSol();
    }

    @Test
    public void findNQueenSolTwo() {
        int N=8;
        NQueenProblemSolver solver = new NQueenProblemSolver(N);
        solver.findNQueenSol();
    }
}