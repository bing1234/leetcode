package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1559 {
    public boolean containsCycle(char[][] grid) {
        UnionFind unionFind = new UnionFind(grid);
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 左右合并
                if (j + 1 < col && grid[i][j] == grid[i][j + 1]) {
                    if (unionFind.union(i * col + j, i * col + j + 1)) {
                        return true;
                    }
                }
                // 上下合并
                if (i + 1 < row && grid[i][j] == grid[i + 1][j]) {
                    if (unionFind.union(i * col + j, (i + 1) * col + j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            parent = new int[row * col];
            weight = new int[row * col];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        private int find(int i) {
            return i == parent[i] ? i : find(parent[i]);
        }

        private boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return true;
            }
            if (weight[rootI] < weight[rootJ]) {
                parent[rootI] = rootJ;
                weight[rootJ] += weight[rootI];
            } else {
                parent[rootJ] = rootI;
                weight[rootI] += weight[rootJ];
            }
            return false;
        }
    }

    @Test
    public void testCase1() {
        LeetCode1559 leetCode1559 = new LeetCode1559();
        char[][] grid = {
                {'a', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a'}
        };
        assert leetCode1559.containsCycle(grid);
    }

    @Test
    public void testCase2() {
        LeetCode1559 leetCode1559 = new LeetCode1559();
        char[][] grid = {
                {'c', 'c', 'c', 'a'},
                {'c', 'd', 'c', 'c'},
                {'c', 'c', 'e', 'c'},
                {'f', 'c', 'c', 'c'}
        };
        assert leetCode1559.containsCycle(grid);
    }

    @Test
    public void testCase3() {
        LeetCode1559 leetCode1559 = new LeetCode1559();
        char[][] grid = {
                {'a', 'b', 'b'},
                {'b', 'z', 'b'},
                {'b', 'b', 'a'}
        };
        assert !leetCode1559.containsCycle(grid);
    }
}
