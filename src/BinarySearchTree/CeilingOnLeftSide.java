package BinarySearchTree;

import java.util.TreeSet;

public class CeilingOnLeftSide {

    static void printCeil(int[] arr, int n) {
        TreeSet<Integer> s = new TreeSet<>();
        System.out.print(-1 + " ");
        s.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (s.ceiling(arr[i]) != null) {
                System.out.print(s.ceiling(arr[i]) + " ");
            } else {
                System.out.print(-1 + " ");
            }
            s.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 30, 15, 25, 12};
        printCeil(arr, arr.length);
    }
}
