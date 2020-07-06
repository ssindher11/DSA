package Hashing;

import java.util.Arrays;
import java.util.HashSet;

/*Given an array, we need to find the longest subsequence that has consecutive elements.
These consecutive elements may appear in any order in the subsequence.*/
public class LongestConsecutiveSubsequence {

    static int findLCS(int[] arr, int n) {
        Arrays.sort(arr);
        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(arr[i] - 1)) {
                curr = 1;
                while (set.contains(arr[i] + curr)) {
                    curr++;
                }
                cnt = Math.max(cnt, curr);
            }
            cnt = Math.max(cnt, curr);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 9, 3, 4, 2, 20};
        int[] a2 = {8, 20, 7, 30};
        int[] a3 = {20, 30,40};
        System.out.println(findLCS(a1, a1.length));     // Output: 4
        System.out.println(findLCS(a2, a2.length));     // Output: 2
        System.out.println(findLCS(a3, a3.length));     // Output: 1
    }
}
