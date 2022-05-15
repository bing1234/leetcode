package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode928 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        int len = initial.length;
        int ans = initial[len - 1], size = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            // 如果删除当前节点，感染数量
            int cnt = deleteNum(graph, initial, initial[i]);
            if (cnt <= size) {
                ans = initial[i];
                size = cnt;
            }
        }
        return ans;
    }

    private int deleteNum(int[][] graph, int[] initial, int del) {
        int len = graph.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (i != del && j != del && graph[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : initial) {
            if (num != del) {
                int root = unionFind.find(num);
                if (!set.contains(root)) {
                    ans += unionFind.weight[root];
                    set.add(root);
                }
            }
        }
        return ans;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];
            Arrays.fill(weight, 1);
            for (int i = 0; i < n; i++) {
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
                if (weight[rootX] != weight[rootY]) {
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
        LeetCode928 leetCode928 = new LeetCode928();
        assert leetCode928.minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, new int[]{0, 1}) == 0;
    }

    @Test
    public void testCase2() {
        LeetCode928 leetCode928 = new LeetCode928();
        assert leetCode928.minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}, new int[]{0, 1}) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode928 leetCode928 = new LeetCode928();
        assert leetCode928.minMalwareSpread(new int[][]{{1, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 1, 1}, {0, 0, 1, 1}}, new int[]{0, 1}) == 1;
    }
}
