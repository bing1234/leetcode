package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode785 {
    public boolean isBipartite(int[][] graph) {
        UnionFind unionFind = new UnionFind(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int num : graph[i]) {
                if (unionFind.isConnected(i, num)) {
                    return false;
                }
                unionFind.union(graph[i][0], num);
            }
        }
        return true;
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

        private int find(int i) {
            return i == parent[i] ? i : find(parent[i]);
        }

        private boolean isConnected(int i, int j) {
            return find(i) == find(j);
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
        LeetCode785 leetCode785 = new LeetCode785();
        assert !leetCode785.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}});
    }

    @Test
    public void testCase2() {
        LeetCode785 leetCode785 = new LeetCode785();
        assert leetCode785.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
    }

    @Test
    public void testCase3() {
        LeetCode785 leetCode785 = new LeetCode785();
        assert leetCode785.isBipartite(new int[][]{{3, 4, 6}, {3, 6}, {3, 6}, {0, 1, 2, 5}, {0, 7, 8}, {3}, {0, 1, 2, 7}, {4, 6}, {4}, {}});
    }
}
