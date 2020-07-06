package Hashing;

import java.util.HashMap;

public class LongestCommonSpanWithSameSumInTwoBinaryArrays {

    static int findLongest(int[] a1, int[] a2, int n) {
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = a1[i] - a2[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += temp[i];
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
        int[] a1 = {0, 1, 0, 1, 1, 0};
        int[] a2 = {1, 0, 0, 1, 0, 1};
        System.out.println(findLongest(a1, a2, a1.length));
    }
}
