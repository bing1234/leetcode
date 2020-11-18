package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        int idx = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[idx++] = new int[]{i, j};
            }
        }
        Arrays.sort(ans, (o1, o2) -> Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) - Math.abs(o2[0] - r0) - Math.abs(o2[1] - c0));
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1030 leetCode1030 = new LeetCode1030();
        System.out.println(Arrays.deepToString(leetCode1030.allCellsDistOrder(1, 2, 0, 0)));
        System.out.println(Arrays.deepToString(leetCode1030.allCellsDistOrder(2, 2, 0, 1)));
        System.out.println(Arrays.deepToString(leetCode1030.allCellsDistOrder(2, 3, 1, 2)));
    }
}
