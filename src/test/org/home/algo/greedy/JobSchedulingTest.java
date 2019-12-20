package org.home.algo.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobSchedulingTest {

    @Test
    public void scheduleJob() {
        String[] ids = {"a","b","c","d"};
        int[] deadlines = {4,1,1,1};
        int[] profits = {20,10,40,30};
        JobScheduling schedular = new JobScheduling();
        schedular.scheduleJob(ids,deadlines,profits);

    }
}