package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode261 {
    public boolean validTree(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return false;
            }
        }
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            roots.add(unionFind.find(i));
            if (roots.size() > 1) {
                return false;
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
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        public int find(int x) {
            return parent[x] == x ? x : find(parent[x]);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (weight[rootX] < weight[rootY]) {
                weight[rootY] += weight[rootX];
                parent[rootX] = rootY;
            } else {
                weight[rootX] += weight[rootY];
                parent[rootY] = rootX;
            }
            return true;
        }
    }

    @Test
    public void testCase1() {
        LeetCode261 leetCode261 = new LeetCode261();
        assert leetCode261.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}});
    }

    @Test
    public void testCase2() {
        LeetCode261 leetCode261 = new LeetCode261();
        assert !leetCode261.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}});
    }

    @Test
    public void testCase3() {
        LeetCode261 leetCode261 = new LeetCode261();
        assert !leetCode261.validTree(4, new int[][]{{0, 1}, {2, 3}});
    }
}
