package com.geekbing.middle;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int ans = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                ans++;
                right = points[i][1];
            } else {
                if (points[i][1] < right) {
                    right = points[i][1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode452 leetCode452 = new LeetCode452();
        System.out.println(leetCode452.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
