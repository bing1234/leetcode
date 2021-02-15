package com.geekbing.easy;

public class LeetCode747 {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE, maxIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max <= nums[i]) {
                second = max;
                max = nums[i];
                maxIdx = i;
            } else if (second <= nums[i]) {
                second = nums[i];
            }
        }
        return max >= second * 2 ? maxIdx : -1;
    }

    public static void main(String[] args) {
        LeetCode747 leetCode747 = new LeetCode747();
        System.out.println(leetCode747.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(leetCode747.dominantIndex(new int[]{1, 2, 3, 4}));
    }
}
