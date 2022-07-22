package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }
        int minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        return minRow * minCol;
    }

    public static void main(String[] args) {
        LeetCode598 leetCode598 = new LeetCode598();
        System.out.println(leetCode598.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}));
        System.out.println(leetCode598.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}}));
    }
}
