public class CountSetBitsInNumber {

    static int countBits(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((1 & (n >> i)) == 1) {
                count++;
            }
        }
        return count;
    }

    // Time Complexity : O(set bit count)
    static int countByBrianKerningam(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    // Time Complexity : O(1)
    static int countByLookupTable(int n) {
        int[] table = new int[256];
        table[0] = 0;
        for (int i = 1; i < 256; i++) {
            table[i] = (i & 1) + table[i / 2];
        }
        int res = table[n & 0xFF];
        n >>= 8;
        res += table[n & 0xFF];
        n >>= 8;
        res += table[n & 0xFF];
        n >>= 8;
        res += table[n & 0xFF];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countBits(5));       // Output: 2
        System.out.println(countBits(7));       // Output: 3
        System.out.println(countBits(15));      // Output: 4
        System.out.println(countByBrianKerningam(5));       // Output: 2
        System.out.println(countByBrianKerningam(7));       // Output: 3
        System.out.println(countByBrianKerningam(15));      // Output: 4
        System.out.println(countByLookupTable(5));       // Output: 2
        System.out.println(countByLookupTable(7));       // Output: 3
        System.out.println(countByLookupTable(15));      // Output: 4
    }
}
