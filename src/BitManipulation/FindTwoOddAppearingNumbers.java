public class FindTwoOddAppearingNumbers {

    static void find(int[] arr, int n) {
        int xor = 0, r1 = 0, r2 = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        int sn = xor & -xor;
        for (int i = 0; i < n; i++) {
            if ((sn & arr[i]) != 0) {
                r1 ^= arr[i];
            } else {
                r2 ^= arr[i];
            }
        }
        System.out.println(r1 + " " + r2);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 4, 8, 4, 4, 31, 7, 7};
        find(arr, arr.length);
    }
}
