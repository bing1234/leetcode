package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode908 {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : A) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int result = max - min - 2 * K;
        return Math.max(result, 0);
    }

    public static void main(String[] args) {
        LeetCode908 leetCode908 = new LeetCode908();
        System.out.println(leetCode908.smallestRangeI(new int[]{1}, 0));
        System.out.println(leetCode908.smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(leetCode908.smallestRangeI(new int[]{1, 3, 6}, 3));
    }
}
