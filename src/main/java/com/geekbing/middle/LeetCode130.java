package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode130 {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        UnionFind unionFind = new UnionFind(board);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j + 1 < col && board[i][j] == 'O' && board[i][j + 1] == 'O') {
                    unionFind.union(i * col + j, i * col + j + 1);
                }
                if (i + 1 < row && board[i][j] == 'O' && board[i + 1][j] == 'O') {
                    unionFind.union(i * col + j, (i + 1) * col + j);
                }
            }
        }

        Set<Integer> notRoot = new HashSet<>();
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                int idx = i * col;
                int p = unionFind.find(idx);
                notRoot.add(p);
            }
            if (board[i][col - 1] == 'O') {
                int idx = i * col + col - 1;
                int p = unionFind.find(idx);
                notRoot.add(p);
            }
        }
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                int p = unionFind.find(j);
                notRoot.add(p);
            }
            if (board[row - 1][j] == 'O') {
                int idx = (row - 1) * col + j;
                int p = unionFind.find(idx);
                notRoot.add(p);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    int idx = i * col + j;
                    int p = unionFind.find(idx);
                    if (!notRoot.contains(p)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(char[][] board) {
            int row = board.length;
            int col = board[0].length;
            this.parent = new int[row * col];
            this.weight = new int[row * col];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int idx = i * col + j;
                    if (board[i][j] == 'O') {
                        weight[idx] = 1;
                    } else {
                        weight[idx] = 0;
                    }
                }
            }
        }

        private int find(int i) {
            return i == parent[i] ? i : find(parent[i]);
        }

        private void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (weight[rootI] < weight[rootJ]) {
                    parent[rootI] = rootJ;
                    weight[rootJ] += weight[rootI];
                } else {
                    parent[rootJ] = rootI;
                    weight[rootI] += weight[rootJ];
                }
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode130 leetCode130 = new LeetCode130();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        leetCode130.solve(board);

        char[][] res = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        assert Arrays.deepEquals(board, res);
    }

    @Test
    public void testCase2() {
        LeetCode130 leetCode130 = new LeetCode130();
        char[][] board = new char[][]{{'X'}};
        leetCode130.solve(board);
        char[][] res = new char[][]{{'X'}};
        assert Arrays.deepEquals(board, res);
    }
}
