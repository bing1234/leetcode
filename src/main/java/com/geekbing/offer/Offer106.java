package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class Offer106 {
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
        Offer106 offer106 = new Offer106();
        assert !offer106.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}});
    }

    @Test
    public void testCase2() {
        Offer106 offer106 = new Offer106();
        assert offer106.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
    }
}
