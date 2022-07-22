package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1804 {
    private static class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new Node();
                }
                cur = cur.childs[c - 'a'];
            }
            cur.isWord = true;
            cur.cnt++;
        }

        public int countWordsEqualTo(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    return 0;
                }
                cur = cur.childs[c - 'a'];
            }
            return !cur.isWord ? 0 : cur.cnt;
        }

        public int countWordsStartingWith(String prefix) {
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

        public void erase(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    break;
                }
                cur = cur.childs[c - 'a'];
            }
            cur.cnt--;
            if (cur.cnt == 0) {
                cur.isWord = false;
            }
        }

        private int travelTree(Node root) {
            if (root == null) {
                return 0;
            }
            int ans = 0;
            if (root.isWord) {
                ans += root.cnt;
            }
            for (Node child : root.childs) {
                ans += travelTree(child);
            }
            return ans;
        }

        private static class Node {
            private int cnt;
            private final Node[] childs;
            private boolean isWord;

            public Node() {
                cnt = 0;
                childs = new Node[26];
                isWord = false;
            }
        }
    }

    @Test
    public void testCase1() {
        Trie trie = new Trie();
        trie.insert("apple");                           // 插入 "apple"。
        trie.insert("apple");                           // 插入另一个 "apple"。
        assert trie.countWordsEqualTo("apple") == 2;          // 有两个 "apple" 实例，所以返回 2。
        assert trie.countWordsStartingWith("app") == 2; // "app" 是 "apple" 的前缀，所以返回 2。
        trie.erase("apple");                            // 移除一个 "apple"。
        assert trie.countWordsEqualTo("apple") == 1;          // 现在只有一个 "apple" 实例，所以返回 1。
        assert trie.countWordsStartingWith("app") == 1; // 返回 1
        trie.erase("apple");                             // 移除 "apple"。现在前缀树是空的。
        assert trie.countWordsStartingWith("app") == 0; // 返回 0
    }
}
