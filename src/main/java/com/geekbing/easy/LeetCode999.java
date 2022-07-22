package com.geekbing.easy;

/**
 * https://leetcode-cn.com/problems/available-captures-for-rook/submissions/
 * 999. 可以被一步捕获的棋子数
 *
 * @author bing
 */
public class LeetCode999 {
    public int numRookCaptures(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    // 上
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == 'p') {
                            ans++;
                            break;
                        } else if (board[k][j] == 'B') {
                            break;
                        }
                    }
                    // 下
                    for (int k = i + 1; k < board.length; k++) {
                        if (board[k][j] == 'p') {
                            ans++;
                            break;
                        } else if (board[k][j] == 'B') {
                            break;
                        }
                    }
                    // 左
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == 'p') {
                            ans++;
                            break;
                        } else if (board[i][k] == 'B') {
                            break;
                        }
                    }
                    // 右
                    for (int k = j + 1; k < board[i].length; k++) {
                        if (board[i][k] == 'p') {
                            ans++;
                            break;
                        } else if (board[i][k] == 'B') {
                            break;
                        }
                    }
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode999 leetCode999 = new LeetCode999();
        System.out.println(leetCode999.numRookCaptures(new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}}));
        System.out.println(leetCode999.numRookCaptures(new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'}, {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'}, {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'}, {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'}, {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}}));
        System.out.println(leetCode999.numRookCaptures(new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'p', 'p', '.', 'R', '.', 'p', 'B', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'B', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}}));
    }
}
