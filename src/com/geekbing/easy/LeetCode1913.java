package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1913 {
    public int maxProductDifference(int[] nums) {
        int[] firstFour = Arrays.copyOf(nums, 4);
        Arrays.sort(firstFour);
        // 最小、第二小、第二大、最大
        int min = firstFour[0], minSecond = firstFour[1], maxSecond = firstFour[2], max = firstFour[3];

        for (int i = 4; i < nums.length; i++) {
            if (nums[i] >= max) {
                maxSecond = max;
                max = nums[i];
            } else if (nums[i] > maxSecond) {
                maxSecond = nums[i];
            }
            if (nums[i] <= min) {
                minSecond = min;
                min = nums[i];
            } else if (nums[i] < minSecond) {
                minSecond = nums[i];
            }
        }
        return max * maxSecond - min * minSecond;
    }

    public static void main(String[] args) {
        LeetCode1913 leetCode1913 = new LeetCode1913();

        System.out.println(leetCode1913.maxProductDifference(new int[]{5, 6, 2, 7, 4}));
        System.out.println(leetCode1913.maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8}));
    }
}
