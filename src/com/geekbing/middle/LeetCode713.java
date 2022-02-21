package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode713 leetCode713 = new LeetCode713();
        assert leetCode713.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100) == 8;
    }

    @Test
    public void testCase2() {
        LeetCode713 leetCode713 = new LeetCode713();
        assert leetCode713.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0) == 0;
    }
}
