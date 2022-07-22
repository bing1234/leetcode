package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int num : nums) {
            if (num == 0) {
                current = 0;
            } else {
                current = current + 1;
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode485 leetCode485 = new LeetCode485();
        System.out.println(leetCode485.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
