package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode977 {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        // 全部是正数
        if (A[0] >= 0) {
            for (int i = 0; i < A.length; i++) {
                ans[i] = A[i] * A[i];
            }
            return ans;
        }
        // 全部是负数
        if (A[A.length - 1] <= 0) {
            for (int i = 0; i < A.length; i++) {
                ans[i] = A[A.length - i - 1] * A[A.length - i - 1];
            }
            return ans;
        }
        // 找到绝对值最小的元素
        int absMinIndex = 0, absMinVal = Math.abs(A[0]);
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i]) < absMinVal) {
                absMinVal = Math.abs(A[i]);
                absMinIndex = i;
            }
        }

        int index = 0, left = absMinIndex, right = absMinIndex + 1, leftPower, rightPower;
        while (left >= 0 || right < A.length) {
            leftPower = left < 0 ? Integer.MAX_VALUE : A[left] * A[left];
            rightPower = right >= A.length ? Integer.MAX_VALUE : A[right] * A[right];
            if (leftPower < rightPower) {
                ans[index++] = leftPower;
                left--;
            } else {
                ans[index++] = rightPower;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode977 leetCode977 = new LeetCode977();
        System.out.println(Arrays.toString(leetCode977.sortedSquares(new int[]{-3, -3, -2, 1})));
        System.out.println(Arrays.toString(leetCode977.sortedSquares(new int[]{-2, 0})));
        System.out.println(Arrays.toString(leetCode977.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(leetCode977.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
}
