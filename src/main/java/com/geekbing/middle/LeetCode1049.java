package com.geekbing.middle;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 * 1049. 最后一块石头的重量 II
 *
 * @author bing
 */
public class LeetCode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        // dp[i][j] 表示遇到第i块石头时体积为j的背包中最大价值，尽量逼近sum/2
        // 不选第i块时，dp[i][j] = dp[i - 1][j]
        // 选第i快时, dp[i][j] = dp[i - 1][j - stones[i]] + stones[i]
        int[][] dp = new int[stones.length + 1][sum / 2 + 1];
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j < sum / 2 + 1; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - 2 * dp[stones.length][sum / 2];
    }

    public static void main(String[] args) {
        LeetCode1049 leetCode1049 = new LeetCode1049();
        System.out.println(leetCode1049.lastStoneWeightII(new int[]{1, 2}));
        System.out.println(leetCode1049.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(leetCode1049.lastStoneWeightII(new int[]{57, 32, 40, 27, 35, 61}));
    }
}
