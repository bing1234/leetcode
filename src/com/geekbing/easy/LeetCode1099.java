package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        // 特殊情况处理
        if (nums.length <= 1) {
            return -1;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, ans = -1;
        while (left < right) {
            if (nums[left] + nums[right] >= k) {
                right--;
            } else {
                ans = Math.max(ans, nums[left] + nums[right]);
                left++;
            }
        }
        return ans;
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
