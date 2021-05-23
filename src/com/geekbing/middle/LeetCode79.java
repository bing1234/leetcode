package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
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

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        // 标记已使用
        visited[i][j] = true;
        // 朝左
        if (j - 1 >= 0 &&
                !visited[i][j - 1] &&
                dfs(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }
        // 朝右
        if (j + 1 < board[0].length &&
                !visited[i][j + 1] &&
                dfs(board, word, visited, i, j + 1, index + 1)) {
            return true;
        }
        // 朝上
        if (i - 1 >= 0 &&
                !visited[i - 1][j] &&
                dfs(board, word, visited, i - 1, j, index + 1)) {
            return true;
        }
        // 朝下
        if (i + 1 < board.length &&
                !visited[i + 1][j] &&
                dfs(board, word, visited, i + 1, j, index + 1)) {
            return true;
        }
        // 标记当前节点未使用
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        LeetCode79 leetCode79 = new LeetCode79();

        char[][] case1 = new char[3][4];
        case1[0] = new char[]{'A', 'B', 'C', 'E'};
        case1[1] = new char[]{'S', 'F', 'C', 'S'};
        case1[2] = new char[]{'A', 'D', 'E', 'E'};
        System.out.println(leetCode79.exist(case1, "ABCCED"));
        System.out.println(leetCode79.exist(case1, "SEE"));
        System.out.println(leetCode79.exist(case1, "ABCB"));

        char[][] case2 = new char[1][1];
        case2[0] = new char[]{'a'};
        System.out.println(leetCode79.exist(case2, "a"));
    }
}
