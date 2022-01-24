package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        return 0;
    }

    private static class UnionFind {
        private int[] parent;
        private int[] weight;

        public UnionFind() {
//            this.parent = new int[];
//            this.weight = new int[];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
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
        LeetCode1722 leetCode1722 = new LeetCode1722();
        int[] source = new int[]{1, 2, 3, 4};
        int[] target = new int[]{2, 1, 4, 5};
        int[][] allowedSwaps = new int[][]{{0, 1}, {2, 3}};
        assert leetCode1722.minimumHammingDistance(source, target, allowedSwaps) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode1722 leetCode1722 = new LeetCode1722();
        int[] source = new int[]{1, 2, 3, 4};
        int[] target = new int[]{1, 3, 2, 4};
        int[][] allowedSwaps = new int[][]{};
        assert leetCode1722.minimumHammingDistance(source, target, allowedSwaps) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode1722 leetCode1722 = new LeetCode1722();
        int[] source = new int[]{5, 1, 2, 4, 3};
        int[] target = new int[]{1, 5, 4, 2, 3};
        int[][] allowedSwaps = new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}};
        assert leetCode1722.minimumHammingDistance(source, target, allowedSwaps) == 0;
    }
}
