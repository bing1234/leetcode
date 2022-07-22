package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1101 {
    public int earliestAcq(int[][] logs, int n) {
        // 按照时间从小到大排休
        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
        UnionFind unionFind = new UnionFind(n);
        for (int[] log : logs) {
            unionFind.union(log[1], log[2]);
            if (unionFind.allConnected(n)) {
                return log[0];
            }
        }
        return -1;
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

        public boolean allConnected(int n) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(find(i));
                if (set.size() > 1) {
                    return false;
                }
            }
            return true;
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
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode1101 leetCode1101 = new LeetCode1101();
        assert leetCode1101.earliestAcq(new int[][]{{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}}, 6) == 20190301;
    }

    @Test
    public void testCase2() {
        LeetCode1101 leetCode1101 = new LeetCode1101();
        assert leetCode1101.earliestAcq(new int[][]{{0, 2, 0}, {1, 0, 1}, {3, 0, 3}, {4, 1, 2}, {7, 3, 1}}, 4) == 3;
    }
}
