package org.home.ds.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphIntTest {

    @Test
    public void testGraphRepresentationOne() {
        GraphInt graph = new GraphInt(5);
        graph.addEdge( 0, 1);
        graph.addEdge( 0, 4);
        graph.addEdge( 1, 2);
        graph.addEdge( 1, 3);
        graph.addEdge( 1, 4);
        graph.addEdge( 2, 3);
        graph.addEdge( 3, 4);
        graph.displayGraph();
    }

    @Test
    public void sortVerticesByInDegreeCount() {
    }

    @Test
    public void getVertices() {
    }

    @Test
    public void getTotalVertices() {
    }

    @Test
    public void getAdjList() {
    }

    @Test
    public void getNodeMap() {
    }
}