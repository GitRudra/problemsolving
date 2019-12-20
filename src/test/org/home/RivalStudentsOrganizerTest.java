package org.home;

import org.junit.Test;

import static org.junit.Assert.*;

public class RivalStudentsOrganizerTest {

    @Test
    public void getMaximumDistanceOne() {
        int totalStudent = 100;
        int maxSwap = 33;
        int student1 = 1;
        int student2 = 100;
        int actual  = 99;
        int expected = RivalStudentsOrganizer.getMaximumDistance(totalStudent,maxSwap,student1,student2);

        assertEquals(expected,actual);
    }

    @Test
    public void getMaximumDistanceTwo() {
        int totalStudent = 6;
        int maxSwap = 0;
        int student1 = 2;
        int student2 = 3;
        int actual  = 1;
        int expected = RivalStudentsOrganizer.getMaximumDistance(totalStudent,maxSwap,student1,student2);

        assertEquals(expected,actual);
    }

    @Test
    public void getMaximumDistanceThree() {
        int totalStudent = 5;
        int maxSwap = 1;
        int student1 = 3;
        int student2 = 2;
        int actual  = 2;
        int expected = RivalStudentsOrganizer.getMaximumDistance(totalStudent,maxSwap,student1,student2);

        assertEquals(expected,actual);
    }
}