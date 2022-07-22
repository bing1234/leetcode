package com.geekbing.easy;

/**
 * https://leetcode-cn.com/problems/valid-mountain-array/
 * 941. 有效的山脉数组
 *
 * @author bing
 */
public class LeetCode941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int i = 0;
        while (i < A.length - 1 && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == A.length - 1) {
            return false;
        }
        while (i < A.length - 1 && A[i] > A[i + 1]) {
            i++;
        }
        return i == A.length - 1;
    }

    public static void main(String[] args) {
        LeetCode941 leetCode941 = new LeetCode941();
        System.out.println(leetCode941.validMountainArray(new int[]{2, 1}));
        System.out.println(leetCode941.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(leetCode941.validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(leetCode941.validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
