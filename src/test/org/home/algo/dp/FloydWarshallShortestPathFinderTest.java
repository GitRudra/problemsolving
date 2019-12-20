package org.home.algo.dp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloydWarshallShortestPathFinderTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findShortestPath() {
        int INF = 99999;
        int graph[][] = { {0,   5,  INF, 10},
                          {INF, 0,   3, INF},
                          {INF, INF, 0,   1},
                          {INF, INF, INF, 0}
        };

        FloydWarshallShortestPathFinder finder = new FloydWarshallShortestPathFinder();
        finder.findShortestPath(graph,4);
    }
}