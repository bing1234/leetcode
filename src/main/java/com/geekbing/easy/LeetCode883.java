package com.geekbing.easy;

public class LeetCode883 {
    public int projectionArea(int[][] grid) {
        int ans = 0;
        for (int[] nums : grid) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
                if (num != 0) {
                    ans++;
                }
            }
            ans += max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : grid) {
                max = Math.max(max, ints[i]);
            }
            ans += max;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode883 leetCode883 = new LeetCode883();
        System.out.println(leetCode883.projectionArea(new int[][]{{2}}));
        System.out.println(leetCode883.projectionArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(leetCode883.projectionArea(new int[][]{{1, 0}, {0, 2}}));
        System.out.println(leetCode883.projectionArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        System.out.println(leetCode883.projectionArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
