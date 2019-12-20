package org.home.ds.graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GraphSearch {

    public void bFS(GraphInt g, int startIndex){
        boolean[] visited = new boolean[g.getTotalVertices()];
        Arrays.fill(visited,false);
        Queue<NodeInt> bfsTraversal = new PriorityQueue<>();
        bfsTraversal.add(g.getNode(startIndex));
        visited[startIndex] = true;
        while(!bfsTraversal.isEmpty()){
            NodeInt n = bfsTraversal.poll();
            System.out.print(n);
            g.getAdjList()[n.getValue()].forEach(e -> {
                if (!visited[e.getValue()]) {
                    visited[e.getValue()] = true;
                    bfsTraversal.add(e);
                }
            });
        }
    }

    public void dFS(GraphInt g, int startIndex) {
        boolean[] visited = new boolean[g.getTotalVertices()];
        Arrays.fill(visited, false);
        Stack<NodeInt> bfsTraversal = new Stack<>();
        bfsTraversal.add(g.getNode(startIndex));
        visited[startIndex] = true;
        while (!bfsTraversal.isEmpty()) {
            NodeInt n = bfsTraversal.pop();
            System.out.print(n);
            g.getAdjList()[n.getValue()].forEach(e -> {
                if (!visited[e.getValue()]) {
                    visited[e.getValue()] = true;
                    bfsTraversal.push(e);
                }
            });
        }
    }
}
