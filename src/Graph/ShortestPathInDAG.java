package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInDAG {

    public static final int INF = Integer.MAX_VALUE;
    static int[][] weight;

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v, int[] indegree) {
        adj.get(u).add(v);
        indegree[v]++;
    }

    static int w(int u, int v) {
        return weight[u][v];
    }

    static ArrayList<Integer> getTopologicalSort(ArrayList<ArrayList<Integer>> adj, int[] indegree, int v) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);
            for (int i : adj.get(u)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return topo;
    }

    static void printShortestPath(ArrayList<ArrayList<Integer>> adj, int V, int s, ArrayList<Integer> topo) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        for (int u : topo) {
            for (int v : adj.get(u)) {
                if (dist[v] > dist[u] + w(u, v)) {
                    dist[v] = dist[u] + w(u, v);
                }
            }
        }
        for (int i : dist) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[v];
        addEdge(adj, 0, 1, indegree);
        addEdge(adj, 0, 4, indegree);
        addEdge(adj, 1, 2, indegree);
        addEdge(adj, 4, 2, indegree);
        addEdge(adj, 4, 5, indegree);
        addEdge(adj, 2, 3, indegree);
        addEdge(adj, 5, 3, indegree);
        weight = new int[][]{
                {0, 2, INF, INF, 1, INF},
                {INF, 0, 3, INF, INF, INF},
                {INF, INF, 0, 6, INF, INF},
                {INF, INF, INF, 0, INF, INF},
                {INF, INF, 2, INF, 0, 4},
                {INF, INF, INF, 1, INF, 0}
        };
        int source = 0;
        ArrayList<Integer> topo = getTopologicalSort(adj, indegree, v);
        printShortestPath(adj, v, source, topo);
    }
}
