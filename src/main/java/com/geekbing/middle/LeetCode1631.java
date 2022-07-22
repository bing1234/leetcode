package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1631 {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        UnionFind unionFind = new UnionFind(row * col);

        List<Edge> edges = buildEdges(heights);
        for (Edge edge : edges) {
            unionFind.union(edge.i, edge.j);
            if (unionFind.isConnected(0, row * col - 1)) {
                return edge.weight;
            }
        }
        return 0;
    }

    private List<Edge> buildEdges(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 右边
                if (j + 1 < col) {
                    edges.add(new Edge(i * col + j, i * col + j + 1, Math.abs(heights[i][j] - heights[i][j + 1])));
                }
                // 下边
                if (i + 1 < row) {
                    edges.add(new Edge(i * col + j, (i + 1) * col + j, Math.abs(heights[i][j] - heights[i + 1][j])));
                }
            }
        }
        edges.sort(Comparator.comparingInt(o -> o.weight));
        return edges;
    }

    private static class Edge {
        private final int i;
        private final int j;
        private final int weight;

        public Edge(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        private boolean isConnected(int i, int j) {
            return find(i) == find(j);
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
        LeetCode1631 leetCode1631 = new LeetCode1631();
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        assert leetCode1631.minimumEffortPath(heights) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1631 leetCode1631 = new LeetCode1631();
        int[][] heights = new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        assert leetCode1631.minimumEffortPath(heights) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode1631 leetCode1631 = new LeetCode1631();
        int[][] heights = new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        assert leetCode1631.minimumEffortPath(heights) == 0;
    }
}
