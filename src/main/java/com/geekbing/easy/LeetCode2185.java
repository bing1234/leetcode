package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2185 {
    public int prefixCount(String[] words, String pref) {
        // return (int) Arrays.stream(words).filter(word -> word.startsWith(pref)).count();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.search(pref);
    }

    private static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new Node();
                }
                cur = cur.child[c - 'a'];
                cur.cnt++;
            }
        }

        public int search(String pref) {
            Node cur = root;
            for (char c : pref.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    return 0;
                }
                cur = cur.child[c - 'a'];
            }
            return cur.cnt;
        }
    }

    private static class Node {
        Node[] child;
        int cnt;

        public Node() {
            child = new Node[26];
            cnt = 0;
        }
    }

    @Test
    public void testCase1() {
        LeetCode2185 leetCode2185 = new LeetCode2185();
        assert leetCode2185.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at") == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2185 leetCode2185 = new LeetCode2185();
        assert leetCode2185.prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code") == 0;
    }
}
