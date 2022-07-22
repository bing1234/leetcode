package com.geekbing.hard;

import java.util.Arrays;

public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        k = Math.min(k, prices.length / 2);
        // buy[i][j] 表示对于数组 prices[0..i] 中的价格而言，进行恰好 j 笔交易，并且当前手上持有一支股票，这种情况下的最大利润
        int[][] buy = new int[prices.length][k + 1];
        // sell[i][j] 表示恰好进行 j 笔交易，并且当前手上不持有股票，这种情况下的最大利润。
        int[][] sell = new int[prices.length][k + 1];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < prices.length; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        return Arrays.stream(sell[prices.length - 1]).max().orElse(0);
    }

    public static void main(String[] args) {
        LeetCode188 leetCode188 = new LeetCode188();
        System.out.println(leetCode188.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(leetCode188.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
