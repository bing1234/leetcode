package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int row = grid2.length;
        int col = grid2[0].length;
        UnionFind unionFind = new UnionFind(grid2);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j + 1 < col && grid2[i][j] == 1 && grid2[i][j + 1] == 1) {
                    unionFind.union(i * col + j, i * col + j + 1);
                }
                if (i + 1 < row && grid2[i][j] == 1 && grid2[i + 1][j] == 1) {
                    unionFind.union(i * col + j, (i + 1) * col + j);
                }
            }
        }
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid2[i][j] == 1) {
                    int idx = i * col + j;
                    int p = unionFind.find(idx);
                    List<Pair> list = map.getOrDefault(p, new ArrayList<>());
                    list.add(new Pair(i, j));
                    map.put(p, list);
                }
            }
        }
        int ans = 0;
        for (List<Pair> list : map.values()) {
            boolean cover = true;
            for (Pair pair : list) {
                if (grid1[pair.i][pair.j] != 1) {
                    cover = false;
                    break;
                }
            }
            if (cover) {
                ans++;
            }
        }
        return ans;
    }

    private static class Pair {
        private int i;
        private int j;

        public Pair() {
        }

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
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
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int idx = i * col + j;
                    if (grid[i][j] == 0) {
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
        LeetCode1905 leetCode1905 = new LeetCode1905();
        int[][] grid1 = new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        assert leetCode1905.countSubIslands(grid1, grid2) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1905 leetCode1905 = new LeetCode1905();
        int[][] grid1 = new int[][]{{1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}};
        int[][] grid2 = new int[][]{{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}};
        int ans = leetCode1905.countSubIslands(grid1, grid2);
        assert ans == 2;
    }
}
