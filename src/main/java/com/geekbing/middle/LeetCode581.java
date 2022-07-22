package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(temp);
        int left = 0, right = nums.length - 1;
        while (left < right && temp[left] == nums[left]) {
            left++;
        }
        while (left < right && temp[right] == nums[right]) {
            right--;
        }
        return left >= right ? 0 : right - left + 1;
    }

    @Test
    public void testCase1() {
        LeetCode581 leetCode581 = new LeetCode581();
        assert leetCode581.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode581 leetCode581 = new LeetCode581();
        assert leetCode581.findUnsortedSubarray(new int[]{1, 2, 3, 4}) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode581 leetCode581 = new LeetCode581();
        assert leetCode581.findUnsortedSubarray(new int[]{1}) == 0;
    }
}
