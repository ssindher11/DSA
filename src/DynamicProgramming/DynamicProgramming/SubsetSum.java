package DynamicProgramming;

public class SubsetSum {

    // recursive
    // Time Complexity : O(2^n)
    static int countSubsetsRec(int[] arr, int n, int sum) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        return countSubsetsRec(arr, n - 1, sum) + countSubsetsRec(arr, n - 1, sum - arr[n - 1]);
    }

    // Dynamic Programming
    // Time Complexity : O(n * sum)
    // Auxiliary space : O(n * sum)
    static int countSubsets(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= arr[i - 1]){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 5, 5};
        int sum = 25;
        /*int[] arr = {2, 5, 3};
        int sum = 5;*/
        System.out.println(countSubsetsRec(arr, arr.length, sum));
        System.out.println(countSubsets(arr, arr.length, sum));
    }
}
