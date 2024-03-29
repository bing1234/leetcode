package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode724 {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 累加和
        int[] totalSum = new int[nums.length];
        totalSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            totalSum[i] = totalSum[i - 1] + nums[i];
        }

        int leftSum, rightSum;
        for (int i = 0; i < nums.length; i++) {
            // 左边和
            leftSum = i == 0 ? 0 : totalSum[i - 1];
            // 右边和
            rightSum = totalSum[totalSum.length - 1] - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void testCase1() {
        LeetCode724 leetCode724 = new LeetCode724();
        assert leetCode724.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode724 leetCode724 = new LeetCode724();
        assert leetCode724.pivotIndex(new int[]{1, 2, 3}) == -1;
    }

    @Test
    public void testCase3() {
        LeetCode724 leetCode724 = new LeetCode724();
        assert leetCode724.pivotIndex(new int[]{2, 1, -1}) == 0;
    }
}
