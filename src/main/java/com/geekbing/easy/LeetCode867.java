package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode867 {
    public int[][] transpose(int[][] A) {
        int[][] ans = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode867 leetCode867 = new LeetCode867();
        System.out.println(Arrays.deepToString(leetCode867.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.deepToString(leetCode867.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }
}
