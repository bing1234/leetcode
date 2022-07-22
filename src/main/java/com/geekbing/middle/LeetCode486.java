package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode486 {
    public boolean PredictTheWinner(int[] nums) {
        // dp[i,j]表示nums[i,j]先手获得的利润
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] > 0;
    }

    public boolean PredictTheWinner2(int[] nums) {
        int sum = arrSubSum(nums, 0, nums.length - 1);
        int max = maxCanGet(nums, 0, nums.length - 1);
        return max >= sum - max;
    }

    private int maxCanGet(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        if (right - left == 1) {
            return Math.max(nums[left], nums[right]);
        }
        int sum = arrSubSum(nums, left, right);
        // 如果选择最左边能够得到的最大值
        int chooseLeft = sum - maxCanGet(nums, left + 1, right);
        // 如果选择最右边能够得到的最大值
        int chooseRight = sum - maxCanGet(nums, left, right - 1);
        return Math.max(chooseLeft, chooseRight);
    }

    private int arrSubSum(int[] nums, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }

    @Test
    public void testCase1() {
        LeetCode486 leetCode486 = new LeetCode486();
        assert !leetCode486.PredictTheWinner(new int[]{1, 5, 2});
    }

    @Test
    public void testCase2() {
        LeetCode486 leetCode486 = new LeetCode486();
        assert leetCode486.PredictTheWinner(new int[]{1, 5, 233, 7});
    }

    @Test
    public void testCase3() {
        LeetCode486 leetCode486 = new LeetCode486();
        assert leetCode486.PredictTheWinner(new int[]{1, 567, 1, 1, 99, 100});
    }
}
