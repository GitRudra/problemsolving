package org.home.ds.sort;

import java.util.LinkedList;

public class Graph {
    private int totalVertices;
    private LinkedList<Integer>[] adjList;

    public Graph(int totalVertices) {
        this.totalVertices = totalVertices;
        adjList = new LinkedList[totalVertices];
        for(int i=0;i<totalVertices;i++){
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adjList[v].add(w);
    }

    public int getTotalVertices() {
        return totalVertices;
    }

    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }
}
