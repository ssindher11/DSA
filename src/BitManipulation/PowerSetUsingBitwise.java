public class PowerSetUsingBitwise {

    // Time Complexity: O(n * (2^n))
    static void generateSubsets(String s, int n) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < Math.pow(2, n); i++) {
            for (int j = 0; j < n; j++) {
                if ((1 & (i >> j)) == 1) {
                    tmp.append(s.charAt(j));
                }
            }
            System.out.print(tmp + ", ");
            tmp = new StringBuilder();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "abc";
        generateSubsets(s, s.length());
    }
}
