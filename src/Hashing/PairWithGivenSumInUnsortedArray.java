package Hashing;

import java.util.HashSet;

public class PairWithGivenSumInUnsortedArray {

    static boolean isPair(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(sum - i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {11, 5, 6};
        int sum = 10;
        System.out.println(isPair(arr, sum));
    }
}
