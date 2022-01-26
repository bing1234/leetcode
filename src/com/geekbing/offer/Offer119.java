package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class Offer119 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(nums);
        for (int num : nums) {
            unionFind.union(num, num + 1);
        }
        int ans = 1;
        for (int num : nums) {
            ans = Math.max(ans, unionFind.find(num) - num + 1);
        }
        return ans;
    }

    private static class UnionFind {
        private final Map<Integer, Integer> parent = new HashMap<>();

        public UnionFind(int[] nums) {
            for (int num : nums) {
                parent.put(num, num);
            }
        }

        private Integer find(int i) {
            if (!parent.containsKey(i)) {
                return null;
            }
            if (i == parent.get(i)) {
                return i;
            }
            int root = i;
            while (root != parent.get(root)) {
                root = parent.get(root);
            }
            return root;
        }

        private void union(int i, int j) {
            Integer rootI = find(i);
            Integer rootJ = find(j);
            if (rootI == null || rootJ == null) {
                return;
            }
            if (rootI < rootJ) {
                parent.put(rootI, rootJ);
            } else if (rootJ < rootI) {
                parent.put(rootJ, rootI);
            }
        }
    }

    @Test
    public void testCase1() {
        Offer119 offer119 = new Offer119();
        assert offer119.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}) == 4;
    }

    @Test
    public void testCase2() {
        Offer119 offer119 = new Offer119();
        assert offer119.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}) == 9;
    }

    @Test
    public void testCase3() {
        Offer119 offer119 = new Offer119();
        assert offer119.longestConsecutive(new int[]{1, 2, 0, 1}) == 3;
    }
}
