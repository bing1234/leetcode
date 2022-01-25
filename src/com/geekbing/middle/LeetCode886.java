package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 * @author bing
 */
public class LeetCode886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Set<String> dislikeSet = new HashSet<>();
        for (int[] dislike : dislikes) {
            dislikeSet.add((dislike[0] - 1) + "_" + (dislike[1] - 1));
        }
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!dislikeSet.contains(i + "_" + j)) {
                    unionFind.union(i, j);
                }
            }
        }
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            roots.add(unionFind.find(i));
            if (roots.size() > 2) {
                return false;
            }
        }
        return true;
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
