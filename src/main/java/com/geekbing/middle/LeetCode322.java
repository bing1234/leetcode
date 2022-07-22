package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        // dp[n] 表示组成n所花费的最少硬币数
        // dp[n] = min(dp[n - coins[j]]) + 1, 0<=j<=coins.length
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] < min) {
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        LeetCode322 leetCode322 = new LeetCode322();
        System.out.println(leetCode322.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(leetCode322.coinChange(new int[]{2}, 3));
    }
}
