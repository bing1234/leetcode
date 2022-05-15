package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bing
 */
public class LeetCode1168 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[][] costs = new int[pipes.length + n][3];
        System.arraycopy(pipes, 0, costs, 0, pipes.length);
        for (int i = 0; i < wells.length; i++) {
            costs[pipes.length + i] = new int[]{0, i + 1, wells[i]};
        }
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        int ans = 0;
        UnionFind unionFind = new UnionFind(n + 1);
        for (int[] cost : costs) {
            if (unionFind.connect(cost[0], cost[1])) {
                continue;
            }
            unionFind.union(cost[0], cost[1]);
            ans += cost[2];
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

        public boolean connect(int x, int y) {
            return find(x) == find(y);
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
        LeetCode1168 leetCode1168 = new LeetCode1168();
        assert leetCode1168.minCostToSupplyWater(3, new int[]{1, 2, 2}, new int[][]{{1, 2, 1}, {2, 3, 1}}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1168 leetCode1168 = new LeetCode1168();
        assert leetCode1168.minCostToSupplyWater(2, new int[]{1, 1}, new int[][]{{1, 2, 1}}) == 2;
    }
}
