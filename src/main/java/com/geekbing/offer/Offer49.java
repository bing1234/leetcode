package com.geekbing.offer;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author bing
 */
public class Offer49 {
    public int nthUglyNumber(int n) {
        long[] dp = new long[n + 5];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        for (int i = 6; i <= n; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if (dp[j] * 2 > dp[i - 1] && min > dp[j] * 2) {
                    min = dp[j] * 2;
                }
                if (dp[j] * 3 > dp[i - 1] && min > dp[j] * 3) {
                    min = dp[j] * 3;
                }
                if (dp[j] * 5 > dp[i - 1] && min > dp[j] * 5) {
                    min = dp[j] * 5;
                }
            }
            dp[i] = (int) min;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        Offer49 offer49 = new Offer49();
        System.out.println(offer49.nthUglyNumber(10));
        System.out.println(offer49.nthUglyNumber(20));
        System.out.println(offer49.nthUglyNumber(1690));
    }
}
