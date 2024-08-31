package com.geekbing.easy;

public class LeetCode2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        // dp[i] 表示以i结尾满足条件的最大长度
        int[] dp = new int[nums.length];
        dp[0] = nums[0] % 2 == 0 && nums[0] <= threshold ? 1 : 0;

        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > threshold) {
                dp[i] = 0;
            } else {
                if (dp[i - 1] > 0) {
                    // 当前数字与前1个数字奇偶不同
                    if (nums[i] % 2 != nums[i - 1] % 2) {
                        dp[i] = dp[i - 1] + 1;
                    } else {
                        dp[i] = nums[i] % 2 == 0 ? 1 : 0;
                    }
                } else {
                    dp[i] = nums[i] % 2 == 0 ? 1 : 0;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
