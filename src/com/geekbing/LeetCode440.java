package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * 超时
 * @author bing
 */
public class LeetCode440 {
    private Node root;
    private int cnt = 0;

    public int findKthNumber(int n, int k) {
        root = new Node(' ');
        for (int i = 1; i <= n; i++) {
            insert(String.valueOf(i));
        }
        return travel(root, k);
    }

    private Integer travel(Node root, int k) {
        for (Node node : root.childs) {
            if (node != null) {
                Integer ans = travelTree(node, "", k);
                if (ans != null) {
                    return ans;
                }
            }
        }
        return null;
    }

    private Integer travelTree(Node root, String cur, int k) {
        if (root == null) {
            return null;
        }
        cur += root.val;
        if (root.isEnd) {
            cnt++;
            if (cnt == k) {
                return Integer.parseInt(cur);
            }
        }
        for (Node node : root.childs) {
            Integer ans = travelTree(node, cur, k);
            if (ans != null) {
                return ans;
            }
        }
        return null;
    }

    private void insert(String num) {
        Node cur = root;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int idx = c - '0';
            if (cur.childs[idx] == null) {
                cur.childs[idx] = new Node(c);
            }
            cur = cur.childs[idx];
        }
        cur.isEnd = true;
    }

    private static class Node {
        private final char val;
        private final Node[] childs;
        private boolean isEnd;

        public Node(char val) {
            this.val = val;
            this.childs = new Node[10];
            this.isEnd = false;
        }
    }

    @Test
    public void testCase1() {
        LeetCode440 leetCode440 = new LeetCode440();
        assert leetCode440.findKthNumber(13, 2) == 10;
    }

    @Test
    public void testCase2() {
        LeetCode440 leetCode440 = new LeetCode440();
        assert leetCode440.findKthNumber(1, 1) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode440 leetCode440 = new LeetCode440();
        assert leetCode440.findKthNumber(2, 2) == 2;
    }

    @Test
    public void testCase4() {
        long start = System.currentTimeMillis();
        LeetCode440 leetCode440 = new LeetCode440();
        int ans = leetCode440.findKthNumber(4289384, 1922239);
        assert ans == 2730010;
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
