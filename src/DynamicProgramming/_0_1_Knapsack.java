package DynamicProgramming;

import java.util.Arrays;

public class _0_1_Knapsack {

    // recursive
    static int knapsack(int[] wts, int[] prices, int n, int w) {
        if (n == 0 || w == 0) {
            return 0;
        }

        int inc = 0, exc = 0;
        if (wts[n - 1] <= w) {
            inc = prices[n - 1] + knapsack(wts, prices, n - 1, w - wts[n - 1]);
        }
        exc = knapsack(wts, prices, n - 1, w);
        return Math.max(inc, exc);
    }

    // Bottom Up DP
    static int knapsackBU(int[] wts, int[] prices, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int inc = 0, exc;

                    if (wts[i - 1] <= j) {
                        inc = prices[i - 1] + dp[i][j - wts[i - 1]];
                    }
                    exc = dp[i - 1][j];
                    dp[i][j] = Math.max(inc, exc);
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] wts = {2, 2, 3, 1};
        int[] prices = {5, 20, 100, 30};
        int n = prices.length;
        int w = 5;

        System.out.println(knapsack(wts, prices, n, w));
        System.out.println(knapsackBU(wts, prices, n, w));
    }
}
