package Graph;

import java.util.PriorityQueue;

public class PrimsAlgorithm {

    public static final int INF = Integer.MAX_VALUE;

    static void findMST(int[][] adj, boolean[] visited, int v) {
        visited[0] = true;
        int min, r = 0, c = 0, total = 0;
        for (int counter = 0; counter < v - 1; counter++) {
            min = INF;
            for (int i = 0; i < v; i++) {
                if (visited[i]) {
                    for (int j = 0; j < v; j++) {
                        if (!visited[j]) {
                            if (min > adj[i][j]) {
                                min = adj[i][j];
                                r = i;
                                c = j;
                            }
                        }
                    }
                }
            }
            visited[c] = true;
            total += min;
            adj[r][c] = adj[c][r] = INF;
            System.out.println("Edge connected: " + r + " -> " + c + " : " + min);
        }
        System.out.println("Total weight: " + total);
    }

    public static void main(String[] args) {
        int v = 5;
        int[][] graph = new int[][]{
                {0, 8, 9, INF, INF},
                {8, 0, INF, 10, 3},
                {9, INF, 0, INF, 5},
                {0, 10, INF, 0, 6},
                {INF, 3, 5, 6, 0}
        };
        boolean[] visited = new boolean[v];
//        findMST(graph, visited, v);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(8);
        pq.add(9);
        pq.add(0);
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
    }
}
