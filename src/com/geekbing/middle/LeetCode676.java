package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode676 {
    private static class MagicDictionary {
        private final Trie trie;

        public MagicDictionary() {
            trie = new Trie();
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                trie.insertWord(word);
            }
        }

        public boolean search(String searchWord) {
            return trie.search(searchWord);
        }

        private static class Trie {
            private final Node root;

            public Trie() {
                root = new Node();
            }

            private void insertWord(String word) {
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

            private boolean search(String word) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        // 过滤本身
                        if (chars[i] == c) {
                            continue;
                        }
                        // 变换一个单词
                        chars[i] = c;
                        if (match(String.valueOf(chars))) {
                            return true;
                        }
                        // 还原
                        chars[i] = word.charAt(i);
                    }
                }
                return false;
            }

            private boolean match(String word) {
                Node cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.childs[c - 'a'] == null) {
                        return false;
                    }
                    cur = cur.childs[c - 'a'];
                }
                return cur.isWord;
            }
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
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        assert !magicDictionary.search("hello");
        assert magicDictionary.search("hhllo");
        assert !magicDictionary.search("hell");
        assert !magicDictionary.search("leetcoded");
    }

    @Test
    public void testCase2() {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "hallo", "leetcode"});
        assert magicDictionary.search("hello");
        assert magicDictionary.search("hhllo");
        assert !magicDictionary.search("hell");
        assert !magicDictionary.search("leetcoded");
    }
}
