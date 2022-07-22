package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0] 表示第i天结束后，持有1个股票，对应的累计最大收益
        // dp[i][1] 表示第i天结束后，不持有股票，且处于冷冻期，对应的累计最大收益
        // dp[i][2] 表示第i天结束后，不持有股票，且不处于冷冻期，对应的累计最大收益
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    @Test
    public void testCase1() {
        LeetCode309 leetCode309 = new LeetCode309();
        assert leetCode309.maxProfit(new int[]{1, 2, 3, 0, 2}) == 3;
    }


    @Test
    public void testCase2() {
        LeetCode309 leetCode309 = new LeetCode309();
        assert leetCode309.maxProfit(new int[]{1}) == 0;
    }
}
