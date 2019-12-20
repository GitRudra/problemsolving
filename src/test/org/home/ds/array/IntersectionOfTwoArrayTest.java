package org.home.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionOfTwoArrayTest {

    @Test
    public void intersection() {
        int[] ar1 = {1,2,3,4,5,6};
        int[] ar2 = {2,3,5};
        IntersectionOfTwoArray.intersection(ar1,ar2);

    }

    @Test
    public void intersectionTwo() {
        int[] ar1 = {1,2,3,4,5,6};
        int[] ar2 = {7,8,9};
        IntersectionOfTwoArray.intersection(ar1,ar2);

    }
}