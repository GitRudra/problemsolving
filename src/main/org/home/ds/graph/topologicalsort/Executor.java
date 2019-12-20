package org.home.ds.graph.topologicalsort;

public class Executor {
    public static void main(String[] args) {

        Graph<Integer> g = new Graph<>(6);
        //gr.addEdge(1,2);
        g.addEdge(5,2);
        g.addEdge(5,0);
        g.addEdge(4,0);
        g.addEdge(4,1);
        g.addEdge(2,3);
        g.addEdge(3,1);
        TopoLogicalSort<Integer> sortObj = new TopoLogicalSort<>(g);
        sortObj.sort();
    }
}
