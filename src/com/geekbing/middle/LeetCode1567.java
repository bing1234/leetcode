package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1567 {
    public int getMaxLen(int[] nums) {
        // positive[i]表示以第i个元素结尾的乘积为正的最长子数组的长度
        // negative[i]表示以第i个元素结尾的乘积为负的最长子数组的长度
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];
        positive[0] = nums[0] > 0 ? 1 : 0;
        negative[0] = nums[0] < 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] > 0 ? positive[i - 1] + 1 : 1;
            } else if (nums[i] == 0) {
                positive[i] = 0;
                negative[i] = 0;
            } else {
                positive[i] = positive[i - 1] > 0 ? positive[i - 1] + 1 : 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            }
        }
        return Arrays.stream(positive).max().orElse(0);
    }

    @Test
    public void testCase1() {
        LeetCode1567 leetCode1567 = new LeetCode1567();
        assert leetCode1567.getMaxLen(new int[]{1, -2, -3, 4}) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode1567 leetCode1567 = new LeetCode1567();
        assert leetCode1567.getMaxLen(new int[]{0, 1, -2, -3, -4}) == 3;
    }

    @Test
    public void testCase3() {
        LeetCode1567 leetCode1567 = new LeetCode1567();
        assert leetCode1567.getMaxLen(new int[]{-1, -2, -3, 0, 1}) == 2;
    }
}
