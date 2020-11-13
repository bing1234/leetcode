package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode922 {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1;
        while (i < A.length && j < A.length) {
            while (i < A.length && A[i] % 2 == 0) {
                i += 2;
            }
            while (j < A.length && A[j] % 2 == 1) {
                j += 2;
            }
            if (i < A.length && j < A.length) {
                swap(A, i, j);
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        LeetCode922 leetCode922 = new LeetCode922();
        System.out.println(Arrays.toString(leetCode922.sortArrayByParityII(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(leetCode922.sortArrayByParityII(new int[]{})));
    }
}
