package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1464 {
    public int maxProduct(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
            } else if (nums[i] == max) {
                second = max;
            } else {
                second = Math.max(nums[i], second);
            }
        }
        return (max - 1) * (second - 1);
    }

    public static void main(String[] args) {
        LeetCode1464 leetCode1464 = new LeetCode1464();
        System.out.println(leetCode1464.maxProduct(new int[]{3, 4, 5, 2}));
        System.out.println(leetCode1464.maxProduct(new int[]{1, 5, 4, 5}));
        System.out.println(leetCode1464.maxProduct(new int[]{3, 7}));
        System.out.println(leetCode1464.maxProduct(new int[]{10, 2, 5, 2}));
    }
}
