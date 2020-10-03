package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        // 求每行最小值所在的列
        int[] minCols = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int col = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    col = j;
                }
            }
            minCols[i] = col;
        }

        // 求每列最大值所在的行
        int[] maxRows = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int max = Integer.MIN_VALUE;
            int row = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    row = i;
                }
            }
            maxRows[j] = row;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < minCols.length; i++) {
            if (maxRows[minCols[i]] == i) {
                ans.add(matrix[i][minCols[i]]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1380 leetCode1380 = new LeetCode1380();
        int[][] case1 = new int[3][3];
        case1[0] = new int[]{3, 7, 8};
        case1[1] = new int[]{9, 11, 13};
        case1[2] = new int[]{15, 16, 17};
        System.out.println(leetCode1380.luckyNumbers(case1));

        int[][] case2 = new int[3][4];
        case2[0] = new int[]{1, 10, 4, 2};
        case2[1] = new int[]{9, 3, 8, 7};
        case2[2] = new int[]{15, 16, 17, 12};
        System.out.println(leetCode1380.luckyNumbers(case2));

        int[][] case3 = new int[2][2];
        case3[0] = new int[]{7, 8};
        case3[1] = new int[]{1, 2};
        System.out.println(leetCode1380.luckyNumbers(case3));
    }
}
