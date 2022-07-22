package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode421 {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insertNum(num);
        }
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, trie.search(num));
        }
        return ans;
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        private void insertNum(int num) {
            Node cur = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (cur.childs[curBit] == null) {
                    cur.childs[curBit] = new Node();
                }
                cur = cur.childs[curBit];
            }
        }

        private int search(int num) {
            int other = 0;
            Node cur = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                int otherBit = (curBit == 1) ? 0 : 1;
                if (cur.childs[otherBit] == null) {
                    cur = cur.childs[curBit];
                } else {
                    cur = cur.childs[otherBit];
                    other += (1 << i);
                }
            }
            return other;
        }
    }

    private static class Node {
        private final Node[] childs;

        public Node() {
            childs = new Node[2];
        }
    }

    @Test
    public void testCase1() {
        LeetCode421 leetCode421 = new LeetCode421();
        int ans = leetCode421.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
        assert ans == 28;
    }

    @Test
    public void testCase2() {
        LeetCode421 leetCode421 = new LeetCode421();
        assert leetCode421.findMaximumXOR(new int[]{0}) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode421 leetCode421 = new LeetCode421();
        assert leetCode421.findMaximumXOR(new int[]{2, 4}) == 6;
    }

    @Test
    public void testCase4() {
        LeetCode421 leetCode421 = new LeetCode421();
        assert leetCode421.findMaximumXOR(new int[]{8, 10, 2}) == 10;
    }

    @Test
    public void testCase5() {
        LeetCode421 leetCode421 = new LeetCode421();
        assert leetCode421.findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}) == 127;
    }
}
