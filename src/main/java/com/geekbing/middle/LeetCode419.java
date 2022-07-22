package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode419 {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        UnionFind unionFind = new UnionFind(board);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j + 1 < col && board[i][j] == 'X' && board[i][j + 1] == 'X') {
                    unionFind.union(i * col + j, i * col + j + 1);
                }
                if (i + 1 < row && board[i][j] == 'X' && board[i + 1][j] == 'X') {
                    unionFind.union(i * col + j, (i + 1) * col + j);
                }
            }
        }

        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') {
                    roots.add(unionFind.find(i * col + j));
                }
            }
        }
        return roots.size();
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(char[][] board) {
            int row = board.length;
            int col = board[0].length;
            parent = new int[row * col];
            weight = new int[row * col];

            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'X') {
                        weight[i * col + j] = 1;
                    }
                }
            }
        }

        private int find(int x) {
            return x == parent[x] ? x : find(parent[x]);
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (weight[rootX] < weight[rootY]) {
                    parent[rootX] = rootY;
                    weight[rootY] += weight[rootX];
                } else {
                    parent[rootY] = rootX;
                    weight[rootX] += weight[rootY];
                }
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode419 leetCode419 = new LeetCode419();
        int ans = leetCode419.countBattleships(new char[][]{
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        });
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        LeetCode419 leetCode419 = new LeetCode419();
        int ans = leetCode419.countBattleships(new char[][]{
                {'.'}
        });
        assert ans == 0;
    }
}
