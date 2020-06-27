package com.geekbing.easy;

import java.util.Arrays;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode1470 {
    public int[] shuffle(int[] nums, int n) {
        int temp;
        for (int i = 1; i < n; i = i + 2) {

        }
        return new int[]{};
    }

    public static void main(String[] args) {
        LeetCode1470 leetCode1470 = new LeetCode1470();
        System.out.println(Arrays.toString(leetCode1470.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(leetCode1470.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
        System.out.println(Arrays.toString(leetCode1470.shuffle(new int[]{1, 1, 2, 2}, 2)));
    }
}
