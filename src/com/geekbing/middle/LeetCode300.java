package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode300 leetCode300 = new LeetCode300();
        assert leetCode300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode300 leetCode300 = new LeetCode300();
        assert leetCode300.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode300 leetCode300 = new LeetCode300();
        assert leetCode300.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}) == 1;
    }
}
