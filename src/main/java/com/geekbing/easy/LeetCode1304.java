package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1304 {
    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[]{0};
        }

        int[] result = new int[n];
        for (int i = 0; i < n / 2; i++) {
            result[i] = i + 1;
            result[n / 2 + i] = -(i + 1);
        }
        if (n % 2 != 0) {
            result[n - 1] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1304 leetCode1304 = new LeetCode1304();

        System.out.println(Arrays.toString(leetCode1304.sumZero(6)));
        System.out.println(Arrays.toString(leetCode1304.sumZero(5)));
        System.out.println(Arrays.toString(leetCode1304.sumZero(4)));
        System.out.println(Arrays.toString(leetCode1304.sumZero(3)));
        System.out.println(Arrays.toString(leetCode1304.sumZero(2)));
        System.out.println(Arrays.toString(leetCode1304.sumZero(1)));
    }
}
