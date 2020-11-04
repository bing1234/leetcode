package com.geekbing.middle;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 240. 搜索二维矩阵 II
 *
 * @author bing
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        // 从右上角开始搜索
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] == target) {
                return true;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode240 leetCode240 = new LeetCode240();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(leetCode240.searchMatrix(matrix, 5));
        System.out.println(leetCode240.searchMatrix(matrix, 20));
    }
}
