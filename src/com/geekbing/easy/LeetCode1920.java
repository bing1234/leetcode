package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1920 {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1920 leetCode1920 = new LeetCode1920();

        System.out.println(Arrays.toString(leetCode1920.buildArray(new int[]{0, 2, 1, 5, 3, 4})));
        System.out.println(Arrays.toString(leetCode1920.buildArray(new int[]{5, 0, 1, 2, 3, 4})));
    }
}
