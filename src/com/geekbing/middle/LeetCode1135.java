package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bing
 */
public class LeetCode1135 {
    public int minimumCost(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        // 按照花费从小到大排序
        Arrays.sort(connections, Comparator.comparingInt(o -> o[2]));
        int ans = 0;
        for (int[] connection : connections) {
            // 判断是否全部联通
            if (unionFind.allConnected(n)) {
                return ans;
            }
            if (unionFind.connected(connection[0] - 1, connection[1] - 1)) {
                continue;
            }
            unionFind.union(connection[0] - 1, connection[1] - 1);
            ans += connection[2];
        }
        return unionFind.allConnected(n) ? ans : -1;
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
            int root = find(0);
            for (int i = 1; i < n; i++) {
                if (find(i) != root) {
                    return false;
                }
            }
            return true;
        }

        public boolean connected(int x, int y) {
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
        LeetCode1135 leetCode1135 = new LeetCode1135();
        assert leetCode1135.minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}) == 6;
    }

    @Test
    public void testCase2() {
        LeetCode1135 leetCode1135 = new LeetCode1135();
        assert leetCode1135.minimumCost(4, new int[][]{{1, 2, 3}, {3, 4, 4}}) == -1;
    }
}
