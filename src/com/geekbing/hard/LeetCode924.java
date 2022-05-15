package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode924 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int len = graph.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (graph[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        Arrays.sort(initial);
        // root - 和圈子的对应关系
        Map<Integer, List<Integer>> rootMap = new HashMap<>();
        for (int num : initial) {
            int root = unionFind.find(num);
            List<Integer> list = rootMap.getOrDefault(root, new ArrayList<>());
            list.add(num);
            rootMap.put(root, list);
        }

        int ans = initial[0], size = 0;
        for (int root : rootMap.keySet()) {
            List<Integer> list = rootMap.get(root);
            if (list.size() == 1) {
                if (unionFind.weight[root] > size || (unionFind.weight[root] == size && list.get(0) < ans)) {
                    ans = list.get(0);
                    size = unionFind.weight[root];
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
        LeetCode924 leetCode924 = new LeetCode924();
        int ans = leetCode924.minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, new int[]{0, 1});
        assert ans == 0;
    }

    @Test
    public void testCase2() {
        LeetCode924 leetCode924 = new LeetCode924();
        int ans = leetCode924.minMalwareSpread(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, new int[]{0, 2});
        assert ans == 0;
    }

    @Test
    public void testCase3() {
        LeetCode924 leetCode924 = new LeetCode924();
        int ans = leetCode924.minMalwareSpread(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 2});
        assert ans == 1;
    }

    @Test
    public void testCase4() {
        LeetCode924 leetCode924 = new LeetCode924();
        int ans = leetCode924.minMalwareSpread(new int[][]{{1, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 0}, {0, 0, 1, 1, 0, 0}, {0, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}}, new int[]{1, 2, 5});
        assert ans == 1;
    }

    @Test
    public void testCase5() {
        LeetCode924 leetCode924 = new LeetCode924();
        int ans = leetCode924.minMalwareSpread(new int[][]{{1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}}, new int[]{2, 1});
        assert ans == 1;
    }

    @Test
    public void testCase6() {
        LeetCode924 leetCode924 = new LeetCode924();
        int ans = leetCode924.minMalwareSpread(new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}}, new int[]{3, 1});
        assert ans == 3;
    }
}
