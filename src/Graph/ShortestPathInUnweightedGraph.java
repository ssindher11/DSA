package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUnweightedGraph {

    static void printShortestDist(ArrayList<ArrayList<Integer>> adj, int s) {
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        boolean[] visited = new boolean[adj.size() + 1];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i : adj.get(u)) {
                if (!visited[i]) {
                    dist[i] = dist[u] + 1;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        for (int i : dist) {
            System.out.print(i + " ");
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
        Graph.addEdge(adj, 0, 4);
        Graph.addEdge(adj, 1, 3);
        Graph.addEdge(adj, 2, 3);
        Graph.addEdge(adj, 2, 4);
        Graph.addEdge(adj, 3, 5);
        Graph.addEdge(adj, 4, 5);
        printShortestDist(adj, 0);
    }
}
