package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.isConnected(source, destination);
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
        LeetCode1971 leetCode1971 = new LeetCode1971();
        assert leetCode1971.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2);
    }

    @Test
    public void testCase2() {
        LeetCode1971 leetCode1971 = new LeetCode1971();
        assert !leetCode1971.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5);
    }
}
