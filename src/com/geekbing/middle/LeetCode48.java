package com.geekbing.middle;

import java.util.Arrays;

public class LeetCode48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 左右翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

        // 右上至左下对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode48 leetCode48 = new LeetCode48();
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        leetCode48.rotate(arr1);
        System.out.println(Arrays.deepToString(arr1));

        int[][] arr2 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        leetCode48.rotate(arr2);
        System.out.println(Arrays.deepToString(arr2));
    }
}
