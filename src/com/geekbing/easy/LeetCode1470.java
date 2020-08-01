package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            // 先放x
            result[index++] = nums[i];
            // 再放y
            result[index++] = nums[n + i];
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1470 leetCode1470 = new LeetCode1470();
        System.out.println(Arrays.toString(leetCode1470.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(leetCode1470.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
        System.out.println(Arrays.toString(leetCode1470.shuffle(new int[]{1, 1, 2, 2}, 2)));
    }
}
