package org.home.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellManFordAlgorithm {

    class Edge{
        private int source;
        private int dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(int dest) {
            this.dest = dest;
        }
    }

    public int[] bellManFordAlgorithm(int[][] graph, int vertexCount, int source){
        int[] distances = new int[vertexCount];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        ArrayList<Edge> edges = generateEdges(graph,vertexCount);
        for(int i=0;i<vertexCount-1;i++){
            edges.forEach(e->{
                if(distances[e.source]+graph[e.source][e.dest] < distances[e.dest]){
                    distances[e.dest] = graph[e.source][e.dest] + distances[e.source];
                }
            });
        }

        return distances;

    }

    public void printDistances(int[] distances){
        Arrays.stream(distances).forEach(System.out::println);
    }

    private ArrayList<Edge> generateEdges(int[][] graph, int vertexCount){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0;i<vertexCount;i++){
            for(int j=0;j<vertexCount;j++){
                if(graph[i][j] != 0){
                    edges.add(new Edge(i,j));
                }
            }
        }
        return edges;
    }
}
