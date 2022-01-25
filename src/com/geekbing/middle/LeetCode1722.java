package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        UnionFind unionFind = new UnionFind(source.length);
        for (int[] allowedSwap : allowedSwaps) {
            unionFind.union(allowedSwap[0], allowedSwap[1]);
        }

        // parent - 该parent下所有的子元素
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int p = unionFind.find(i);
            List<Integer> list = map.getOrDefault(p, new ArrayList<>());
            list.add(i);
            map.put(p, list);
        }

        int ans = 0;
        for (List<Integer> indexes : map.values()) {
            int[] s = new int[indexes.size()];
            int[] t = new int[indexes.size()];
            for (int i = 0; i < indexes.size(); i++) {
                s[i] = source[indexes.get(i)];
                t[i] = target[indexes.get(i)];
            }
            ans += countDiff(s, t);
        }
        return ans;
    }

    private int countDiff(int[] s, int[] t) {
        Arrays.sort(s);
        Arrays.sort(t);
        int idxS = 0, idxT = 0, same = 0;
        while (idxS < s.length && idxT < t.length) {
            if (s[idxS] < t[idxT]) {
                idxS++;
            } else if (t[idxT] < s[idxS]) {
                idxT++;
            } else {
                same++;
                idxS++;
                idxT++;
            }
        }
        return s.length - same;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new int[n];
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
        LeetCode1722 leetCode1722 = new LeetCode1722();
        int[] source = new int[]{1, 2, 3, 4};
        int[] target = new int[]{2, 1, 4, 5};
        int[][] allowedSwaps = new int[][]{{0, 1}, {2, 3}};
        assert leetCode1722.minimumHammingDistance(source, target, allowedSwaps) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode1722 leetCode1722 = new LeetCode1722();
        int[] source = new int[]{1, 2, 3, 4};
        int[] target = new int[]{1, 3, 2, 4};
        int[][] allowedSwaps = new int[][]{};
        assert leetCode1722.minimumHammingDistance(source, target, allowedSwaps) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode1722 leetCode1722 = new LeetCode1722();
        int[] source = new int[]{5, 1, 2, 4, 3};
        int[] target = new int[]{1, 5, 4, 2, 3};
        int[][] allowedSwaps = new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}};
        assert leetCode1722.minimumHammingDistance(source, target, allowedSwaps) == 0;
    }
}
