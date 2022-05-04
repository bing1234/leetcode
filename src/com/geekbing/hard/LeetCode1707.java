package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1707 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insertNum(num);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = trie.search(queries[i][0], queries[i][1]);
        }
        return ans;
    }

    private static class Trie {
        private final Node root = new Node();

        private void insertNum(int num) {
            Node cur = root;
            cur.min = Math.min(cur.min, num);
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (cur.childs[curBit] == null) {
                    cur.childs[curBit] = new Node();
                }
                cur = cur.childs[curBit];
                cur.min = Math.min(cur.min, num);
            }
        }

        private int search(int num, int limit) {
            int other = 0;
            Node cur = root;
            if (cur.min > limit) {
                return -1;
            }
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                int otherBit = (curBit == 1) ? 0 : 1;
                if (cur.childs[otherBit] != null && cur.childs[otherBit].min <= limit) {
                    cur = cur.childs[otherBit];
                    other += (1 << i);
                } else {
                    cur = cur.childs[curBit];
                }
            }
            return other;
        }
    }

    private static class Node {
        private final Node[] childs = new Node[2];
        private int min = Integer.MAX_VALUE;
    }

    @Test
    public void testCase1() {
        LeetCode1707 leetCode1707 = new LeetCode1707();
        int[] ans = leetCode1707.maximizeXor(new int[]{0, 1, 2, 3, 4}, new int[][]{{3, 1}, {1, 3}, {5, 6}});
        int[] expert = new int[]{3, 3, 7};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode1707 leetCode1707 = new LeetCode1707();
        int[] ans = leetCode1707.maximizeXor(new int[]{5, 2, 4, 6, 6, 3}, new int[][]{{12, 4}, {8, 1}, {6, 3}});
        int[] expert = new int[]{15, -1, 5};
        assert Arrays.equals(expert, ans);
    }
}
