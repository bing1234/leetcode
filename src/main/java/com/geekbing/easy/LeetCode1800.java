package com.geekbing.easy;

public class LeetCode1800 {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                sum += nums[i];
            } else {
                max = Math.max(max, sum);
                sum = nums[i];
            }
        }
        max = Math.max(max, sum);
        return max;
    }

    public static void main(String[] args) {
        LeetCode1800 leetCode1800 = new LeetCode1800();
        System.out.println(leetCode1800.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        System.out.println(leetCode1800.maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        System.out.println(leetCode1800.maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
        System.out.println(leetCode1800.maxAscendingSum(new int[]{100, 10, 1}));
    }
}
