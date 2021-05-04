package com.geekbing;

import java.math.BigDecimal;

public class Solution {
    private static final BigDecimal MOD = BigDecimal.valueOf(5820210412L);

    public BigDecimal superPow(BigDecimal a, int[] b) {
        int n = b.length;
        if (n == 0) {
            return BigDecimal.valueOf(1L);
        }
        int[] copy = new int[n - 1];
        System.arraycopy(b, 0, copy, 0, n - 1);
        return simplePow(a, b[n - 1]).multiply(simplePow(superPow(a, copy), 10)).divideAndRemainder(MOD)[1];
    }

    private BigDecimal simplePow(BigDecimal a, long i) {
        if (i == 0) {
            return BigDecimal.valueOf(1L);
        } else if (i % 2L == 1L) {
            return a.divideAndRemainder(MOD)[1].multiply(simplePow(a, i - 1)).divideAndRemainder(MOD)[1];
        } else {
            BigDecimal half = simplePow(a, i / 2).divideAndRemainder(MOD)[1];
            return half.pow(2).divideAndRemainder(MOD)[1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        BigDecimal a = BigDecimal.valueOf(5820051212L);
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        BigDecimal ans = solution.superPow(a, b);
        System.out.println(ans.toString());
    }
}
