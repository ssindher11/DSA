package Hashing;

import java.util.HashSet;

public class CountDistinctElements {

    static int countDistinct(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        return set.size();
    }


    public static void main(String[] args) {
        int[] arr = {15, 12, 13, 12, 12, 13, 13, 18};
        System.out.println(countDistinct(arr, arr.length));
    }
}
