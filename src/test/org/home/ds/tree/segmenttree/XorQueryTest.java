package org.home.ds.tree.segmenttree;

import org.junit.Test;

import static org.junit.Assert.*;

public class XorQueryTest {

    @Test
    public void getXorQueryOne() {
        int arr[] = {1, 3, 5, 7, 9, 11};
        XorQuery query = new XorQuery(arr);
        int expected = 7;
        int actual = query.getXorQuery(0,2);
        assertEquals(expected,actual);
    }

    
}