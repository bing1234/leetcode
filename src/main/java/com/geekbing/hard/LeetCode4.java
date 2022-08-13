package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int idx = 0, idx1 = 0, idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2]) {
                nums[idx] = nums1[idx1];
                idx1++;
            } else {
                nums[idx] = nums2[idx2];
                idx2++;
            }
            idx++;
        }
        while (idx1 < nums1.length) {
            nums[idx] = nums1[idx1];
            idx++;
            idx1++;
        }
        while (idx2 < nums2.length) {
            nums[idx] = nums2[idx2];
            idx++;
            idx2++;
        }
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0D;
        }
        return nums[nums.length / 2];
    }

    @Test
    public void testCase1() {
        LeetCode4 leetCode4 = new LeetCode4();
        double ans = leetCode4.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        assert ans - 2.00000D < 0.00001D;
    }

    @Test
    public void testCase2() {
        LeetCode4 leetCode4 = new LeetCode4();
        double ans = leetCode4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        assert ans - 2.50000D < 0.00001D;
    }
}
