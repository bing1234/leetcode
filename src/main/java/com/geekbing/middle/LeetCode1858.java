package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1858 {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insertWord(word);
        }

        String ans = "";
        for (String word : words) {
            if (trie.checkWord(word) && trie.compareWord(word, ans) > 0) {
                ans = word;
            }
        }
        return ans;
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        public void insertWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new Node();
                }
                cur = cur.childs[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean checkWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    return false;
                }
                cur = cur.childs[c - 'a'];
                if (!cur.isWord) {
                    return false;
                }
            }
            return cur.isWord;
        }

        public int compareWord(String word1, String word2) {
            int res = Integer.compare(word1.length(), word2.length());
            if (res != 0) {
                return res;
            }
            return word2.compareTo(word1);
        }
    }

    private static class Node {
        private final Node[] childs;
        private boolean isWord;

        public Node() {
            childs = new Node[26];
            isWord = false;
        }
    }

    @Test
    public void testCase1() {
        LeetCode1858 leetCode1858 = new LeetCode1858();
        assert leetCode1858.longestWord(new String[]{"k", "ki", "kir", "kira", "kiran"}).equals("kiran");
    }

    @Test
    public void testCase2() {
        LeetCode1858 leetCode1858 = new LeetCode1858();
        assert leetCode1858.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}).equals("apple");
    }

    @Test
    public void testCase3() {
        LeetCode1858 leetCode1858 = new LeetCode1858();
        assert leetCode1858.longestWord(new String[]{"abc", "bc", "ab", "qwe"}).equals("");
    }
}
