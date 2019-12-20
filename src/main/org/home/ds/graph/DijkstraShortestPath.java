package org.home.ds.graph;

import java.util.Arrays;

public class DijkstraShortestPath {


    public int[] findShortestPath(int[][] graph, int source, int vertexCount) {
        // The output array. dist[i] will hold
        // the shortest distance from src to i
        int[] distances = new int[vertexCount];
        boolean[] visitedVertices = new boolean[vertexCount];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(visitedVertices, false);
        // Distance of source vertex from itself is always 0
        distances[source] = 0;
        for (int i = 0; i < vertexCount - 1; i++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration
            int u = findVertexWithMinimumDistance(distances, visitedVertices);
            // Mark the picked vertex as processed
            visitedVertices[u] = true;
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < vertexCount; v++) {
                // Update distances[v] only if is not in visitedVertices, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of distances[v]
                if (!visitedVertices[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                }
            }
        }
        return distances;
    }

    public void printDistances(int[] distances) {
        System.out.println("Distances of vertices :");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(" Vertex: " + i + " Distance: " + distances[i]);
        }
    }

    private int findVertexWithMinimumDistance(int[] distance, boolean[] visited) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] <= minValue && !visited[i]) {
                minValue = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
