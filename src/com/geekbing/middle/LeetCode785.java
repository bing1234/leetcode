package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode785 {
    public boolean isBipartite(int[][] graph) {
        return true;
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
        LeetCode785 leetCode785 = new LeetCode785();
        assert !leetCode785.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}});
    }

    @Test
    public void testCase2() {
        LeetCode785 leetCode785 = new LeetCode785();
        assert leetCode785.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
    }
}
