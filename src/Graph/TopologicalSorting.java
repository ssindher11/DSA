package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Kahn's Algorithm
public class TopologicalSorting {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v, int[] indegree) {
        adj.get(u).add(v);
        indegree[v]++;
    }

    static void printTopologicalOrder(ArrayList<ArrayList<Integer>> adj, int[] indegree, int v) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int i : adj.get(u)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[v];
        addEdge(adj, 0, 2, indegree);
        addEdge(adj, 0, 3, indegree);
        addEdge(adj, 1, 3, indegree);
        addEdge(adj, 1, 4, indegree);
        addEdge(adj, 2, 3, indegree);
        printTopologicalOrder(adj, indegree, v);
    }
}
