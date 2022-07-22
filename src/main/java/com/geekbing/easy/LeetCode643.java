package com.geekbing.easy;

public class LeetCode643 {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE, sum = 0D;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i == k - 1) {
                max = sum / k;
            } else if (i >= k) {
                sum -= nums[i - k];
                if (sum / k > max) {
                    max = sum / k;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode643 leetCode643 = new LeetCode643();
        System.out.println(leetCode643.findMaxAverage(new int[]{5}, 1));
        System.out.println(leetCode643.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
