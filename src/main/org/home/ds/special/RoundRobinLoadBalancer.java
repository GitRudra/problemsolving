package org.home.ds.special;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoundRobinLoadBalancer {
    List<Server> serverList;
    Queue<Server> lbc;

    public RoundRobinLoadBalancer() {
        serverList = new ArrayList<>();
        this.lbc = new LinkedList<>();
    }

    public void addServer(Server s) {
        serverList.add(s);
    }

    public void initLoadBalancer() {
        serverList.forEach(e -> lbc.add(e));
    }

    public void assignRequest(String req) {
        if (lbc.isEmpty()) {
            initLoadBalancer();
        }
        Server s = lbc.remove();
        s.assignRequest(req);
        if (!s.isFullyLoaded()) {
            lbc.add(s);
        }
        if (s.isFullyLoaded()) {
            s.resetWeight();
        }
    }

    public void printServerStatus() {
        serverList.forEach(e -> {
            System.out.println("Server Ip = " + e.getIp());
            System.out.println("Currently Served request Count  = " + e.serverdRequestCount());
            System.out.println("[Total Capacity = " + e.getWeight() + " available capacity = " + e.getCurrentWeight() + "]");
        });
    }

    public void load(String[] serverName, int[] weights) {
        for (int i = 0; i < serverName.length; i++) {
            addServer(new Server(serverName[i], weights[i]));
        }
    }

    /*public static void main(String[] args) {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();
        loadBalancer.addServer(new Server("server-1",5));
    }*/

    class Server {
        private String ip;
        private int weight;
        private int currentWeight;
        private List<String> requestList;

        public Server(String ip, int weight) {
            this.ip = ip;
            this.weight = weight;
            currentWeight = weight;
            requestList = new ArrayList<>();
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getCurrentWeight() {
            return currentWeight;
        }

        public void setCurrentWeight(int currentWeight) {
            this.currentWeight = currentWeight;
        }

        public void resetWeight() {
            this.currentWeight = this.weight;
        }

        public boolean isFullyLoaded() {
            return (currentWeight == 0);
        }

        public void decreaseWeight() {
            this.currentWeight--;
        }

        public boolean isEnoughCapable(int loadCount) {
            return currentWeight - loadCount >= 0;
        }

        public void assignRequest(String req) {
            requestList.add(req);
            decreaseWeight();
        }

        public int serverdRequestCount() {
            return requestList.size();
        }
    }


}
