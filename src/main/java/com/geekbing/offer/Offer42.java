package com.geekbing.offer;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        // dp[i] 表示以nums[i]结尾的连续子数组的最大和
        // dp[i] = max(dp[i-1]+ nums[i], nums[i])
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

    @Test
    public void testCase1() {
        Offer42 offer42 = new Offer42();

        int ans = offer42.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assert ans == 6;
    }
}
