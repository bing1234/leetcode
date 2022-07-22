package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, minDiff = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                int diff = Math.abs(nums[left] + nums[right] + nums[i] - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    ans = nums[left] + nums[right] + nums[i];
                }
                if (nums[left] + nums[right] + nums[i] > target) {
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
        LeetCode16 leetCode16 = new LeetCode16();
        assert leetCode16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode16 leetCode16 = new LeetCode16();
        assert leetCode16.threeSumClosest(new int[]{0, 0, 0}, 1) == 0;
    }
}
