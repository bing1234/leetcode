package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode289 {
    public void gameOfLife(int[][] board) {
        int[][] arr = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Pair pair = getCeil(board, i, j);
                if (board[i][j] == 1) {
                    if (pair.alive < 2) {
                        // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                        arr[i][j] = 0;
                    } else if (pair.alive == 2 || pair.alive == 3) {
                        // 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                        arr[i][j] = 1;
                    } else {
                        // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                        arr[i][j] = 0;
                    }
                } else {
                    // 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    if (pair.alive == 3) {
                        arr[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(arr[i], 0, board[i], 0, board[i].length);
        }
    }

    private Pair getCeil(int[][] board, int i, int j) {
        Pair pair = new Pair();
        int alive = 0, dead = 0;
        int[] step = new int[]{-1, 0, 1};
        for (int m : step) {
            for (int n : step) {
                if (m == 0 && n == 0) {
                    continue;
                }
                if (0 <= i + m && i + m < board.length && 0 <= j + n && j + n < board[0].length) {
                    if (board[i + m][j + n] == 1) {
                        alive++;
                    } else {
                        dead++;
                    }
                }
            }
        }
        pair.setAlive(alive);
        pair.setDead(dead);
        return pair;
    }

    private static class Pair {
        private int alive;
        private int dead;

        public int getAlive() {
            return alive;
        }

        public void setAlive(int alive) {
            this.alive = alive;
        }

        public int getDead() {
            return dead;
        }

        public void setDead(int dead) {
            this.dead = dead;
        }
    }

    public static void main(String[] args) {
        LeetCode289 leetCode289 = new LeetCode289();

        int[][] board1 = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        leetCode289.gameOfLife(board1);
        System.out.println(Arrays.deepToString(board1));

        int[][] board2 = new int[][]{{1, 1}, {1, 0}};
        leetCode289.gameOfLife(board2);
        System.out.println(Arrays.deepToString(board2));
    }
}
