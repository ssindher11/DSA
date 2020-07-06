package Hashing;

import java.util.HashMap;

public class LongestSubarrayWithEqual01 {

    static int findLongest(int[] arr, int n) {
        int prefixSum = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                res = i + 1;
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            } else {
                res = Math.max(res, i - map.get(prefixSum));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        System.out.println(findLongest(arr, arr.length));
    }
}
