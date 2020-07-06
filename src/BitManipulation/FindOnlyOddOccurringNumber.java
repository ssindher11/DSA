package BitManipulation;

public class FindOnlyOddOccurringNumber {

    static int findNum(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 4, 4, 4, 5, 5, 5, 3};
        System.out.println(findNum(arr, arr.length));
    }
}
