package Graph;

import java.util.ArrayList;

public class DepthFirstSearch {

    static void printDFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                printDFS(adj, i, visited);
            }
        }
    }

    // get count of different graphs
    // for a single connected graph, count = 1
    static void DFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v + 1];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                printDFS(adj, i, visited);
                count++;
            }
        }
        System.out.println("\nCount = " + count);
    }
    /*static void DFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                printDFS(adj, i, visited);
            }
        }
    }*/

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 7;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        Graph.addEdge(adj, 0, 1);
        Graph.addEdge(adj, 2, 3);
        Graph.addEdge(adj, 2, 3);
        Graph.addEdge(adj, 2, 4);
        Graph.addEdge(adj, 5, 5);
        Graph.addEdge(adj, 6, 6);
        DFS(adj, v);
    }
}
