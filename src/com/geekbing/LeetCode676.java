package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode676 {
    private static class MagicDictionary {

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {

        }

        public boolean search(String searchWord) {
            return false;
        }

        private static class Node {
            private Node[] childs;
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
}
