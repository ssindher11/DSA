package Hashing;

import java.util.HashMap;

public class LongestSubarrayWithGivenSum {

    static int lenSubArray(int[] arr, int n, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum == sum) {
                res = i + 1;
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
            if (map.containsKey(prefixSum - sum)) {
                res = Math.max(res, i - map.get(prefixSum - sum));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 5, -6, 6, 2, 2};
        int sum = 4;
        System.out.println(lenSubArray(arr, arr.length, sum));
    }
}
