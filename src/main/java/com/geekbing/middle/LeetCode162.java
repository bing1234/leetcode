package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 朝着上坡方向走，总能找到波峰
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void testCase1() {
        LeetCode162 leetCode162 = new LeetCode162();
        assert leetCode162.findPeakElement(new int[]{1, 2, 3, 1}) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode162 leetCode162 = new LeetCode162();
        int ans = leetCode162.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        Set<Integer> expert = new HashSet<>(Arrays.asList(1, 5));
        assert expert.contains(ans);
    }
}
