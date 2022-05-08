package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2204 {
    public int[] distanceToCycle(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                // 说明找到环的一遍了

            }
        }

        int[] ans = new int[n];


        return ans;
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

        public int find(int i) {
            return parent[i] == i ? i : find(parent[i]);
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return false;
            }
            if (weight[rootI] < weight[rootJ]) {
                weight[rootJ] += weight[rootI];
                parent[rootI] = rootJ;
            } else {
                weight[rootI] += weight[rootJ];
                parent[rootJ] = rootI;
            }
            return true;
        }
    }

    @Test
    public void testCase1() {
        LeetCode2204 leetCode2204 = new LeetCode2204();
        int[] ans = leetCode2204.distanceToCycle(7, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {0, 1}, {5, 2}, {6, 5}});
        int[] expert = new int[]{1, 0, 0, 0, 0, 1, 2};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2204 leetCode2204 = new LeetCode2204();
        int[] ans = leetCode2204.distanceToCycle(9, new int[][]{{0, 1}, {1, 2}, {0, 2}, {2, 6}, {6, 7}, {6, 8}, {1, 3}, {3, 4}, {3, 5}});
        int[] expert = new int[]{0, 0, 0, 1, 2, 2, 1, 2, 2};
        assert Arrays.equals(expert, ans);
    }
}
