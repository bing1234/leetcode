package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode947 {
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind(stones.length);
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                // 同一行或同一列
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    unionFind.union(i, j);
                }
            }
        }
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            roots.add(unionFind.find(i));
        }
        return stones.length - roots.size();
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
        LeetCode947 leetCode947 = new LeetCode947();
        int[][] stones = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        assert leetCode947.removeStones(stones) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode947 leetCode947 = new LeetCode947();
        int[][] stones = new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        assert leetCode947.removeStones(stones) == 3;
    }

    @Test
    public void testCase3() {
        LeetCode947 leetCode947 = new LeetCode947();
        int[][] stones = new int[][]{{0, 0}};
        assert leetCode947.removeStones(stones) == 0;
    }
}
