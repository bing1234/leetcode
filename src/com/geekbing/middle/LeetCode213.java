package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 不偷第1家的情况下能够获取到的最大利益
        int num1 = rob(nums, 1, nums.length - 1);
        // 不偷最后一家的情况下能够获取到的最大利益
        int num2 = rob(nums, 0, nums.length - 2);
        return Math.max(num1, num2);
    }

    private int rob(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        int max = dp[1], idx = 2;
        for (int i = start + 2; i <= end; i++) {
            dp[idx] = Math.max(dp[idx - 2] + nums[i], dp[idx - 1]);
            max = Math.max(max, dp[idx]);
            idx++;
        }
        return max;
    }

    @Test
    public void testCase1() {
        LeetCode213 leetCode213 = new LeetCode213();
        assert leetCode213.rob(new int[]{2, 3, 2}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode213 leetCode213 = new LeetCode213();
        assert leetCode213.rob(new int[]{1, 2, 3, 1}) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode213 leetCode213 = new LeetCode213();
        assert leetCode213.rob(new int[]{1, 2, 3}) == 3;
    }

    @Test
    public void testCase4() {
        LeetCode213 leetCode213 = new LeetCode213();
        assert leetCode213.rob(new int[]{0, 0}) == 0;
    }
}
