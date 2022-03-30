package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode820 {
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        for (String word : set) {
            trie.insertWord(word);
        }
        int ans = 0;
        for (String word : set) {
            if (!trie.endWith(word)) {
                ans += word.length() + 1;
            }
        }
        return ans;
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            this.root = new Node();
        }

        private void insertWord(String word) {
            Node cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new Node();
                }
                cur = cur.childs[c - 'a'];
            }
        }

        private boolean endWith(String word) {
            Node cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    return false;
                }
                cur = cur.childs[c - 'a'];
            }
            for (Node child : cur.childs) {
                if (child != null) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class Node {
        private final Node[] childs;

        public Node() {
            this.childs = new Node[26];
        }
    }

    @Test
    public void testCase1() {
        LeetCode820 leetCode820 = new LeetCode820();
        assert leetCode820.minimumLengthEncoding(new String[]{"time", "me", "bell"}) == 10;
    }

    @Test
    public void testCase2() {
        LeetCode820 leetCode820 = new LeetCode820();
        assert leetCode820.minimumLengthEncoding(new String[]{"t"}) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode820 leetCode820 = new LeetCode820();
        assert leetCode820.minimumLengthEncoding(new String[]{"time", "time", "time", "time"}) == 5;
    }
}
