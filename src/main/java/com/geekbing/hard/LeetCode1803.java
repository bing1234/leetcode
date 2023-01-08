package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1803 {
    public int countPairs(int[] nums, int low, int high) {
        int ans = 0;
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
        }
        for (int num : nums) {
            ans += trie.search(num, high + 1) - trie.search(num, low);
        }
        return ans / 2;
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            this.root = new Node();
        }

        private void insert(int num) {
            Node cur = root;
            for (int i = 14; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.child[bit] == null) {
                    cur.child[bit] = new Node();
                }
                cur = cur.child[bit];
                cur.cnt += 1;
            }
        }

        private int search(int num, int limit) {
            int ans = 0;
            Node cur = root;
            for (int i = 14; i >= 0; i--) {
                int numBit = (num >> i) & 1;
                int limitBit = (limit >> i) & 1;
                if (limitBit == 1) {
                    if (cur.child[numBit] != null) {
                        ans += cur.child[numBit].cnt;
                    }
                    cur = cur.child[numBit ^ 1];
                } else {
                    cur = cur.child[numBit];
                }
                if (cur == null) {
                    break;
                }
            }
            return ans;
        }
    }

    private static class Node {
        private final Node[] child;
        private int cnt;

        public Node() {
            this.child = new Node[2];
            this.cnt = 0;
        }
    }

    @Test
    public void testCase1() {
        LeetCode1803 leetCode1803 = new LeetCode1803();
        int ans = leetCode1803.countPairs(new int[]{1, 4, 2, 7}, 2, 6);
        assert ans == 6;
    }

    @Test
    public void testCase2() {
        LeetCode1803 leetCode1803 = new LeetCode1803();
        int ans = leetCode1803.countPairs(new int[]{9, 8, 4, 2, 1}, 5, 14);
        assert ans == 8;
    }

    @Test
    public void testCase3() {
        LeetCode1803 leetCode1803 = new LeetCode1803();
        int ans = leetCode1803.countPairs(new int[]{5202, 7809, 40, 6748, 7221, 4423, 2803, 4528, 2255, 2204, 6140, 3802, 4257, 2735, 6416, 75, 4432, 6641, 2595, 722, 4667, 2897, 4669, 6946, 2915, 3729, 4633, 1350, 8044, 8014, 2419, 4829, 6587, 5745, 6691, 7687, 406, 817, 6775, 682, 3753, 2477, 3534, 2910, 5753, 1984, 2571, 1663, 3993, 3419, 2130, 5496, 3868, 2927, 1044, 6919, 122, 4452, 5345, 3041, 703, 247, 2874, 6709, 1902, 1237, 2195, 6860, 6920, 5103, 2954, 5896, 145, 5323, 312, 6771, 1748, 348, 7798, 6800, 5300, 7014, 2773, 763, 1599, 1869, 5920, 1763, 5924, 1896, 1860, 4452, 6968, 6325, 1258, 7466, 2220, 6066, 7607, 1428, 6774, 7990, 4533, 2971, 5159, 6184, 2165, 370, 3033, 6007, 8062, 4713, 5465, 1498, 3346, 7562, 7044, 2921, 4195, 2975, 5901, 4574, 7874, 3184, 1292, 4661, 5634, 2134, 7578, 4817, 4619}, 5793, 7046);
        assert ans == 1305;
    }
}
