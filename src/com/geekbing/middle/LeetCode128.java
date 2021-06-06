package com.geekbing.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        DisjointSetUnion sdu = new DisjointSetUnion(nums);
        for (int num : nums) {
            sdu.union(num, num + 1);
        }

        int ans = 1;
        for (int num : nums) {
            ans = Math.max(ans, sdu.findRoot(num) - num + 1);
        }
        return ans;
    }

    private static class DisjointSetUnion {
        Map<Integer, Integer> parent;

        public DisjointSetUnion(int[] nums) {
            parent = new HashMap<>();
            for (int num : nums) {
                parent.put(num, num);
            }
        }

        private Integer findRoot(int x) {
            if (!parent.containsKey(x)) {
                return null;
            }
            if (parent.get(x) == x) {
                return x;
            }
            int root = x;
            while (root != parent.get(root)) {
                root = parent.get(root);
            }
            return root;
        }

        private boolean union(int x, int y) {
            Integer rootX = findRoot(x);
            Integer rootY = findRoot(y);
            if (rootX == null || rootY == null) {
                return false;
            }
            if (rootX.equals(rootY)) {
                return false;
            } else if (rootX > rootY) {
                parent.put(rootY, rootX);
            } else {
                parent.put(rootX, rootY);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        LeetCode128 leetCode128 = new LeetCode128();

        System.out.println(leetCode128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(leetCode128.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
