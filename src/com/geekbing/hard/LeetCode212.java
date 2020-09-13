package com.geekbing.hard;

import java.util.ArrayList;
import java.util.List;

public class LeetCode212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (canFind(board, word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean canFind(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int start) {
        if (board[i][j] != word.charAt(start)) {
            return false;
        }
        // 最后一个字母匹配
        if (start == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        // 朝右
        if (j + 1 < board[0].length &&
                !visited[i][j + 1] &&
                dfs(board, word, visited, i, j + 1, start + 1)) {
            return true;
        }
        // 朝左
        if (j - 1 >= 0 &&
                !visited[i][j - 1] &&
                dfs(board, word, visited, i, j - 1, start + 1)) {
            return true;
        }
        // 朝下
        if (i + 1 < board.length &&
                !visited[i + 1][j] &&
                dfs(board, word, visited, i + 1, j, start + 1)) {
            return true;
        }
        // 朝上
        if (i - 1 >= 0 &&
                !visited[i - 1][j] &&
                dfs(board, word, visited, i - 1, j, start + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        LeetCode212 leetCode212 = new LeetCode212();

        char[][] board = new char[4][4];
        board[0] = new char[]{'o', 'a', 'a', 'n'};
        board[1] = new char[]{'e', 't', 'a', 'e'};
        board[2] = new char[]{'i', 'h', 'k', 'r'};
        board[3] = new char[]{'i', 'f', 'l', 'v'};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(leetCode212.findWords(board, words));
    }
}
