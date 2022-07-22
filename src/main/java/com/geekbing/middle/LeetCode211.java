package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode211 {
    private static class WordDictionary {
        private final Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
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

        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(Node cur, String word, int idx) {
            if (cur == null) {
                return false;
            }
            for (int i = idx; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (Node node : cur.childs) {
                        if (search(node, word, i + 1)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    if (cur.childs[c - 'a'] == null) {
                        return false;
                    }
                    cur = cur.childs[c - 'a'];
                }
            }
            return cur.isWord;
        }

        private static class Node {
            private final Node[] childs;
            private boolean isWord;

            public Node() {
                this.childs = new Node[26];
                this.isWord = false;
            }
        }
    }

    @Test
    public void testCase1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assert !wordDictionary.search("pad");
        assert wordDictionary.search("bad");
        assert wordDictionary.search(".ad");
        assert wordDictionary.search("b..");
    }
}
