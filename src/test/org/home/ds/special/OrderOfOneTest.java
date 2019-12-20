package org.home.ds.special;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderOfOneTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void orderOfOneOne() throws Exception {
        OrderOfOne<Integer> obj = new OrderOfOne<>();
        /*obj.insert(1);
        obj.insert(2);
        Integer expected = 2;
        Integer actual  = obj.search(2);
        obj.insert(3);
       // System.out.println(obj.dataStore);
        obj.delete(2);
       //System.out.println(obj.dataStore);
        obj.delete(3);
        System.out.println(obj.dataStore);
        obj.delete(1);
        System.out.println(obj.dataStore);
        System.out.println(obj.dataMap.size());*/
        for(int i=0;i<1000;i++){
            obj.insert(i);
        }
        for(int x = 0;x < 20;x++){
            //System.out.println(obj.getRandom());
            Integer xx = obj.search(x*x);
            System.out.println("Found element "+ xx);
            obj.delete(xx);
            System.out.println("Found random : "+ obj.getRandom());
        }
        assertEquals(obj.dataStore.size(),obj.dataMap.size());

    }


    @Test
    public void insert() {
    }

    @Test
    public void search() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getRandom() {
    }
}