package DynamicProgramming;

import java.math.BigInteger;

public class Catalan {

    static BigInteger binomCoeff(int n, int k) {
        BigInteger res = new BigInteger("1");
        for (int i = 0; i < k; i++) {
            res = res.multiply(new BigInteger(n - i + ""));
            res = res.divide(new BigInteger(i + 1 + ""));
        }

        return res;
    }

    static BigInteger catalan(int n) {
        BigInteger cat = binomCoeff(2 * n, n);
        cat = cat.divide(new BigInteger(n + 1 + ""));
        return cat;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(catalan(n));
    }
}
