package org.home.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayProblemsTest {

    @Test
    public void celinSearchOne() throws Exception {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int x = 8;
        int expected = 10;
        ArrayProblems prob = new ArrayProblems();
        int actual = prob.celinSearch(arr,x);
        assertEquals(expected,actual);
        //System.out.println(ret);
    }

    @Test
    public void celinSearch2() throws Exception {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int x = 17;
        int expected = 19;
        ArrayProblems prob = new ArrayProblems();
        int actual = prob.celinSearch(arr,x);
        assertEquals(expected,actual);
        //System.out.println(ret);
    }
    @Test(expected = Exception.class)
    public void celinSearch3() throws Exception {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int x = 21;
        int expected = 10;
        ArrayProblems prob = new ArrayProblems();
        int actual = prob.celinSearch(arr,x);
        //assertEquals(expected,actual);
        //System.out.println(ret);
    }

    @Test
    public void rotateArrayOne() throws Exception {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int k=2;
        int[] expected ={3, 4, 5, 6, 7, 1, 2};
        ArrayProblems.rotateArrayLeft(a,k);
        assertArrayEquals(expected,a);
    }

    //findMaximumSizeSubArrayOfOne
    @Test
    public void testFindMaximumSizeSubArrayOfOne1(){
        int R=5;
        int C=5;
        int M[][] = {{0, 1, 1, 0, 1},
                       {1, 1, 0, 1, 0},
                       {0, 1, 1, 1, 0},
                       {1, 1, 1, 1, 0},
                       {1, 1, 1, 1, 1},
                       {0, 0, 0, 0, 0}};
        ArrayProblems.findMaximumSizeSubArrayOfOne(M,R,C);
    }

    @Test
    public void testFindPairs(){
        int arr[] = {3, 4, 7, 1, 2, 9, 8};
        ArrayProblems.findPairs(arr);
    }

    @Test
    public void testFindPairsTwo(){
        int arr[] = { 2, 3, 5, 7, 12 };
        int expected = 12;

        int actual = ArrayProblems.findPairsTwo(arr);
        assertEquals(expected,actual);
    }
}