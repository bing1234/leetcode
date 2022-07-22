package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            for (int[] point : points) {
                if (inCircle(queries[i], point)) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }

    private boolean inCircle(int[] query, int[] point) {
        int x = query[0] - point[0];
        int y = query[1] - point[1];
        return x * x + y * y <= query[2] * query[2];
    }

    public static void main(String[] args) {
        LeetCode1828 leetCode1828 = new LeetCode1828();
        System.out.println(Arrays.toString(leetCode1828.countPoints(new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}}, new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}})));
        System.out.println(Arrays.toString(leetCode1828.countPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}, new int[][]{{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}})));
    }
}
