package com.geekbing.interview;

/**
 * @author bing
 */
public class Interview1617 {
    public int maxSubArray(int[] nums) {
        // dp[i]表示以num[i]结尾的最大连续子数组
        // dp[i] = max(dp[i-1]+nums[i], nums[i])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Interview1617 interview1617 = new Interview1617();
        System.out.println(interview1617.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
