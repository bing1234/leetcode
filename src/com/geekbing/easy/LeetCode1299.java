package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1299 {
    public int[] replaceElements(int[] arr) {
        int rightMax = 0;
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = rightMax;

            if (temp > rightMax) {
                rightMax = temp;
            }
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    public static void main(String[] args) {
        LeetCode1299 leetCode1299 = new LeetCode1299();
        System.out.println(Arrays.toString(leetCode1299.replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }
}
