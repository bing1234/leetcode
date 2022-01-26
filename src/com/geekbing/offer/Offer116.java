package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class Offer116 {
    public int findCircleNum(int[][] isConnected) {
        UnionFind unionFind = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            roots.add(unionFind.find(i));
        }
        return roots.size();
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
        Offer116 offer116 = new Offer116();
        assert offer116.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}) == 2;
    }

    @Test
    public void testCase2() {
        Offer116 offer116 = new Offer116();
        assert offer116.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}) == 3;
    }
}
