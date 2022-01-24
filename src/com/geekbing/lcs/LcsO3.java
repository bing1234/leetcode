package com.geekbing.lcs;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LcsO3 {
    public int largestArea(String[] grid) {
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
        LcsO3 lcsO3 = new LcsO3();
        assert lcsO3.largestArea(new String[]{"110", "231", "221"}) == 1;
    }

    @Test
    public void testCase2() {
        LcsO3 lcsO3 = new LcsO3();
        assert lcsO3.largestArea(new String[]{"11111100000", "21243101111", "21224101221", "11111101111"}) == 3;
    }
}
