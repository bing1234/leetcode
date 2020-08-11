package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        // dp[i]表示以num[i]结尾的最长上升子序列的长度
        // dp[i] = max(dp[j] + 1, 0<=j<i && num[j] < num[i])
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && temp < dp[j] + 1) {
                    temp = dp[j] + 1;
                }
            }
            dp[i] = temp;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode300 leetCode300 = new LeetCode300();
        System.out.println(leetCode300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
