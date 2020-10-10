package DynamicProgramming;

import java.util.Arrays;

public class MaximumCuts {

    static int maxCuts(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (i - a >= 0) {
                dp[i] = Math.max(dp[i], dp[i - a]);
            }
            if (i - b >= 0) {
                dp[i] = Math.max(dp[i], dp[i - b]);
            }
            if (i - c >= 0) {
                dp[i] = Math.max(dp[i], dp[i - c]);
            }
            if (dp[i] != -1) {
                dp[i]++;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3, a = 2, b = 2, c = 4;
        System.out.println(maxCuts(n, a, b, c));
    }
}
