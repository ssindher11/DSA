package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindTheNumberOfIslands {

    static class Pair {
        int p1, p2;

        Pair(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    static boolean exists(ArrayList<ArrayList<Integer>> adj, int i, int j, boolean[][] visited) {
        int n = adj.size();
        int m = adj.get(0).size();
        return (i >= 0 && i < n) && (j >= 0 && j < m) && (adj.get(i).get(j) == 1) && (!visited[i][j]);
    }

    static void traverse(ArrayList<ArrayList<Integer>> adj, int i, int j, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        visited[i][j] = true;

        int[] row = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] col = { -1, 0, 1, -1, 1, -1, 0, 1 };

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int r = p.p1;
            int c = p.p2;

            for (int k = 0; k < 8; k++) {
                if (exists(adj, r + row[k], c + col[k], visited)) {
                    visited[r + row[k]][c + col[k]] = true;
                    queue.add(new Pair(r + row[k], c + col[k]));
                }
            }
        }
    }

    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((A.get(i).get(j) == 1) && (!visited[i][j])) {
                    traverse(A, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(1);
        adj.get(0).add(0);
        adj.get(0).add(0);
        adj.get(1).add(0);
        adj.get(1).add(0);
        adj.get(1).add(1);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(2).add(0);
        adj.get(2).add(0);
        adj.get(2).add(1);
        adj.get(3).add(0);
        adj.get(3).add(1);
        adj.get(3).add(0);
        adj.get(3).add(0);
        System.out.println(findIslands(adj, 4, 4));
    }
}
