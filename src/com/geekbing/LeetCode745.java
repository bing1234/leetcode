package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode745 {
    private static class WordFilter {
        private final Trie prefixTree;
        private final Trie suffixTree;

        public WordFilter(String[] words) {
            prefixTree = new Trie(true);
            suffixTree = new Trie(false);
            for (int i = 0; i < words.length; i++) {
                prefixTree.insert(words[i], i);
                suffixTree.insert(words[i], i);
            }
        }

        public int f(String prefix, String suffix) {
            int preMaxIdx = prefixTree.startWithWorldsMaxIdx(prefix);
            int suffixIdx = suffixTree.startWithWorldsMaxIdx(suffix);
            return Math.min(preMaxIdx, suffixIdx);
        }

        private static class Trie {
            private final Node root;
            private final boolean ifPrefix;

            public Trie(boolean ifPrefix) {
                this.root = new Node();
                this.ifPrefix = ifPrefix;
            }

            public void insert(String word, int idx) {
                Node cur = root;
                if (ifPrefix) {
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        if (cur.childs[c - 'a'] == null) {
                            cur.childs[c - 'a'] = new Node();
                        }
                        cur = cur.childs[c - 'a'];
                    }
                } else {
                    for (int i = word.length() - 1; i >= 0; i--) {
                        char c = word.charAt(i);
                        if (cur.childs[c - 'a'] == null) {
                            cur.childs[c - 'a'] = new Node();
                        }
                        cur = cur.childs[c - 'a'];
                    }
                }
                cur.maxIdx = Math.max(cur.maxIdx, idx);
                cur.isEnd = true;
            }

            public int startWithWorldsMaxIdx(String str) {
                Node cur = root;
                if (ifPrefix) {
                    for (int i = 0; i < str.length(); i++) {
                        char c = str.charAt(i);
                        if (cur.childs[c - 'a'] == null) {
                            return -1;
                        }
                        cur = cur.childs[c - 'a'];
                    }
                } else {
                    for (int i = str.length() - 1; i >= 0; i--) {
                        char c = str.charAt(i);
                        if (cur.childs[c - 'a'] == null) {
                            return -1;
                        }
                        cur = cur.childs[c - 'a'];
                    }
                }
                return travelTree(cur);
            }

            private int travelTree(Node root) {
                int maxIdx = -1;
                if (root == null) {
                    return maxIdx;
                }
                if (root.isEnd) {
                    maxIdx = root.maxIdx;
                }
                for (Node node : root.childs) {
                    if (node != null) {
                        int ans = travelTree(node);
                        maxIdx = Math.max(maxIdx, ans);
                    }
                }
                return maxIdx;
            }
        }

        private static class Node {
            private final Node[] childs;
            private boolean isEnd;
            private int maxIdx;

            public Node() {
                this.childs = new Node[26];
                this.isEnd = false;
                this.maxIdx = -1;
            }
        }
    }

    @Test
    public void testCase1() {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        assert wordFilter.f("a", "e") == 0;
    }

    @Test
    public void testCase2() {
        WordFilter wordFilter = new WordFilter(new String[]{"cabaabaaaa", "ccbcababac", "bacaabccba", "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca", "ababccabcb", "caccbbcbab", "bccbacbcba"});
        assert wordFilter.f("bccbacbcba", "a") == 9;
        assert wordFilter.f("ab", "abcaccbcaa") == 4;
        assert wordFilter.f("a", "aa") == 5;
        assert wordFilter.f("cabaaba", "abaaaa") == 0;
        assert wordFilter.f("cacc", "accbbcbab") == 8;
        assert wordFilter.f("ccbcab", "bac") == 1;
        assert wordFilter.f("bac", "cba") == 2;
        assert wordFilter.f("ac", "accabaccaa") == 5;
        assert wordFilter.f("bcbb", "aa") == 3;
        assert wordFilter.f("ccbca", "cbcababac") == 1;
    }
}
