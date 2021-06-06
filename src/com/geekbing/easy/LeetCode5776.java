package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode5776 {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (same(mat, target)) {
                return true;
            }
            // 旋转90度
            rotate(mat);
        }
        return false;
    }

    private void rotate(int[][] matrix) {
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

    private boolean same(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode5776 leetCode5776 = new LeetCode5776();

        System.out.println(leetCode5776.findRotation(new int[][]{{0, 1}, {1, 0}}, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(leetCode5776.findRotation(new int[][]{{0, 1}, {1, 1}}, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(leetCode5776.findRotation(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(leetCode5776.findRotation(new int[][]{{1, 1}, {0, 1}}, new int[][]{{1, 1}, {1, 0}}));
    }
}
