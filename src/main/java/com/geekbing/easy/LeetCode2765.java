package com.geekbing.easy;

public class LeetCode2765 {
    public int alternatingSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        // dp[i]表示以下标i结尾的满足条件的最长的长度
        int[] dp = new int[nums.length];
        dp[1] = nums[1] - nums[0] == 1 ? 2 : 0;

        int ans = dp[1];
        for (int i = 2; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) != 1) {
                dp[i] = 0;
                continue;
            }
            if (dp[i - 1] > 0) {
                if (nums[i - 2] - nums[i - 1] != nums[i] - nums[i - 1]) {
                    dp[i] = nums[i - 1] < nums[i] ? 2 : 0;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = nums[i - 1] < nums[i] ? 2 : 0;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans == 0 ? -1 : ans;
    }
}
