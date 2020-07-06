package Hashing;

import java.util.HashSet;

public class SubarrayWithGivenSum {

    static boolean isSumPresent(int[] arr, int n, int sum) {
        int ps = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (ps == sum) {
                return true;
            }
            if (set.contains(ps - sum)) {
                return true;
            }
            set.add(ps);
            ps += arr[i];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 13, 3, -1};
        int sum = 22;
        System.out.println(isSumPresent(arr, arr.length, sum));
    }
}
