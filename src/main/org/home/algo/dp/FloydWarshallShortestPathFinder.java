package org.home.algo.dp;

import java.util.HashSet;

/**
 * In computer science, the Floyd–Warshall algorithm is an algorithm for
 * finding shortest paths in a weighted graph with positive or negative
 * edge weights (but with no negative cycles).[1][2] A single execution of
 * the algorithm will find the lengths (summed weights) of shortest paths between
 * all pairs of vertices. Although it does not return details of the paths themselves,
 * it is possible to reconstruct the paths with simple modifications to the algorithm
 */
public class FloydWarshallShortestPathFinder {

    public void findShortestPath(int[][] inputGraph,int vertices){
        int[][] output = initializeOutputMatrix(inputGraph,vertices);
        for(int k=0;k<vertices;k++){
            calculateShortestPath(output,vertices,k);
        }
        printAdjacencyMatrix(output,vertices);
    }

    private void printAdjacencyMatrix(int[][] output,int n){
        for(int i=0;i<n;i++){
            System.out.println();
            for(int j=0;j<n;j++){
                System.out.print(output[i][j]+" ");
            }
        }
    }

    /**
     * Initialize the solution matrix same as input graph matrix.
     * Or we can say the initial values of shortest distances
     * are based on shortest paths considering no intermediate
     * vertex.
     * @param inputGraph
     * @param vertices
     * @return
     */
    private int[][] initializeOutputMatrix(int[][] inputGraph,int vertices){
        int[][] output = new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                output[i][j] = inputGraph[i][j];
            }
        }
        HashSet<Integer> set = new HashSet<>();
//        set.ad

        return output;
    }

    private void calculateShortestPath(int[][]  vGraph,int vertices,int k){
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                vGraph[i][j] = Math.min(vGraph[i][j],vGraph[i][k]+vGraph[k][j]);
            }
        }
    }
}
