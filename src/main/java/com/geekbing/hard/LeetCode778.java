package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode778 {
    public int swimInWater(int[][] grid) {
        int row = grid.length, col = grid[0].length, start = 0, end = row * col - 1;
        UnionFind unionFind = new UnionFind(grid);
        int min = Math.max(grid[0][0], grid[row - 1][col - 1]);
        while (true) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // 上下合并
                    if (grid[i][j] <= min && i + 1 < row && grid[i + 1][j] <= min) {
                        unionFind.union(i * col + j, (i + 1) * col + j);
                    }
                    // 左右合并
                    if (grid[i][j] <= min && j + 1 < col && grid[i][j + 1] <= min) {
                        unionFind.union(i * col + j, i * col + j + 1);
                    }
                }
            }
            if (unionFind.connect(start, end)) {
                return min;
            }
            min++;
        }
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            parent = new int[row * col];
            weight = new int[row * col];
            Arrays.fill(weight, 1);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int idx = i * row + j;
                    parent[idx] = idx;
                }
            }
        }

        private boolean connect(int x, int y) {
            return find(x) == find(y);
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
        LeetCode778 leetCode778 = new LeetCode778();
        int ans = leetCode778.swimInWater(new int[][]{{0, 2}, {1, 3}});
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode778 leetCode778 = new LeetCode778();
        int ans = leetCode778.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}});
        assert ans == 16;
    }
}
