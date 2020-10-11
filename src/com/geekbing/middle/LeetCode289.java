package com.geekbing.middle;

import java.util.Arrays;

public class LeetCode289 {
    public void gameOfLife(int[][] board) {

    }

    public static void main(String[] args) {
        LeetCode289 leetCode289 = new LeetCode289();

        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        leetCode289.gameOfLife(board);
        System.out.println(Arrays.toString(board));
    }
}
