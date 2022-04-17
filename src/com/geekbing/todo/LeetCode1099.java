package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        // 特殊情况处理
        if (nums.length <= 1 || nums[0] + nums[1] >= k) {
            return -1;
        }
        Arrays.sort(nums);
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1099 leetCode1099 = new LeetCode1099();
        assert leetCode1099.twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60) == 58;
    }

    @Test
    public void testCase2() {
        LeetCode1099 leetCode1099 = new LeetCode1099();
        assert leetCode1099.twoSumLessThanK(new int[]{10, 20, 30}, 15) == -1;
    }
}
