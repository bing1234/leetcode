package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode628 {
    public int maximumProduct(int[] nums) {
        // 找到最大的三个数
        int[] maxs = findMaxThreeNums(nums);
        // 找到最小的两个数
        int[] mins = findMinTwoNums(nums);
        // 乘积最大只可能是最大的三个数相乘 或 最小的两个数与最大的数相乘(有负数的情况)
        return Math.max(maxs[0] * maxs[1] * maxs[2], mins[0] * mins[1] * maxs[0]);
    }

    private int[] findMaxThreeNums(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }
        }
        return new int[]{max1, max2, max3};
    }

    private int[] findMinTwoNums(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
        }
        return new int[]{min1, min2};
    }

    public static void main(String[] args) {
        LeetCode628 leetCode628 = new LeetCode628();
        System.out.println(leetCode628.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(leetCode628.maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(leetCode628.maximumProduct(new int[]{7, 3, 1, 0, 0, 6}));
    }
}
