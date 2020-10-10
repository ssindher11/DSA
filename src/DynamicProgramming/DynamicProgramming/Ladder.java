package DynamicProgramming;

public class Ladder {

    static int getWays(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j <= k; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }

//  [0, 1, 2, 3, 4,  5,  6,  7,  8]
//  [1, 1, 2, 4, 7, 13, 24,  0,  0]

    static int ways2(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        int sum = dp[0] + dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = sum;
            sum += dp[i];
        }
        for (int i = k + 1; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]) -
                    dp[i - k - 1];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int k = 3, n = 6;
        System.out.println(getWays(n, k));
        System.out.println(ways2(n, k));
    }
}
