package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraph {

    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recSt) {
        visited[s] = true;
        recSt[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u] && DFSRec(adj, u, visited, recSt)) {
                return true;
            } else if (recSt[u]) {
                return true;
            }
        }
        recSt[s] = false;
        return false;
    }

    static boolean checkCycles(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        boolean[] recSt = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (DFSRec(adj, i, visited, recSt)) {
                    return true;
                }
            }
        }
        return false;
    }


    // Kahn's Algorithm
    static boolean checkByKahn(ArrayList<ArrayList<Integer>> adj, int v, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i : adj.get(u)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
            count++;
        }
        return (count != v);
    }

    static void addEdgeWithInDegree(ArrayList<ArrayList<Integer>> adj, int u, int v, int[] indegree) {
        adj.get(u).add(v);
        indegree[v]++;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        Graph.addDirectedEdge(adj, 0, 1);
        Graph.addDirectedEdge(adj, 2, 1);
        Graph.addDirectedEdge(adj, 2, 3);
        Graph.addDirectedEdge(adj, 3, 4);
        Graph.addDirectedEdge(adj, 4, 5);
        Graph.addDirectedEdge(adj, 5, 3);
        System.out.println(checkCycles(adj, v));

        int v1 = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v1; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[v1];
        addEdgeWithInDegree(graph, 0, 1, indegree);
        addEdgeWithInDegree(graph, 4, 1, indegree);
        addEdgeWithInDegree(graph, 1, 2, indegree);
        addEdgeWithInDegree(graph, 2, 3, indegree);
        addEdgeWithInDegree(graph, 3, 1, indegree);
        System.out.println(checkByKahn(graph, v1, indegree));
    }
}
