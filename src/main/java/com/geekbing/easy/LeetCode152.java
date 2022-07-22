package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        // 以当前元素结尾的乘积最大、最小子数组
        int preMax = nums[0], preMin = nums[0], ans = nums[0], currentMax, currentMin;
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], Math.max(nums[i] * preMin, nums[i] * preMax));
            currentMin = Math.min(nums[i], Math.min(nums[i] * preMin, nums[i] * preMax));
            ans = Math.max(ans, currentMax);
            preMax = currentMax;
            preMin = currentMin;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode152 leetCode152 = new LeetCode152();
        assert leetCode152.maxProduct(new int[]{2, 3, -2, 4}) == 6;
    }

    @Test
    public void testCase2() {
        LeetCode152 leetCode152 = new LeetCode152();
        assert leetCode152.maxProduct(new int[]{-2, 0, -1}) == 0;
    }
}
