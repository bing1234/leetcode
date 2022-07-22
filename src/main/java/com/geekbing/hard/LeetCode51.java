package com.geekbing.hard;

import java.util.ArrayList;
import java.util.List;

public class LeetCode51 {
    private List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        backtrack(new int[n], 0, n);
        return ans;
    }

    private void backtrack(int[] pos, int row, int n) {
        for (int col = 0; col < n; col++) {
            pos[row] = col;
            if (checkValid(pos, row)) {
                // 边界条件处理
                if (row == n - 1) {
                    ans.add(convertPosToBoard(pos, n));
                } else {
                    backtrack(pos, row + 1, n);
                }
            }
        }
    }

    private boolean checkValid(int[] pos, int row) {
        for (int i = 0; i < row; i++) {
            if (pos[row] == pos[i] || Math.abs(row - i) == Math.abs(pos[row] - pos[i])) {
                return false;
            }
        }
        return true;
    }

    private List<String> convertPosToBoard(int[] pos, int n) {
        List<String> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
            board[row][pos[row]] = 'Q';
            ans.add(new String(board[row]));
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode51 leetCode51 = new LeetCode51();
        System.out.println(leetCode51.solveNQueens(4));
    }
}
