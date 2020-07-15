package Graph;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {

    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int parent) {
        visited[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                if (DFSRec(adj, u, visited, s)) {
                    return true;
                }
            } else if (u != parent) {
                return true;
            }
        }
        return false;
    }

    static boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (DFSRec(adj, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        Graph.addEdge(adj, 0, 1);
        Graph.addEdge(adj, 1, 2);
        Graph.addEdge(adj, 1, 3);
        Graph.addEdge(adj, 2, 3);
        Graph.addEdge(adj, 2, 4);
        Graph.addEdge(adj, 4, 5);
        System.out.println(checkCycle(adj, v));
    }
}
