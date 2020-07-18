package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        int carryBit = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carryBit + digits[i] >= 10) {
                digits[i] = carryBit + digits[i] - 10;
                carryBit = 1;
            } else {
                digits[i] = carryBit + digits[i];
                carryBit = 0;
            }
            if (carryBit == 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        LeetCode66 leetCode66 = new LeetCode66();
        System.out.println(Arrays.toString(leetCode66.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(leetCode66.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(leetCode66.plusOne(new int[]{4, 3, 2, 1})));
    }
}
