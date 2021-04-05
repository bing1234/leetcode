package com.geekbing.easy;

public class LeetCode1275 {
    public String tictactoe(int[][] moves) {
        // 棋盘
        char[][] boards = new char[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                boards[moves[i][0]][moves[i][1]] = 'X';
            } else {
                boards[moves[i][0]][moves[i][1]] = 'O';
            }
        }
        return check(boards, moves.length);
    }

    private String check(char[][] boards, int moves) {
        // 检查行
        for (char[] board : boards) {
            if (allSame(board)) {
                return board[0] == 'X' ? "A" : "B";
            }
        }

        // 检查列
        char[] board = new char[boards.length];
        for (int i = 0; i < boards[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[j] = boards[j][i];
            }
            if (allSame(board)) {
                return board[0] == 'X' ? "A" : "B";
            }
        }

        // 检查对角线
        board[0] = boards[0][0];
        board[1] = boards[1][1];
        board[2] = boards[2][2];
        if (allSame(board)) {
            return board[0] == 'X' ? "A" : "B";
        }

        board[0] = boards[0][2];
        board[1] = boards[1][1];
        board[2] = boards[2][0];
        if (allSame(board)) {
            return board[0] == 'X' ? "A" : "B";
        }

        // 检查是否都下满了
        return moves == 9 ? "Draw" : "Pending";
    }

    private boolean allSame(char[] lines) {
        return (lines[0] == 'X' || lines[0] == 'O') && lines[0] == lines[1] && lines[1] == lines[2];
    }

    public static void main(String[] args) {
        LeetCode1275 leetCode1275 = new LeetCode1275();
        System.out.println(leetCode1275.tictactoe(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}}));
        System.out.println(leetCode1275.tictactoe(new int[][]{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}}));
        System.out.println(leetCode1275.tictactoe(new int[][]{{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}}));
        System.out.println(leetCode1275.tictactoe(new int[][]{{0, 0}, {1, 1}}));
    }
}
