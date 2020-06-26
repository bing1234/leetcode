package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode136 leetCode136 = new LeetCode136();

        System.out.println(leetCode136.singleNumber(new int[]{2, 2, 1}));
        System.out.println(leetCode136.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
