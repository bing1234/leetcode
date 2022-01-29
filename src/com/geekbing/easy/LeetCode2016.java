package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2016 {
    public int maximumDifference(int[] nums) {
        // dp[i]表示nums所在区间[0...i]内的最小值
        int[] dp = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            dp[i] = min;
        }
        int ans = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != dp[i - 1]) {
                ans = Math.max(ans, nums[i] - dp[i - 1]);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2016 leetCode2016 = new LeetCode2016();
        assert leetCode2016.maximumDifference(new int[]{7, 1, 5, 4}) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2016 leetCode2016 = new LeetCode2016();
        assert leetCode2016.maximumDifference(new int[]{9, 4, 3, 2}) == -1;
    }

    @Test
    public void testCase3() {
        LeetCode2016 leetCode2016 = new LeetCode2016();
        assert leetCode2016.maximumDifference(new int[]{1, 5, 2, 10}) == 9;
    }
}
