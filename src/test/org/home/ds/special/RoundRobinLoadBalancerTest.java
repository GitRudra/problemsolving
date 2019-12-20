package org.home.ds.special;

import org.junit.Test;

public class RoundRobinLoadBalancerTest {

    @Test
    public void checkLoadBalancerOne() {
        String[] servers = {"server-1", "server-2", "server-3"};
        int[] weights = {5, 3, 2};
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();
        loadBalancer.load(servers, weights);
        loadBalancer.initLoadBalancer();
        for (int i = 0; i < 23; i++) {
            loadBalancer.assignRequest("req" + i);
        }
        loadBalancer.printServerStatus();
    }
}