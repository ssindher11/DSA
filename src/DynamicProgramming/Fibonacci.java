package DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {

    // 1 1 2 3 5 8 13 21 34 55
    // Recursive
    static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // Top Down DP
    static int fibDP(int n, int[] dp) {
        if (n == 0 || n == 1) {
            dp[n] = n;
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = fibDP(n - 1, dp) + fibDP(n - 2, dp);
        return dp[n];
    }

    // Bottom Up DP
    static int fibBottomUpDP (int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(fib(n));
        int[] dp = new int[100];
        Arrays.fill(dp, -1);
        System.out.println(fibDP(n, dp));
        System.out.println(fibBottomUpDP(n));
    }

}
