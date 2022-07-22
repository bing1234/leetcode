package com.geekbing.middle;

public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int each = sum / 2;
        if (max > each) {
            return false;
        }
        // dp[i][j] 表示nums[0...i]中是否存在一些元素和为j
        boolean[][] dp = new boolean[nums.length][each + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
            dp[i][nums[i]] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else if (nums[i] == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][each];
    }

    public static void main(String[] args) {
        LeetCode416 leetCode416 = new LeetCode416();
        System.out.println(leetCode416.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(leetCode416.canPartition(new int[]{1, 2, 3, 5}));
    }
}
