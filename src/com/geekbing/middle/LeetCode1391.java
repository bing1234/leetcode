package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1391 {
    private static final Set<Integer> UP = new HashSet<>(Arrays.asList(2, 3, 4));
    private static final Set<Integer> DOWN = new HashSet<>(Arrays.asList(2, 5, 6));
    private static final Set<Integer> LEFT = new HashSet<>(Arrays.asList(1, 4, 6));
    private static final Set<Integer> RIGHT = new HashSet<>(Arrays.asList(1, 3, 5));

    public boolean hasValidPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                switch (grid[i][j]) {
                    case 1:
                        // 1 表示连接左单元格和右单元格的街道
                        unionLeft(i, j, grid, unionFind);
                        unionRight(i, j, grid, unionFind);
                        break;
                    case 2:
                        // 2 表示连接上单元格和下单元格的街道
                        unionUp(i, j, grid, unionFind);
                        unionDown(i, j, grid, unionFind);
                        break;
                    case 3:
                        // 3 表示连接左单元格和下单元格的街道
                        unionLeft(i, j, grid, unionFind);
                        unionDown(i, j, grid, unionFind);
                        break;
                    case 4:
                        // 4 表示连接右单元格和下单元格的街道
                        unionRight(i, j, grid, unionFind);
                        unionDown(i, j, grid, unionFind);
                        break;
                    case 5:
                        // 5 表示连接左单元格和上单元格的街道
                        unionLeft(i, j, grid, unionFind);
                        unionUp(i, j, grid, unionFind);
                        break;
                    case 6:
                        // 6 表示连接右单元格和上单元格的街道
                        unionRight(i, j, grid, unionFind);
                        unionUp(i, j, grid, unionFind);
                        break;
                }
            }
        }
        return unionFind.find(0) == unionFind.find((row - 1) * col + col - 1);
    }

    private void unionUp(int i, int j, int[][] grid, UnionFind unionFind) {
        int col = grid[0].length;
        if (i - 1 >= 0 && UP.contains(grid[i - 1][j])) {
            unionFind.union(i * col + j, (i - 1) * col + j);
        }
    }

    private void unionDown(int i, int j, int[][] grid, UnionFind unionFind) {
        int row = grid.length;
        int col = grid[0].length;
        if (i + 1 < row && DOWN.contains(grid[i + 1][j])) {
            unionFind.union(i * col + j, (i + 1) * col + j);
        }
    }

    private void unionLeft(int i, int j, int[][] grid, UnionFind unionFind) {
        int col = grid[0].length;
        if (j + 1 < col && LEFT.contains(grid[i][j + 1])) {
            unionFind.union(i * col + j, i * col + j + 1);
        }
    }

    private void unionRight(int i, int j, int[][] grid, UnionFind unionFind) {
        int col = grid[0].length;
        if (j + 1 < col && RIGHT.contains(grid[i][j + 1])) {
            unionFind.union(i * col + j, i * col + j + 1);
        }
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
            Arrays.fill(weight, 1);
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
        LeetCode1391 leetCode1391 = new LeetCode1391();
        assert leetCode1391.hasValidPath(new int[][]{{2, 4, 3}, {6, 5, 2}});
    }

    @Test
    public void testCase2() {
        LeetCode1391 leetCode1391 = new LeetCode1391();
        assert !leetCode1391.hasValidPath(new int[][]{{1, 2, 1}, {1, 2, 1}});
    }

    @Test
    public void testCase3() {
        LeetCode1391 leetCode1391 = new LeetCode1391();
        assert !leetCode1391.hasValidPath(new int[][]{{1, 1, 2}});
    }

    @Test
    public void testCase4() {
        LeetCode1391 leetCode1391 = new LeetCode1391();
        assert leetCode1391.hasValidPath(new int[][]{{1, 1, 1, 1, 1, 1, 3}});
    }

    @Test
    public void testCase5() {
        LeetCode1391 leetCode1391 = new LeetCode1391();
        assert leetCode1391.hasValidPath(new int[][]{{2}, {2}, {2}, {2}, {2}, {2}, {6}});
    }
}
