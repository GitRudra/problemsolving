package org.home.ds.graph.topologicalsort;

import java.util.*;

public class Graph<E> {
    private int totalVertices;
    private  ArrayList<LinkedList<Node>> adjList;

    private Map<E,Node<E>> nodeMap;
    private int nodeIndex;
    private ArrayList<Node<E>> vertices;

    public Graph(int totalVertices) {
        this.totalVertices = totalVertices;
        adjList = new ArrayList<>();
        for(int i=0;i<totalVertices;i++){
            adjList.add(new LinkedList<>());
        }
        nodeMap = new HashMap<>();
        nodeIndex = 0;
        vertices = new ArrayList<>();
    }

    public void addEdge(E u, E v){
        Node uNode = createNodeIfNotExist(u);
        Node vNode = createNodeIfNotExist(v);
        adjList.get(uNode.getIndex()).addLast(vNode);
        uNode.increaseOutDegreeCount();
        vNode.increaseIndegreeCount();
       /* uNode.getOutDegree().add(vNode);
        vNode.getInDegree().add(uNode);*/
    }

    private Node createNodeIfNotExist(E u){
        Node uNode = null;
        if(nodeMap.containsKey(u)){
            uNode = nodeMap.get(u);
        }else{
            uNode = new Node(u,nodeIndex);
            nodeIndex++;
            nodeMap.put(u,uNode);
            vertices.add(uNode);
        }
        return uNode;
    }

    public void sortVerticesByInDegreeCount(){
        vertices.sort((Node n1,Node n2)->Integer.compare(n1.getInDegreeCount(),n2.getInDegreeCount()));
    }

    public ArrayList<Node<E>> getVertices() {
        return vertices;
    }

    public int getTotalVertices() {
        return totalVertices;
    }

    public ArrayList<LinkedList<Node>> getAdjList() {
        return adjList;
    }

    public Map<E, Node<E>> getNodeMap() {
        return nodeMap;
    }

    public int getNodeIndex() {
        return nodeIndex;
    }
}
