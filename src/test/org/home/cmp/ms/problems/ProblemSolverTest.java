package org.home.cmp.ms.problems;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ProblemSolverTest {

    @Test
    public void sort012One() {
        int[] input = {0,1,2,2,1,0};
        int[] expected = {0,0,1,1,2,2};
        ProblemSolver solver = new ProblemSolver();
        solver.sort012(input);
        assertArrayEquals(expected,input);
        //Arrays.stream(input).forEach(e-> System.out.print(e+" "));
    }

    @Test
    public void sort012Two() {
        int[] input = {0,1,2,2,1,0,2};
        int[] expected = {0,0,1,1,2,2,2};
        ProblemSolver solver = new ProblemSolver();
        solver.sort012(input);
        //assertArrayEquals(expected,input);
        Arrays.stream(input).forEach(e-> System.out.print(e+" "));
    }

    @Test
    public void sort012Three() {
        int[] input = {2,1,2,2,1,0,2};
        int[] expected = {0,1,1,2,2,2,2};
        ProblemSolver solver = new ProblemSolver();
        solver.sort012(input);
        //assertArrayEquals(expected,input);
        Arrays.stream(input).forEach(e-> System.out.print(e+" "));
    }
}