package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode892 {
    public int surfaceArea(int[][] grid) {
        // 非接触面积
        int nonContactArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 上
                nonContactArea += getNonContactArea(grid, i, j, i - 1, j);
                // 下
                nonContactArea += getNonContactArea(grid, i, j, i + 1, j);
                // 左
                nonContactArea += getNonContactArea(grid, i, j, i, j - 1);
                // 右
                nonContactArea += getNonContactArea(grid, i, j, i, j + 1);
                // 顶
                if (grid[i][j] != 0) {
                    nonContactArea += 1;
                }
                // 底
                if (grid[i][j] != 0) {
                    nonContactArea += 1;
                }
            }
        }
        return nonContactArea;
    }

    private int getNonContactArea(int[][] grid, int i1, int j1, int i2, int j2) {
        if (grid[i1][j1] == 0) {
            return 0;
        }
        // 不相连
        if (i2 < 0 || i2 >= grid.length || j2 < 0 || j2 >= grid[0].length) {
            return grid[i1][j1];
        }
        if (grid[i2][j2] == 0) {
            return grid[i1][j1];
        }
        if (grid[i1][j1] < grid[i2][j2]) {
            return 0;
        }
        return grid[i1][j1] - grid[i2][j2];
    }

    public static void main(String[] args) {
        LeetCode892 leetCode892 = new LeetCode892();
        System.out.println(leetCode892.surfaceArea(new int[][]{{2}}));
        System.out.println(leetCode892.surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(leetCode892.surfaceArea(new int[][]{{1, 0}, {0, 2}}));
        System.out.println(leetCode892.surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        System.out.println(leetCode892.surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
