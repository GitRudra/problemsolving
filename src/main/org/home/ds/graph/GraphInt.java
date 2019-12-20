package org.home.ds.graph;

import java.util.*;

public class GraphInt {
    private int totalVertices;
    private  LinkedList<NodeInt>[] adjList;
    private Map<Integer, NodeInt> nodes;

    public GraphInt(int totalVertices) {
        this.totalVertices = totalVertices;
        adjList = new LinkedList[totalVertices];
        for(int i=0;i<totalVertices;i++){
            adjList[i] = new LinkedList<>();
        }
        nodes = new HashMap<>();
    }

    public void addEdge(int u, int v){
        NodeInt uNode = nodes.containsKey(u)?nodes.get(u):new NodeInt(u);
        NodeInt vNode = nodes.containsKey(v)?nodes.get(v):new NodeInt(v);
        nodes.put(u,uNode);
        nodes.put(v,vNode);

        adjList[u].addLast(vNode);
    }


    public void sortVerticesByInDegreeCount(){
       // vertices.sort((Node n1,Node n2)->Integer.compare(n1.getInDegreeCount(),n2.getInDegreeCount()));
    }

    public List<NodeInt> getVertices() {
        return new ArrayList<NodeInt>(nodes.values());
    }

    public NodeInt getNode(int x){
        return nodes.get(x);
    }

    public int getTotalVertices() {
        return totalVertices;
    }

    public LinkedList<NodeInt>[] getAdjList() {
        return adjList;
    }

    public Map<Integer, NodeInt> getNodeMap() {
        return nodes;
    }

    public void displayGraph(){
        for(LinkedList l : adjList){
            System.out.println("");
            l.forEach(e-> System.out.print(e));
        }
    }
}
