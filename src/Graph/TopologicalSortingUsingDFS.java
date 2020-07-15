package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingUsingDFS {

    static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, Stack<Integer> stack) {
        visited[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                DFSRec(adj, u, visited, stack);
            }
        }
        stack.push(s);
    }

    static void printTopologicalOrder(ArrayList<ArrayList<Integer>> adj, int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                DFSRec(adj, i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        Graph.addDirectedEdge(adj, 0, 1);
        Graph.addDirectedEdge(adj, 1, 3);
        Graph.addDirectedEdge(adj, 3, 4);
        Graph.addDirectedEdge(adj, 2, 3);
        Graph.addDirectedEdge(adj, 2, 4);
        printTopologicalOrder(adj, v);
    }
}
