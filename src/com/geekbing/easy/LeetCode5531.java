package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode5531 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            if (bigCount(nums, i) == i) {
                return i;
            }
        }
        return -1;
    }

    private int bigCount(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return nums.length - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode5531 leetCode5531 = new LeetCode5531();
        System.out.println(leetCode5531.specialArray(new int[]{3, 5}));
        System.out.println(leetCode5531.specialArray(new int[]{0, 0}));
        System.out.println(leetCode5531.specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(leetCode5531.specialArray(new int[]{3, 6, 7, 7, 0}));
    }
}
