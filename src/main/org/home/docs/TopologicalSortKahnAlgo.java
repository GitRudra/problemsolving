package org.home.docs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortKahnAlgo {

    public void topologicalSort(ArrayList<ArrayList<Integer>> graph){

        //Calculate indegree count for each node;
        Integer[] indegreeCount  = new Integer[graph.size()];
        Arrays.fill(indegreeCount, 0);
        for(ArrayList<Integer> vertex: graph){
            vertex.forEach(e->indegreeCount[e]++);
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();

        //Add vertices with indegree count 0
        for(int i=0;i<graph.size();i++){
            if(indegreeCount[i] == 0){
                queue.add(i);
            }
        }
        int visitedNodeCount = 0;
        ArrayList<Integer> visitedNodes = new ArrayList();
        while(!queue.isEmpty()){
            Integer n  = queue.getFirst();
            visitedNodes.add(n);
            visitedNodeCount++;
            ArrayList<Integer> temp  =  graph.get(n);
            for(Integer x : temp){
                indegreeCount[x]--;
                if(indegreeCount[x] == 0){
                    queue.add(x);
                }
            }
        }
        if(visitedNodeCount != graph.size()){
            System.out.println("Sort not possible");
            return;
        }

        System.out.println(visitedNodes);

    }

}
