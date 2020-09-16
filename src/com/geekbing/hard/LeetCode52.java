package com.geekbing.hard;

public class LeetCode52 {
    private int ans = 0;

    public int totalNQueens(int n) {
        backtrack(new int[n], 0, n);
        return ans;
    }

    // pos[i]表示第i行的第pos[i]列放置皇后
    private void backtrack(int[] pos, int row, int n) {
        // 边界条件处理
        for (int col = 0; col < n; col++) {
            pos[row] = col;
            if (checkLegal(pos, row)) {
                if (row == n - 1) {
                    ans++;
                } else {
                    backtrack(pos, row + 1, n);
                }
            }
        }
    }

    boolean checkLegal(int[] pos, int row) {
        for (int i = 0; i < row; i++) {
            if (pos[row] == pos[i]
                    || Math.abs(row - i) == Math.abs(pos[row] - pos[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode52 leetCode52 = new LeetCode52();
        System.out.println(leetCode52.totalNQueens(4));
    }
}
