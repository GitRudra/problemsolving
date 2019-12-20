package org.home.ds.sort;


import java.util.*;

public class TopologicalSort {

    private Stack<Integer> stack;
    private Set<Integer> visitedNode;
    private Graph g;


    public TopologicalSort(Graph g) {
        stack = new Stack<>();
        visitedNode = new HashSet<>();
        this.g = g;
    }

    public void topologicalSort() {
        for(int i=0;i<g.getTotalVertices();i++){
            if(!visitedNode.contains(i)){
                topologicalSortUtil(i);
            }
        }

        //   topologicalSortUtil(0);
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public void topologicalSortUtil(int vertex) {
        visitedNode.add(vertex);

        Iterator<Integer> it = g.getAdjList()[vertex].iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (!visitedNode.contains(i)) {
                topologicalSortUtil(i);
            }
        }

        stack.push(vertex);
    }

    public void allTopologicalSort() {
        int[] inDegree = populateInDegreeCount();
        boolean[] visited = new boolean[g.getTotalVertices()];
        Arrays.fill(visited, false);
        ArrayList<Integer> stack = new ArrayList<>();

        allTopologicalSortUtil(visited, inDegree, stack);
    }

    private void allTopologicalSortUtil(boolean[] visited, int[] inDegree, List<Integer> order) {
        boolean flag = false;
        for (int i = 0; i < g.getTotalVertices(); i++) {
            if (!visited[i] && inDegree[i] == 0) {
                visited[i] = true;
                order.add(i);

                g.getAdjList()[i].iterator().forEachRemaining(e -> inDegree[e]--);
                allTopologicalSortUtil(visited, inDegree, order);

                visited[i] = false;
                order.remove(order.size() - 1);
                g.getAdjList()[i].iterator().forEachRemaining(e -> inDegree[e]++);
                flag = true;
            }
            if (flag) {
                order.forEach(e -> System.out.print(e + " "));
                System.out.println();
            }
        }
    }

    private int[] populateInDegreeCount() {
        int[] inDegreeCount = new int[g.getTotalVertices()];

        for (int i = 0; i < g.getTotalVertices(); i++) {
            Iterator<Integer> it = g.getAdjList()[i].iterator();
            it.forEachRemaining(e -> inDegreeCount[e]++);
            /*while (it.hasNext()) {
                inDegreeCount[it.next()]++;
            }*/
        }
        return inDegreeCount;
    }
}
