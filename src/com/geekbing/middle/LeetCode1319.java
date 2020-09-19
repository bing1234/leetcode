package com.geekbing.middle;

public class LeetCode1319 {
    public int makeConnected(int n, int[][] connections) {
        return 0;
    }

    public static void main(String[] args) {
        LeetCode1319 leetCode1319 = new LeetCode1319();
        System.out.println(leetCode1319.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(leetCode1319.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
        System.out.println(leetCode1319.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));
        System.out.println(leetCode1319.makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));
    }
}
