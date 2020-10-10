package DynamicProgramming;

import java.util.Arrays;

public class MinCoinsNeeded {

    // recursive
    static int minCoins(int[] coins, int amt, int n) {
        if (amt == 0) {
            return 0;
        }
        int coinsNeeded = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (amt - coins[i] >= 0) {
                int temp = minCoins(coins, amt - coins[i], n);
                if (temp != coinsNeeded) {
                    coinsNeeded = Math.min(temp + 1, coinsNeeded);
                }
            }
        }
        return coinsNeeded;
    }

    // BU DP
    static int coinsNeededDP(int[] coins, int amt, int n) {
        int[] dp = new int[amt + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int r = 1; r <= amt; r++) {

            // for coins
            for (int i = 0; i < n; i++) {
                if (coins[i] <= r) {
                    int smallerAns = dp[r - coins[i]];
                    if (smallerAns != Integer.MAX_VALUE) {
                        dp[r] = Math.min(dp[r], smallerAns + 1);
                    }
                }
            }
        }
        return dp[amt];
    }

    public static void main(String[] args) {
        int[] usCoins = {1, 2, 3};
        int n = usCoins.length;
        int amt = 4;
//        System.out.println(minCoins(usCoins, amt, n));
        System.out.println(coinsNeededDP(usCoins, amt, n));

        int[] indianCoins = {1, 2, 5, 10, 50};
        n = indianCoins.length;
        amt = 39;
//        System.out.println(minCoins(indianCoins, amt, n));
        System.out.println(coinsNeededDP(indianCoins, amt, n));
    }
}
