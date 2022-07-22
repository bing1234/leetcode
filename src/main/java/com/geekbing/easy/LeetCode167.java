package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left != right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        LeetCode167 leetCode167 = new LeetCode167();
        System.out.println(Arrays.toString(leetCode167.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
