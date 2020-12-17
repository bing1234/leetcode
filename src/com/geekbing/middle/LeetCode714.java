package com.geekbing.middle;

public class LeetCode714 {
    public int maxProfit(int[] prices, int fee) {
        // dp[i][0] 表示第i天交易完成后，手中没有股票的最大收益
        // dp[i][1] 表示第i天交易完成后，手中有股票的最大收益
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        LeetCode714 leetCode714 = new LeetCode714();
        System.out.println(leetCode714.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
