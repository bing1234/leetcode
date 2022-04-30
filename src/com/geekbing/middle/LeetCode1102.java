package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1102 {
    public int maximumMinimumPath(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j + 1 < col) {
                    edges.add(new Edge(i * col + j, i * col + j + 1, Math.min(grid[i][j], grid[i][j + 1])));
                }
                if (i + 1 < row) {
                    edges.add(new Edge(i * col + j, (i + 1) * col + j, Math.min(grid[i][j], grid[i + 1][j])));
                }
            }
        }
        // 按照价值从大到小排列
        edges.sort((o1, o2) -> Integer.compare(o2.val, o1.val));
        UnionFind unionFind = new UnionFind(row * col);
        for (Edge edge : edges) {
            unionFind.union(edge.from, edge.to);
            if (unionFind.connected(0, row * col - 1)) {
                return edge.val;
            }
        }
        return -1;
    }

    private static class Edge {
        int from, to, val;

        public Edge(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int len) {
            parent = new int[len];
            weight = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        public int find(int x) {
            return parent[x] == x ? x : find(parent[x]);
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (weight[rootX] < weight[rootY]) {
                    weight[rootY] += weight[rootX];
                    parent[rootX] = rootY;
                } else {
                    weight[rootX] += weight[rootY];
                    parent[rootY] = rootX;
                }
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode1102 leetCode1102 = new LeetCode1102();
        assert leetCode1102.maximumMinimumPath(new int[][]{
                {5, 4, 5},
                {1, 2, 6},
                {7, 4, 6}
        }) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode1102 leetCode1102 = new LeetCode1102();
        assert leetCode1102.maximumMinimumPath(new int[][]{
                {2, 2, 1, 2, 2, 2},
                {1, 2, 2, 2, 1, 2}
        }) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode1102 leetCode1102 = new LeetCode1102();
        assert leetCode1102.maximumMinimumPath(new int[][]{
                {3, 4, 6, 3, 4},
                {0, 2, 1, 1, 7},
                {8, 8, 3, 2, 7},
                {3, 2, 4, 9, 8},
                {4, 1, 2, 0, 0},
                {4, 6, 5, 4, 3}
        }) == 3;
    }
}
