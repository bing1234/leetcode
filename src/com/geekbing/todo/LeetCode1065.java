package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1065 {
    public int[][] indexPairs(String text, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insertWord(word);
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                if (trie.containWord(text.substring(i, j + 1))) {
                    list.add(new int[]{i, j});
                }
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
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

        public boolean containWord(String word) {
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

    @Test
    public void testCase1() {
        LeetCode1065 leetCode1065 = new LeetCode1065();
        int[][] ans = leetCode1065.indexPairs("thestoryofleetcodeandme", new String[]{"story", "fleet", "leetcode"});
        int[][] expert = new int[][]{{3, 7}, {9, 13}, {10, 17}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode1065 leetCode1065 = new LeetCode1065();
        int[][] ans = leetCode1065.indexPairs("ababa", new String[]{"aba", "ab"});
        int[][] expert = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode1065 leetCode1065 = new LeetCode1065();
        int[][] ans = leetCode1065.indexPairs("baabaaaaaa", new String[]{"b", "a", "ba", "bb", "aa"});
        int[][] expert = new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 2}, {3, 3}, {3, 4}, {4, 4}, {4, 5}, {5, 5}, {5, 6}, {6, 6}, {6, 7}, {7, 7}, {7, 8}, {8, 8}, {8, 9}, {9, 9}};
        assert Arrays.deepEquals(expert, ans);
    }
}
