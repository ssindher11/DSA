package Hashing;

import java.util.HashSet;

public class UnionOfTwoUnsortedArrays {

    static int findUnique(int[] a1, int[] a2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : a1) {
            set.add(i);
        }
        for (int i : a2) {
            set.add(i);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] a1 = {15, 20, 5, 15};
        int[] a2 = {15, 15, 15, 20, 10};
        System.out.println(findUnique(a1, a2));
    }
}
