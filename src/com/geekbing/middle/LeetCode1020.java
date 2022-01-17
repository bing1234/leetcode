package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1020 {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j + 1 < col && grid[i][j] == 1 && grid[i][j + 1] == 1) {
                    unionFind.union(i * col + j, i * col + j + 1);
                }
                if (i + 1 < row && grid[i][j] == 1 && grid[i + 1][j] == 1) {
                    unionFind.union(i * col + j, (i + 1) * col + j);
                }
            }
        }

        int ans = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int idx = i * col + j;
                    int p = unionFind.find(idx);
                    if (!used.contains(p)) {
                        ans += unionFind.weight[p];
                        used.add(p);
                    }
                }
            }
        }
        Set<Integer> deleted = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                int idx = i * col;
                int p = unionFind.find(idx);
                if (!deleted.contains(p)) {
                    ans -= unionFind.weight[p];
                    deleted.add(p);
                }
            }
            if (grid[i][col - 1] == 1) {
                int idx = i * col + (col - 1);
                int p = unionFind.find(idx);
                if (!deleted.contains(p)) {
                    ans -= unionFind.weight[p];
                    deleted.add(p);
                }
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 1) {
                int p = unionFind.find(j);
                if (!deleted.contains(p)) {
                    ans -= unionFind.weight[p];
                    deleted.add(p);
                }
            }
            if (grid[row - 1][j] == 1) {
                int idx = (row - 1) * col + j;
                int p = unionFind.find(idx);
                if (!deleted.contains(p)) {
                    ans -= unionFind.weight[p];
                    deleted.add(p);
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
                    if (grid[i][j] == 1) {
                        weight[i * col + j] = 1;
                    } else {
                        weight[i * col + j] = 0;
                    }
                }
            }
        }

        private int find(int x) {
            return x == parent[x] ? x : find(parent[x]);
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
        LeetCode1020 leetCode1020 = new LeetCode1020();
        int[][] grid = new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        assert leetCode1020.numEnclaves(grid) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1020 leetCode1020 = new LeetCode1020();
        int[][] grid = new int[][]{
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        assert leetCode1020.numEnclaves(grid) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode1020 leetCode1020 = new LeetCode1020();
        int[][] grid = new int[][]{
                {0},
                {1},
                {1},
                {0},
                {0}
        };
        assert leetCode1020.numEnclaves(grid) == 0;
    }

    @Test
    public void testCase4() {
        LeetCode1020 leetCode1020 = new LeetCode1020();
        int[][] grid = new int[][]{
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1}
        };
        int ans = leetCode1020.numEnclaves(grid);
        System.out.println(ans);
        assert ans == 7;
    }
}
