package org.home.algo.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ActivitySelectorTest {

    @Test
    public void selectActivitiesOne() {
        ActivitySelector selector = new ActivitySelector();
        int s[] =  {3, 0, 5, 8, 5, 1};
        int f[] =  {4, 6, 7, 9, 9, 2};
        for(int i=0;i<s.length;i++){
            selector.addActivity(s[i],f[i]);
        }
        List<Activity> actual = selector.selectActivities();
        int sexp[] =  {1, 3, 5, 8};
        int fexp[] =  {2, 4, 7, 9};
        List<Activity> expected = getExpectedActivitiesOne(sexp,fexp);
        System.out.println(actual);
        assertThat(actual,is(expected));
    }

    @Test
    public void selectActivitiesTwo() {
        ActivitySelector selector = new ActivitySelector();
        int s[] =  {10, 12, 20};
        int f[] =  {20, 25, 30};
        for(int i=0;i<s.length;i++){
            selector.addActivity(s[i],f[i]);
        }
        List<Activity> actual = selector.selectActivities();
        int sexp[] =  {10, 20};
        int fexp[] =  {20, 30};
        List<Activity> expected = getExpectedActivitiesOne(sexp,fexp);
        System.out.println(actual);
        assertThat(actual,is(expected));
    }

    private List<Activity> getExpectedActivitiesOne(int s[],int f[]){
        List<Activity> expected = new ArrayList<Activity>();

        for(int i=0;i<s.length;i++){
            expected.add(new Activity(s[i],f[i]));
        }
        return expected;
    }
}