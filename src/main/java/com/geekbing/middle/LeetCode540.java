package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode540 {
    public int singleNonDuplicate(int[] nums) {
        // 处理特殊情况
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] < nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid - 1] == nums[mid]) {
                if ((mid - left + 1) % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((right - mid + 1) % 2 == 0) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    @Test
    public void testCase1() {
        LeetCode540 leetCode540 = new LeetCode540();
        assert leetCode540.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode540 leetCode540 = new LeetCode540();
        assert leetCode540.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}) == 10;
    }
}
