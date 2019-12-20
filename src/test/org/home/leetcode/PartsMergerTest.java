package org.home.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PartsMergerTest {

    @Test
    public void minimumTime() {
        int[] i = {20,4,8,2};
        List<Integer> data = new ArrayList<>();
        for(int x: i){
            data.add(x);
        }
        PartsMerger obj = new PartsMerger();
        int x = obj.minimumTime(4,data);
        System.out.println(x);
    }
}