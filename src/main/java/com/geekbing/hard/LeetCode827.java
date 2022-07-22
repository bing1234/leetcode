package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode827 {
    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 左右合并
                if (grid[i][j] == 1 && j + 1 < col && grid[i][j + 1] == 1) {
                    unionFind.union(i * col + j, i * col + j + 1);
                }
                // 上下合并
                if (grid[i][j] == 1 && i + 1 < row && grid[i + 1][j] == 1) {
                    unionFind.union(i * col + j, (i + 1) * col + j);
                }
            }
        }
        int max = unionFind.findMaxWeight();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> rootSet = new HashSet<>();
                    // 假设能连接上
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        rootSet.add(unionFind.find((i - 1) * row + j));
                    }
                    // 假设能连接下
                    if (i + 1 < row && grid[i + 1][j] == 1) {
                        rootSet.add(unionFind.find((i + 1) * row + j));
                    }
                    // 假设能连接左
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        rootSet.add(unionFind.find(i * row + j - 1));
                    }
                    // 假设能连接右
                    if (j + 1 < col && grid[i][j + 1] == 1) {
                        rootSet.add(unionFind.find(i * row + j + 1));
                    }
                    int ans = 1;
                    for (Integer root : rootSet) {
                        ans += unionFind.weight[root];
                    }
                    max = Math.max(max, ans);
                }
            }
        }
        return Math.max(max, 1);
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            parent = new int[row * col];
            weight = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int idx = i * col + j;
                    if (grid[i][j] == 1) {
                        weight[idx] = 1;
                    }
                    parent[idx] = idx;
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

        private int findMaxWeight() {
            int max = 0;
            for (int num : weight) {
                max = Math.max(max, num);
            }
            return max;
        }
    }

    @Test
    public void testCase1() {
        LeetCode827 leetCode827 = new LeetCode827();
        int ans = leetCode827.largestIsland(new int[][]{{1, 0}, {0, 1}});
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode827 leetCode827 = new LeetCode827();
        assert leetCode827.largestIsland(new int[][]{{1, 1}, {1, 0}}) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode827 leetCode827 = new LeetCode827();
        assert leetCode827.largestIsland(new int[][]{{1, 1}, {1, 1}}) == 4;
    }
}
