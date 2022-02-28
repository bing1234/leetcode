package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode264 {
    public int nthUglyNumberV2(int n) {
        // dp[i]表示第i个整数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // p2、p3、p5 分别表示有资格同2、3、5相乘的最小下标i的位置
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

    public int nthUglyNumber(int n) {
        // 丑数就是质因数只包含 2, 3, 5 的正整数
        // 令 dp[i]表示第i个丑数
        long[] dp = new long[n + 5];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        for (int i = 6; i <= n; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if (dp[j] * 2 > dp[i - 1]) {
                    min = Math.min(min, dp[j] * 2);
                }
                if (dp[j] * 3 > dp[i - 1]) {
                    min = Math.min(min, dp[j] * 3);
                }
                if (dp[j] * 5 > dp[i - 1]) {
                    min = Math.min(min, dp[j] * 5);
                }
            }
            dp[i] = min;
        }
        return (int) dp[n];
    }

    @Test
    public void testCase1() {
        LeetCode264 leetCode264 = new LeetCode264();
        assert leetCode264.nthUglyNumber(10) == 12;
    }

    @Test
    public void testCase2() {
        LeetCode264 leetCode264 = new LeetCode264();
        assert leetCode264.nthUglyNumber(1) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode264 leetCode264 = new LeetCode264();
        assert leetCode264.nthUglyNumberV2(10) == 12;
    }

    @Test
    public void testCase4() {
        LeetCode264 leetCode264 = new LeetCode264();
        assert leetCode264.nthUglyNumberV2(1) == 1;
    }
}
