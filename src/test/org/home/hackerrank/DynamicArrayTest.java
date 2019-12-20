package org.home.hackerrank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DynamicArrayTest {

    @Test
    public void dynamicArrayOne() {
        List<List<Integer>> queryList = new ArrayList<>();
        int n  = 2;
        queryList.add(Arrays.asList(1,0,5));
        queryList.add(Arrays.asList(1,1,7));
        queryList.add(Arrays.asList(1,0,3));
        queryList.add(Arrays.asList(2,1,0));
        queryList.add(Arrays.asList(2,1,1));
        DynamicArray.dynamicArray(n,queryList);

    }
}