package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode5613 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = Arrays.stream(account).sum();
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode5613 leetCode5613 = new LeetCode5613();
        System.out.println(leetCode5613.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        System.out.println(leetCode5613.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
        System.out.println(leetCode5613.maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }
}
