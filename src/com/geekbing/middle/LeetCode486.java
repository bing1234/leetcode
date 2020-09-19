package com.geekbing.middle;

public class LeetCode486 {
    public boolean PredictTheWinner(int[] nums) {
        // dp[i,j]表示nums[i,j]先手获得的利润
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] > 0;
    }

    public static void main(String[] args) {
        LeetCode486 leetCode486 = new LeetCode486();
        System.out.println(leetCode486.PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(leetCode486.PredictTheWinner(new int[]{1, 5, 233, 7}));
    }
}
