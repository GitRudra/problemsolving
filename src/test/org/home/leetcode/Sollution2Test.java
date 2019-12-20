package org.home.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Sollution2Test {

    @Test
    public void removeObstacle() {
        List<List<Integer>> lot = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(0);
        row.add(0);
        lot.add(row);
        List<Integer> r2 = new ArrayList<>();
        r2.add(1);
        r2.add(0);
        r2.add(0);
        lot.add(r2);
        List<Integer> r3 = new ArrayList<>();
        r3.add(1);
        r3.add(9);
        r3.add(1);
        lot.add(r3);
        Sollution2 obj = new Sollution2();
        int x = obj.removeObstacle(3,3,lot);
        System.out.println(x);

    }

    @Test
    public void removeObstacleTwo() {
        Sollution2 obj = new Sollution2();
        int x = obj.removeObstacle(0,0,null);
        System.out.println(x);

    }
}