package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int[] connection : connections) {
            unionFind.union(connection[0], connection[1]);
        }
        Set<Integer> parentSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int p = unionFind.find(i);
            parentSet.add(p);
        }
        if (parentSet.size() == 1) {
            return 0;
        }
        return parentSet.size() - 1;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
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
        int ans = makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}});
        assert ans == 1;
    }

    @Test
    public void testCase2() {
        int ans = makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}});
        assert ans == 2;
    }

    @Test
    public void testCase3() {
        int ans = makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}});
        assert ans == -1;
    }

    @Test
    public void testCase4() {
        int ans = makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}});
        assert ans == 0;
    }
}
