package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 超时
 *
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
            Set<Integer> prefixIdxs = prefixTree.startWithWorldsMaxIdx(prefix);
            Set<Integer> suffixIdxs = suffixTree.startWithWorldsMaxIdx(suffix);
            int maxIdx = -1;
            for (Integer idx : prefixIdxs) {
                if (suffixIdxs.contains(idx)) {
                    maxIdx = Math.max(maxIdx, idx);
                }
            }
            return maxIdx;
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
                cur.idxs.add(idx);
                cur.isEnd = true;
            }

            public Set<Integer> startWithWorldsMaxIdx(String str) {
                Set<Integer> ans = new HashSet<>();
                Node cur = root;
                if (ifPrefix) {
                    for (int i = 0; i < str.length(); i++) {
                        char c = str.charAt(i);
                        if (cur.childs[c - 'a'] == null) {
                            return ans;
                        }
                        cur = cur.childs[c - 'a'];
                    }
                } else {
                    for (int i = str.length() - 1; i >= 0; i--) {
                        char c = str.charAt(i);
                        if (cur.childs[c - 'a'] == null) {
                            return ans;
                        }
                        cur = cur.childs[c - 'a'];
                    }
                }
                return travelTree(cur);
            }

            private Set<Integer> travelTree(Node root) {
                Set<Integer> ans = new HashSet<>();
                if (root == null) {
                    return ans;
                }
                if (root.isEnd) {
                    ans.addAll(root.idxs);
                }
                for (Node node : root.childs) {
                    if (node != null) {
                        ans.addAll(travelTree(node));
                    }
                }
                return ans;
            }
        }

        private static class Node {
            private final Node[] childs;
            private final List<Integer> idxs;
            private boolean isEnd;

            public Node() {
                this.childs = new Node[26];
                this.idxs = new ArrayList<>();
                this.isEnd = false;
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
