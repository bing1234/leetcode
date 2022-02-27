package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ans += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode611 leetCode611 = new LeetCode611();
        assert leetCode611.triangleNumber(new int[]{2, 2, 3, 4}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode611 leetCode611 = new LeetCode611();
        assert leetCode611.triangleNumber(new int[]{4, 2, 3, 4}) == 4;
    }
}
