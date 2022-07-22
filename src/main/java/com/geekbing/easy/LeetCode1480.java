package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1480 {
    public int[] runningSum(int[] nums) {
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = current + nums[i];
            current = nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode1480 leetCode1480 = new LeetCode1480();

        System.out.println(Arrays.toString(leetCode1480.runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(leetCode1480.runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(leetCode1480.runningSum(new int[]{3, 1, 2, 10, 1})));
    }
}
