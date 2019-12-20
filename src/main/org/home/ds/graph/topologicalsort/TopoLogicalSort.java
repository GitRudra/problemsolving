package org.home.ds.graph.topologicalsort;


import java.util.ArrayList;
import java.util.LinkedList;

public class TopoLogicalSort<E> {

    private Graph<E> graph;
    private LinkedList<Node> queue;
    private ArrayList<Node> visitedNodes;

    public TopoLogicalSort(Graph gr) {
        graph = gr;
        this.queue = new LinkedList<>();
        visitedNodes = new ArrayList<>();
    }

    public void sort() {
        graph.sortVerticesByInDegreeCount();
        int visitedNodeCount = 0;
        graph.getVertices().forEach(e->{
            if(e.getInDegreeCount()==0){
                queue.addLast(e);
            }
        });
        //LevelOrderTreeNode n = graph.getVertices().remove(0);

        //queue.add(n);
        while (!queue.isEmpty()) {
            Node visited = queue.getFirst();
            visitedNodeCount++;
            LinkedList<Node> connectedVertices = graph.getAdjList().get(visited.getIndex());
            visitedNodes.add(visited);
            connectedVertices.forEach(e -> {
                e.decreaseInDegreeCount();
                if (e.getInDegreeCount() == 0) {
                    queue.addLast(e);
                }
            });
        }

        if(visitedNodeCount != graph.getTotalVertices()){
            System.out.println("Topological Sort not possible");
        }else{
            visitedNodes.forEach(e-> System.out.print(e.toString()+" "));
        }
    }

}