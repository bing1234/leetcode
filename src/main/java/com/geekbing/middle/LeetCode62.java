package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            nums[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LeetCode62 leetCode62 = new LeetCode62();
        System.out.println(leetCode62.uniquePaths(3, 2));
        System.out.println(leetCode62.uniquePaths(7, 3));
        System.out.println(leetCode62.uniquePaths(51, 9));
    }
}
