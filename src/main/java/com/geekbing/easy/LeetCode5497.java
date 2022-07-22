package com.geekbing.easy;

public class LeetCode5497 {
    public int diagonalSum(int[][] mat) {
        int sum = 0, len = mat.length;
        for (int i = 0; i < len; i++) {
            sum += mat[i][i];
            sum += mat[len - i - 1][i];
        }
        return len % 2 == 0 ? sum : sum - mat[len / 2][len / 2];
    }

    public static void main(String[] args) {
        LeetCode5497 leetCode5497 = new LeetCode5497();

        int[][] case1 = new int[3][3];
        case1[0] = new int[]{1, 2, 3};
        case1[1] = new int[]{4, 5, 6};
        case1[2] = new int[]{7, 8, 9};
        System.out.println(leetCode5497.diagonalSum(case1));

        int[][] case2 = new int[4][4];
        case2[0] = new int[]{1, 1, 1, 1};
        case2[1] = new int[]{1, 1, 1, 1};
        case2[2] = new int[]{1, 1, 1, 1};
        case2[3] = new int[]{1, 1, 1, 1};
        System.out.println(leetCode5497.diagonalSum(case2));

        int[][] case3 = new int[1][1];
        case3[0] = new int[]{5};
        System.out.println(leetCode5497.diagonalSum(case3));
    }
}
