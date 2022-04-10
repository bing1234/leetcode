package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode677 {
    private static class MapSum {
        private final Node root;

        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node cur = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new Node();
                }
                cur = cur.childs[c - 'a'];
            }
            cur.val = val;
            cur.isWord = true;
        }

        public int sum(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    return 0;
                }
                cur = cur.childs[c - 'a'];
            }
            return travelTree(cur);
        }

        private int travelTree(Node root) {
            if (root == null) {
                return 0;
            }
            int ans = 0;
            if (root.isWord) {
                ans += root.val;
            }
            for (Node node : root.childs) {
                ans += travelTree(node);
            }
            return ans;
        }

        private static class Node {
            private final Node[] childs;
            private boolean isWord;
            private int val;

            public Node() {
                this.childs = new Node[26];
                this.isWord = false;
                this.val = 0;
            }
        }
    }

    @Test
    public void testCase1() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        assert mapSum.sum("ap") == 3;
        mapSum.insert("app", 2);
        assert mapSum.sum("ap") == 5;
    }

    @Test
    public void testCase2() {
        MapSum mapSum = new MapSum();
        mapSum.insert("a", 3);
        assert mapSum.sum("ap") == 0;
        mapSum.insert("b", 2);
        assert mapSum.sum("a") == 3;
    }
}
