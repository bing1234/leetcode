package com.geekbing.middle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bing
 */
public class LeetCode1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int max = 0;
        for (int i = 1; i < points.length; i++) {
            max = Math.max(max, points[i][0] - points[i - 1][0]);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode1637 leetCode1637 = new LeetCode1637();
        System.out.println(leetCode1637.maxWidthOfVerticalArea(new int[][]{{8, 7}, {9, 9}, {7, 4}, {9, 7}}));
        System.out.println(leetCode1637.maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
    }
}
