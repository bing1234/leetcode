package com.geekbing.easy;

public class LeetCode1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0, count = 0, len;
        for (int[] rectangle : rectangles) {
            len = Math.min(rectangle[0], rectangle[1]);
            if (maxLen == len) {
                count++;
            } else if (maxLen < len) {
                maxLen = len;
                count = 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1725 leetCode1725 = new LeetCode1725();
        System.out.println(leetCode1725.countGoodRectangles(new int[][]{{5, 8}, {3, 9}, {5, 12}, {16, 5}}));
        System.out.println(leetCode1725.countGoodRectangles(new int[][]{{2, 3}, {3, 7}, {4, 3}, {3, 7}}));
    }
}
