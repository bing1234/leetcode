package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2239 {
    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(ans) > Math.abs(nums[i])) {
                ans = nums[i];
            } else if (Math.abs(ans) == Math.abs(nums[i])) {
                ans = Math.max(ans, nums[i]);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2239 leetCode2239 = new LeetCode2239();
        assert leetCode2239.findClosestNumber(new int[]{-4, -2, 1, 4, 8}) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode2239 leetCode2239 = new LeetCode2239();
        assert leetCode2239.findClosestNumber(new int[]{2, -1, 1}) == 1;
    }
}
