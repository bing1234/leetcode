package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode650 {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    min = Math.min(min, dp[j] + i / j);
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    @Test
    public void testCase1() {
        LeetCode650 leetCode650 = new LeetCode650();
        int ans = leetCode650.minSteps(3);
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode650 leetCode650 = new LeetCode650();
        assert leetCode650.minSteps(1) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode650 leetCode650 = new LeetCode650();
        assert leetCode650.minSteps(9) == 6;
    }
}
