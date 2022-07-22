package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        // 边界检查
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        // 标记已使用
        visited[i][j] = true;
        // 朝左
        if (dfs(board, visited, word, i, j - 1, index + 1)) {
            return true;
        }
        // 朝右
        if (dfs(board, visited, word, i, j + 1, index + 1)) {
            return true;
        }
        // 朝上
        if (dfs(board, visited, word, i - 1, j, index + 1)) {
            return true;
        }
        // 朝下
        if (dfs(board, visited, word, i + 1, j, index + 1)) {
            return true;
        }
        // 标记当前节点未使用
        visited[i][j] = false;
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode79 leetCode79 = new LeetCode79();
        assert leetCode79.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED");
    }

    @Test
    public void testCase2() {
        LeetCode79 leetCode79 = new LeetCode79();
        assert leetCode79.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE");
    }

    @Test
    public void testCase3() {
        LeetCode79 leetCode79 = new LeetCode79();
        assert !leetCode79.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB");
    }
}
