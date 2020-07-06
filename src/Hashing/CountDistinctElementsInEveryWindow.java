package Hashing;

import java.util.HashMap;
import java.util.HashSet;

/*Given an array, one needs to Count Distinct Elements In Every Window of Size K*/
public class CountDistinctElementsInEveryWindow {

    // Time Complexity: O((n - k) * k)
    static void countDistinct(int[] arr, int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                set.add(arr[i + j]);
            }
            System.out.print(set.size() + " ");
            set.clear();
        }
        System.out.println();
    }

    // Time Complexity: O(n)
    static void countDistinctOn(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size() + " ");
        for (int i = k; i < n; i++) {
            if (map.containsKey(arr[i - k])) {
                if (map.get(arr[i - k]) == 1) {
                    map.remove(arr[i - k]);
                } else {
                    map.replace(arr[i - k], map.get(arr[i - k]) - 1);
                }
            }
            if (map.containsKey(arr[i])) {
                map.replace(arr[i], map.get(arr[i] + 1));
            } else {
                map.put(arr[i], 1);
            }
            System.out.print(map.size() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a1 = {10, 10, 5, 3, 20, 5};
        int[] a2 = {10, 20, 10, 10, 30, 40};
        int k = 4;
        countDistinct(a1, a1.length, k);  // Output: 3 4 3
        countDistinct(a2, a2.length, k);  // Output: 2 3 3
        countDistinctOn(a1, a1.length, k);  // Output: 3 4 3
        countDistinctOn(a2, a2.length, k);  // Output: 2 3 3
    }
}
