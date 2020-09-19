package com.geekbing.middle;

public class LeetCode877 {
    public boolean stoneGame(int[] piles) {
        // dp[i,j]表示nums[i,j]先手获得的利润
        int[][] dp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = piles.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < piles.length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][piles.length - 1] > 0;
    }

    public static void main(String[] args) {
        LeetCode877 leetCode877 = new LeetCode877();
        System.out.println(leetCode877.stoneGame(new int[]{5, 3, 4, 5}));
        System.out.println(leetCode877.stoneGame(new int[]{7, 7, 12, 16, 41, 48, 41, 48, 11}));
    }
}
