package com.geekbing.easy;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode1351 {
    public int countNegatives(int[][] grid) {
        return 0;
    }

    public static void main(String[] args) {
        LeetCode1351 leetCode1351 = new LeetCode1351();

        int[][] grid1 = new int[3][4];
        grid1[0] = new int[]{4, 3, 2, -1};
        grid1[1] = new int[]{3, 2, 1, -1};
        grid1[2] = new int[]{1, 1, -1, -2};
        System.out.println(leetCode1351.countNegatives(grid1));

        int[][] grid2 = new int[2][2];
        grid2[0] = new int[]{3, 2};
        grid2[1] = new int[]{1, 0};
        System.out.println(leetCode1351.countNegatives(grid2));

        int[][] grid3 = new int[2][2];
        grid3[0] = new int[]{1, -1};
        grid3[1] = new int[]{-1, -1};
        System.out.println(leetCode1351.countNegatives(grid3));

        int[][] grid4 = new int[1][1];
        grid4[0] = new int[]{-1};
        System.out.println(leetCode1351.countNegatives(grid4));
    }
}
