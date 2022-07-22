package com.geekbing.hard;

public class LeetCode37 {
    public void solveSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i / 3][j / 3][num] = true;
                }
            }
        }
        backtrack(board, rowUsed, colUsed, boxUsed, 0, 0);
    }

    private boolean backtrack(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col) {
        // 边界检查
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) {
                return true;
            }
        }
        if (board[row][col] != '.') {
            return backtrack(board, rowUsed, colUsed, boxUsed, row, col + 1);
        }
        // 尝试填充1~9
        for (int num = 1; num <= 9; num++) {
            boolean canUse = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row / 3][col / 3][num]);
            if (canUse) {
                rowUsed[row][num] = true;
                colUsed[col][num] = true;
                boxUsed[row / 3][col / 3][num] = true;
                board[row][col] = (char) ('0' + num);

                if (backtrack(board, rowUsed, colUsed, boxUsed, row, col + 1)) {
                    return true;
                } else {
                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row / 3][col / 3][num] = false;
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode37 leetCode37 = new LeetCode37();
        char[][] board = new char[9][9];
        leetCode37.solveSudoku(board);
    }
}
