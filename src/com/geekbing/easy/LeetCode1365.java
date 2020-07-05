package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num] = count[num] + 1;
        }

        int total = 0, temp;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                temp = count[i];
                count[i] = total;
                total = total + temp;
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = count[nums[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1365 leetCode1365 = new LeetCode1365();

        System.out.println(Arrays.toString(leetCode1365.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(leetCode1365.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(leetCode1365.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
        System.out.println(Arrays.toString(leetCode1365.smallerNumbersThanCurrent(new int[]{5, 0, 10, 0, 10, 6})));
    }
}
