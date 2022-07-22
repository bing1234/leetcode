package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class Offer118 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }
        return new int[]{};
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

        private boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return false;
            }
            if (weight[rootI] < weight[rootJ]) {
                parent[rootI] = rootJ;
                weight[rootJ] += weight[rootI];
            } else {
                parent[rootJ] = rootI;
                weight[rootI] += weight[rootJ];
            }
            return true;
        }
    }

    @Test
    public void testCase1() {
        Offer118 offer118 = new Offer118();
        int[] ans = offer118.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        int[] expert = new int[]{2, 3};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        Offer118 offer118 = new Offer118();
        int[] ans = offer118.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}});
        int[] expert = new int[]{1, 4};
        assert Arrays.equals(expert, ans);
    }
}
