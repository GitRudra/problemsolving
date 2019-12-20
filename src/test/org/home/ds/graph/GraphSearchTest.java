package org.home.ds.graph;

import org.junit.Test;

public class GraphSearchTest {

    @Test
    public void bFSOne() {
        GraphInt g = createGraphOne();
        GraphSearch search = new GraphSearch();
        System.out.println("\n BFS");
        search.bFS(g,0);
    }

    @Test
    public void bFSTwo() {
        GraphInt g = createGraphOne();
        GraphSearch search = new GraphSearch();
        System.out.println("\n BFS");
        search.bFS(g, 1);
    }

    @Test
    public void testDFSOne() {
        GraphInt g = createGraphOne();
        GraphSearch search = new GraphSearch();
        System.out.println("\n DFS");
        search.dFS(g, 1);
    }

    @Test
    public void testDFSTwo() {
        GraphInt g = createGraphOne();
        GraphSearch search = new GraphSearch();
        System.out.println("\n DFS");
        search.dFS(g, 4);
    }

    private GraphInt createGraphOne(){
        GraphInt graph = new GraphInt(6);
        graph.addEdge( 0, 1);
        graph.addEdge( 0, 4);
        graph.addEdge( 1, 2);
        graph.addEdge( 1, 3);
        graph.addEdge( 1, 4);
        graph.addEdge( 2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge( 3, 4);
        return graph;
    }
}