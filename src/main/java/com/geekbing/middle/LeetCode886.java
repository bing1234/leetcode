package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 构建并查集
        UnionFind unionFind = new UnionFind(n);
        // 转换成邻接矩阵, 按照判断二分图的方式
        Map<Integer, List<Integer>> map = buildMap(dislikes);
        for (Integer v : map.keySet()) {
            List<Integer> nums = map.get(v);
            for (Integer num : nums) {
                if (unionFind.isConnected(v, num)) {
                    return false;
                }
                unionFind.union(nums.get(0), num);
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> buildMap(int[][] dislikes) {
        Map<Integer, List<Integer>> dislikeMap = new HashMap<>();
        for (int[] dislike : dislikes) {
            List<Integer> list0 = dislikeMap.getOrDefault(dislike[0] - 1, new ArrayList<>());
            list0.add(dislike[1] - 1);
            dislikeMap.put(dislike[0] - 1, list0);

            List<Integer> list1 = dislikeMap.getOrDefault(dislike[1] - 1, new ArrayList<>());
            list1.add(dislike[0] - 1);
            dislikeMap.put(dislike[1] - 1, list1);
        }
        return dislikeMap;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        private boolean isConnected(int i, int j) {
            return find(i) == find(j);
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
        LeetCode886 leetCode886 = new LeetCode886();
        assert leetCode886.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}});
    }

    @Test
    public void testCase2() {
        LeetCode886 leetCode886 = new LeetCode886();
        assert !leetCode886.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}});
    }

    @Test
    public void testCase3() {
        LeetCode886 leetCode886 = new LeetCode886();
        assert !leetCode886.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}});
    }
}
