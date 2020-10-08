package com.geekbing.easy;

public class LeetCode812 {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    private double area(int[] p1, int[] p2, int[] p3) {
        return 0.5 * Math.abs(p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1]
                - p1[1] * p2[0] - p2[1] * p3[0] - p3[1] * p1[0]);
    }

    public static void main(String[] args) {
        LeetCode812 leetCode812 = new LeetCode812();
        System.out.println(leetCode812.largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
    }
}
