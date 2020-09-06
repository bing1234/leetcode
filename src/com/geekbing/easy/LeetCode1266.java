package com.geekbing.easy;

public class LeetCode1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int min = 0;
        for (int i = 1; i < points.length; i++) {
            min += Math.max(Math.abs(points[i - 1][0] - points[i][0]), Math.abs(points[i - 1][1] - points[i][1]));
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode1266 leetCode1266 = new LeetCode1266();

        int[][] case1 = new int[3][2];
        case1[0] = new int[]{1, 1};
        case1[1] = new int[]{3, 4};
        case1[2] = new int[]{-1, 0};
        System.out.println(leetCode1266.minTimeToVisitAllPoints(case1));

        int[][] case2 = new int[2][2];
        case2[0] = new int[]{3, 2};
        case2[1] = new int[]{-2, 2};
        System.out.println(leetCode1266.minTimeToVisitAllPoints(case2));
    }
}
