package DynamicProgramming;

public class maxNonContiguousSum {

    // Time Complexity : O(n)
    // Auxiliary space : O(n)
    static int maxSum(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        int[] dp = new int[n + 1];
        dp[1] = arr[0];
        dp[2] = Math.max(arr[1], arr[0]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }

        return dp[n];
    }

    // Auxiliary space : O(1)
    static int maxSumO1(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        int pp = arr[0];
        int p = Math.max(arr[0], arr[1]);
        int curr = arr[0];

        for (int i = 3; i <= n; i++) {
            curr = Math.max(p, pp + arr[i - 1]);
            pp = p;
            p = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(maxSum(arr, arr.length));
        System.out.println(maxSumO1(arr, arr.length));
    }
}
