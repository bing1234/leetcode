package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode661 {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length, col = M[0].length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                ans[i][j] = calAverage(M, i, j);
            }
        }
        return ans;
    }

    private int calAverage(int[][] M, int i, int j) {
        int num = 0, total = 0, row = M.length, col = M[0].length;

        int[][] points = new int[9][2];
        points[0] = new int[]{i - 1, j - 1};
        points[1] = new int[]{i - 1, j};
        points[2] = new int[]{i - 1, j + 1};
        points[3] = new int[]{i, j - 1};
        points[4] = new int[]{i, j};
        points[5] = new int[]{i, j + 1};
        points[6] = new int[]{i + 1, j - 1};
        points[7] = new int[]{i + 1, j};
        points[8] = new int[]{i + 1, j + 1};

        for (int[] point : points) {
            if (0 <= point[0] && point[0] <= row - 1 && 0 <= point[1] && point[1] <= col - 1) {
                total += M[point[0]][point[1]];
                num++;
            }
        }
        return total / num;
    }

    public static void main(String[] args) {
        LeetCode661 leetCode661 = new LeetCode661();
        System.out.println(Arrays.deepToString(leetCode661.imageSmoother(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})));
    }
}
