package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode73 {
    public void setZeroes(int[][] matrix) {

    }

    public static void main(String[] args) {
        LeetCode73 leetCode73 = new LeetCode73();

        int[][] matrix1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        leetCode73.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        leetCode73.setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }
}
