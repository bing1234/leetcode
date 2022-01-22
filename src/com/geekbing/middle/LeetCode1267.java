package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1267 {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            int first = 0;
            while (first < col && grid[i][first] == 0) {
                first++;
            }
            for (int j = first + 1; j < col; j++) {
                if (grid[i][j] == 1) {
                    unionFind.union(i * col + first, i * col + j);
                }
            }
        }
        for (int j = 0; j < col; j++) {
            int first = 0;
            while (first < row && grid[first][j] == 0) {
                first++;
            }
            for (int i = first + 1; i < row; i++) {
                if (grid[i][j] == 1) {
                    unionFind.union(first * col + j, i * col + j);
                }
            }
        }
        int ans = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int idx = i * col + j;
                    int p = unionFind.find(idx);
                    if (!used.contains(p) && unionFind.weight[p] > 1) {
                        ans += unionFind.weight[p];
                        used.add(p);
                    }
                }
            }
        }
        return ans;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            this.parent = new int[row * col];
            this.weight = new int[row * col];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int idx = i * col + j;
                    if (grid[i][j] == 1) {
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
        LeetCode1267 leetCode1267 = new LeetCode1267();
        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        assert leetCode1267.countServers(grid) == 0;
    }

    @Test
    public void testCase2() {
        LeetCode1267 leetCode1267 = new LeetCode1267();
        int[][] grid = new int[][]{{1, 0}, {1, 1}};
        assert leetCode1267.countServers(grid) == 3;
    }

    @Test
    public void testCase3() {
        LeetCode1267 leetCode1267 = new LeetCode1267();
        int[][] grid = new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        assert leetCode1267.countServers(grid) == 4;
    }
}
