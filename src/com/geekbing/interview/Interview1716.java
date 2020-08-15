package com.geekbing.interview;

/**
 * @author bing
 */
public class Interview1716 {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // dp[i][0]表示前i个邀请，不接接第i个邀约能够获得的最大值
        // dp[i][1]表示前i个邀请，接第i个邀约能够获得的最大值
        int[][] dp = new int[nums.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[0];
        dp[1][1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][0] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][1] + nums[i]);
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        Interview1716 interview1716 = new Interview1716();
        System.out.println(interview1716.massage(new int[]{1, 2, 3, 1}));
        System.out.println(interview1716.massage(new int[]{2, 7, 9, 3, 1}));
        System.out.println(interview1716.massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }
}
