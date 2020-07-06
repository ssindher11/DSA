package Hashing;

import java.util.HashSet;

public class IntersectionOfTwoArrays {

    static int findIntersection(int[] a1, int[] a2) {
        int count = 0;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : a1) {
            set1.add(i);
        }
        for (int i : a2) {
            set2.add(i);
        }
        for (int i : set1) {
            if (set2.contains(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 15, 20, 15, 30, 30, 5};
        int[] arr2 = {30, 5, 30, 80};
        System.out.println(findIntersection(arr1, arr2));
    }
}
