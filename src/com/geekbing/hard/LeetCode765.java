package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode765 {
    public int minSwapsCouples(int[] row) {
        int len = row.length, n = len / 2;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < len - 2; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - unionFind.cnt;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;
        private int cnt;

        public UnionFind(int len) {
            parent = new int[len];
            weight = new int[len];
            cnt = len;
            Arrays.fill(weight, 1);
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
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
                cnt--;
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode765 leetCode765 = new LeetCode765();
        assert leetCode765.minSwapsCouples(new int[]{0, 2, 1, 3}) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode765 leetCode765 = new LeetCode765();
        assert leetCode765.minSwapsCouples(new int[]{3, 2, 0, 1}) == 0;
    }
}
