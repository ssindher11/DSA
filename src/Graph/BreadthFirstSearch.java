package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    static void printBFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int i : adj.get(u)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    static void BFSDis(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                printBFS(adj, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 6;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        Graph.addEdge(adj, 0, 1);
        Graph.addEdge(adj, 0, 2);
        Graph.addEdge(adj, 0, 5);
        Graph.addEdge(adj, 1, 3);
        Graph.addEdge(adj, 2, 4);
        Graph.addEdge(adj, 3, 5);
        Graph.addEdge(adj, 4, 5);
        BFSDis(adj, v);
    }
}
