package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1502 leetCode1502 = new LeetCode1502();
        System.out.println(leetCode1502.canMakeArithmeticProgression(new int[]{3, 5, 1}));
        System.out.println(leetCode1502.canMakeArithmeticProgression(new int[]{1, 2, 4}));
    }
}
