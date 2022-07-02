package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode2316 {
    public long countPairs(int n, int[][] edges) {
        if (edges.length == 0) {
            return (long) n * (n - 1) / 2;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }

        Map<Integer, Set<Integer>> rootMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            Set<Integer> items = rootMap.getOrDefault(root, new HashSet<>());
            items.add(i);
            rootMap.put(root, items);
        }
        List<Integer> nums = rootMap.values().stream().map(Set::size).collect(Collectors.toList());
        long ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                ans += (long) nums.get(i) * nums.get(j);
            }
        }
        return ans;
    }

    private static final class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];
            Arrays.fill(weight, 1);
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            return i == parent[i] ? i : find(parent[i]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (weight[rootX] < weight[rootY]) {
                weight[rootY] += weight[rootX];
                parent[rootX] = rootY;
            } else {
                weight[rootX] += weight[rootY];
                parent[rootY] = rootX;
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode2316 leetCode2316 = new LeetCode2316();
        assert leetCode2316.countPairs(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}) == 0L;
    }

    @Test
    public void testCase2() {
        LeetCode2316 leetCode2316 = new LeetCode2316();
        assert leetCode2316.countPairs(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}}) == 14L;
    }

    @Test
    public void testCase3() {
        LeetCode2316 leetCode2316 = new LeetCode2316();
        assert leetCode2316.countPairs(100000, new int[][]{}) == 9999900000L;
    }

    @Test
    public void testCase4() {
        LeetCode2316 leetCode2316 = new LeetCode2316();
        assert leetCode2316.countPairs(12, new int[][]{}) == 66L;
    }
}
