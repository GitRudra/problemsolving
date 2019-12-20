package org.home.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Rotate2DArrayInPlaceTest {

    @Test
    public void rotateArrayOne() {
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };
        Rotate2DArrayInPlace.rotateArray(mat);
    }

    @Test
    public void rotateArrayTwo() {
        int mat[][] =
                {
                        {1, 2, 3, 4, 5, 6},
                        {7, 8,9,10,11,12},
                        {13,14,15,16,17,18},
                        {19,20,21,22,23,24},
                        {25,26,27,28,29,30},
                        {31,32,33,34,35,36}
                };
        Rotate2DArrayInPlace.rotateArray(mat);
    }
}