package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode695 {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j + 1 < col && grid[i][j] == 1 && grid[i][j + 1] == 1) {
                    unionFind.union(unionFind.mapping(i, j, col), unionFind.mapping(i, j + 1, col));
                }
                if (i + 1 < row && grid[i][j] == 1 && grid[i + 1][j] == 1) {
                    unionFind.union(unionFind.mapping(i, j, col), unionFind.mapping(i + 1, j, col));
                }
            }
        }
        return unionFind.maxWeight();
    }

    @Test
    public void testCase1() {
        LeetCode695 leetCode695 = new LeetCode695();
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        assert leetCode695.maxAreaOfIsland(grid) == 6;
    }

    @Test
    public void testCase2() {
        LeetCode695 leetCode695 = new LeetCode695();
        int[][] grid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        assert leetCode695.maxAreaOfIsland(grid) == 0;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int size = row * col;
            parent = new int[size];
            weight = new int[size];
            // 初始化每个人的parent都是自己
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        weight[mapping(i, j, col)] = 1;
                    }
                }
            }
        }

        public int find(int x) {
            return x == parent[x] ? x : find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            int weightX = weight[rootX];
            int weightY = weight[rootY];
            if (weightX <= weightY) {
                parent[rootX] = rootY;
                weight[rootY] += weight[rootX];
            } else {
                parent[rootY] = rootX;
                weight[rootX] += weight[rootY];
            }
        }

        public int mapping(int i, int j, int col) {
            return i * col + j;
        }

        public int maxWeight() {
            return Arrays.stream(weight).max().orElse(0);
        }
    }
}
