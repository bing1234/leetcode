package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                for (int prime : primes) {
                    if (dp[j] * prime > dp[i - 1] && dp[j] * prime < min) {
                        min = dp[j] * prime;
                    }
                }
            }
            dp[i] = min;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        LeetCode313 leetCode313 = new LeetCode313();

        System.out.println(leetCode313.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
