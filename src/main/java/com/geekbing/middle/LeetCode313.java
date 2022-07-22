package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // p2、p3、p5 分别表示有资格同2、3、5相乘的最小下标i的位置
        int[] p = new int[primes.length];
        Arrays.fill(p, 1);
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (dp[p[j]] * primes[j] > dp[i - 1]) {
                    min = Math.min(min, dp[p[j]] * primes[j]);
                }
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == dp[p[j]] * primes[j]) {
                    p[j]++;
                }
            }
        }
        return dp[n];
    }


    @Test
    public void testCase1() {
        LeetCode313 leetCode313 = new LeetCode313();
        assert leetCode313.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}) == 32;
    }

    @Test
    public void testCase2() {
        LeetCode313 leetCode313 = new LeetCode313();
        assert leetCode313.nthSuperUglyNumber(1, new int[]{2, 3, 5}) == 1;
    }
}
