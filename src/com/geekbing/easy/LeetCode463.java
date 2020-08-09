package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode463 {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result = result + 4;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        result = result - 2;
                    }
                    if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                        result = result - 2;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode463 leetCode463 = new LeetCode463();

        int[][] case1 = new int[4][4];
        case1[0] = new int[]{0, 1, 0, 0};
        case1[1] = new int[]{1, 1, 1, 0};
        case1[2] = new int[]{0, 1, 0, 0};
        case1[3] = new int[]{1, 1, 0, 0};
        System.out.println(leetCode463.islandPerimeter(case1));

        int[][] case2 = new int[1][2];
        case2[0] = new int[]{1, 1};
        System.out.println(leetCode463.islandPerimeter(case2));
    }
}
