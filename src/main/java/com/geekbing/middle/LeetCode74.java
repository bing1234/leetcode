package com.geekbing.middle;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 74. 搜索二维矩阵
 *
 * @author bing
 */
public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;
        int x, y;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid + 1) % col == 0) {
                x = (mid + 1) / col - 1;
                y = col - 1;
            } else {
                x = (mid + 1) / col;
                y = mid - x * col;
            }
            if (matrix[x][y] < target) {
                left = mid + 1;
            } else if (matrix[x][y] == target) {
                return true;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode74 leetCode74 = new LeetCode74();
        System.out.println(leetCode74.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3));
        System.out.println(leetCode74.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13));
        System.out.println(leetCode74.searchMatrix(new int[][]{}, 0));
        System.out.println(leetCode74.searchMatrix(new int[][]{{1}}, 0));
        System.out.println(leetCode74.searchMatrix(new int[][]{{1}}, 1));
    }
}
