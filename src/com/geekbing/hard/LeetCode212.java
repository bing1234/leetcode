package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode212 {
    private final Set<String> ans = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insertWord(word);
        }
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, visited, i, j, "", trie);
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, String str, Trie trie) {
        // 边界检查
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        str += board[i][j];
        if (!trie.searchPrefix(str)) {
            return;
        }
        if (trie.searchWord(str)) {
            ans.add(str);
        }
        visited[i][j] = true;
        // 朝上
        dfs(board, visited, i - 1, j, str, trie);
        // 朝下
        dfs(board, visited, i + 1, j, str, trie);
        // 朝左
        dfs(board, visited, i, j - 1, str, trie);
        // 朝右
        dfs(board, visited, i, j + 1, str, trie);
        visited[i][j] = false;
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        public void insertWord(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new Node();
                }
                cur = cur.childs[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean searchWord(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.childs[c - 'a'] == null) {
                    return false;
                }
                cur = cur.childs[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean searchPrefix(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.childs[c - 'a'] == null) {
                    return false;
                }
                cur = cur.childs[c - 'a'];
            }
            return true;
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
        LeetCode212 leetCode212 = new LeetCode212();
        List<String> ans = leetCode212.findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"});
        List<String> expert = new ArrayList<>(Arrays.asList("eat", "oath"));
        Collections.sort(ans);
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode212 leetCode212 = new LeetCode212();
        List<String> ans = leetCode212.findWords(new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        }, new String[]{"abcb"});
        Collections.sort(ans);
        assert new ArrayList<>().equals(ans);
    }
}
