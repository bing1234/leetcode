package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1509 {
    public int minDifference(int[] nums) {
        // 特殊情况处理
        if (nums.length <= 4) {
            return 0;
        }

        // 先排序
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int left = 0, right = nums.length + left - 4;
        while (left < right && right < nums.length) {
            min = Math.min(min, nums[right] - nums[left]);
            left++;
            right = nums.length + left - 4;
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode1509 leetCode1509 = new LeetCode1509();
        System.out.println(leetCode1509.minDifference(new int[]{5, 3, 2, 4}));
        System.out.println(leetCode1509.minDifference(new int[]{1, 5, 0, 10, 14}));
        System.out.println(leetCode1509.minDifference(new int[]{6, 6, 0, 1, 1, 4, 6}));
        System.out.println(leetCode1509.minDifference(new int[]{1, 5, 6, 14, 15}));
    }
}
