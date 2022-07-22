package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }
        int[][] ans = new int[r][c];

        int row1 = 0, col1 = 0;
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                ans[row][col] = nums[row1][col1];
                if (col1 == nums[0].length - 1) {
                    col1 = 0;
                    row1++;
                } else {
                    col1++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode566 leetCode566 = new LeetCode566();
        System.out.println(Arrays.deepToString(leetCode566.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
        System.out.println(Arrays.deepToString(leetCode566.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4)));
    }
}
