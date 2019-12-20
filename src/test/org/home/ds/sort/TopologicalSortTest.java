package org.home.ds.sort;

import org.junit.Test;

public class TopologicalSortTest {

    @Test
    public void topoLogicalSort() {
        Graph input = createGraph();
        TopologicalSort sort = new TopologicalSort(input);
        sort.topologicalSort();
    }

    @Test
    public void topoLogicalSortTwo() {
        Graph input = createGraph();
        TopologicalSort sort = new TopologicalSort(input);
        sort.allTopologicalSort();
    }

    private Graph createGraph(){
        Graph g = new Graph(6);
        g.addEdge(5,2);
        g.addEdge(5,0);
        g.addEdge(4,0);
        g.addEdge(4,1);
        g.addEdge(2,3);
        g.addEdge(3,1);

        return g;
    }
}