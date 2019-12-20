package org.home.ds.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceBetweenTwoKeyCalculatorTest {

    private TreeNodeInt root;
    private DistanceBetweenTwoKeyCalculator distanceCalculator;

    @Before
    public void setUp() throws Exception {
        root = createTreeOne();
        distanceCalculator = new DistanceBetweenTwoKeyCalculator();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Dist(4, 5) = 2
     * Dist(4, 6) = 4
     * Dist(3, 4) = 3
     * Dist(2, 4) = 1
     * Dist(8, 5) = 5
     */
    @Test
    public void findDistanceOne() {
        int expected = 2;
        int k1 = 4;
        int k2 = 5;
        int actual = distanceCalculator.findDistance(root,k1,k2);
        assertEquals(expected,actual);
    }

    @Test
    public void findDistanceTwo() {
        int expected = 4;
        int k1 = 4;
        int k2 = 6;
        int actual = distanceCalculator.findDistance(root,k1,k2);
        assertEquals(expected,actual);
    }

    @Test
    public void findDistanceThree() {
        int expected = 3;
        int k1 = 3;
        int k2 = 4;
        int actual = distanceCalculator.findDistance(root,k1,k2);
        assertEquals(expected,actual);
    }

    @Test
    public void findDistanceFour() {
        int expected = 5;
        int k1 = 8;
        int k2 = 5;
        int actual = distanceCalculator.findDistance(root,k1,k2);
        assertEquals(expected,actual);
    }

    @Test
    public void findDistanceFive() {
        int expected = 1;
        int k1 = 2;
        int k2 = 4;
        int actual = distanceCalculator.findDistance(root,k1,k2);
        assertEquals(expected,actual);
    }

    private TreeNodeInt createTreeOne(){
        TreeNodeInt  root = new TreeNodeInt(1);
        root.left = new TreeNodeInt(2);
        root.right = new TreeNodeInt(3);
        root.left.left = new TreeNodeInt(4);
        root.left.right = new TreeNodeInt(5);
        root.right.left = new TreeNodeInt(6);
        root.right.right = new TreeNodeInt(7);
        root.right.left.right = new TreeNodeInt(8);
        return root;
    }


}