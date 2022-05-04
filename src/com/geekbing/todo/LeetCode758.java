package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode758 {
    private static String open = "<b>";
    private static String close = "</b>";
    private final Node root = new Node();

    public String boldWords(String[] words, String s) {
        for (String word : words) {
            insertWord(word);
        }

        boolean isOpen = false, isClose = false;
        String ans = "";
        int maxEnd = -1;
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            int j = i;
            while (j < s.length() && cur.childs[s.charAt(j) - 'a'] != null) {
                cur = cur.childs[s.charAt(j) - 'a'];
                j++;
                if (cur.isWord) {
                    if (!isOpen) {
                        ans += open;
                        isOpen = true;
                    }
                    maxEnd = Math.max(maxEnd, j);
                }
            }
            if (i == maxEnd) {
                isOpen = false;
            }
        }
        return ans;
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
        LeetCode758 leetCode758 = new LeetCode758();
        String ans = leetCode758.boldWords(new String[]{"ab", "bc"}, "aabcd");
        assert ans.equals("a<b>abc</b>d");
    }

    @Test
    public void testCase2() {
        LeetCode758 leetCode758 = new LeetCode758();
        String ans = leetCode758.boldWords(new String[]{"ab", "cb"}, "aabcd");
        assert ans.equals("a<b>ab</b>cd");
    }
}
