package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        LeetCode215 leetCode215 = new LeetCode215();
        System.out.println(leetCode215.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(leetCode215.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
