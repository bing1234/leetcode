package com.geekbing.middle;

public class LeetCode547 {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int ans = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                ans++;
                visited[i] = true;
                backtrack(visited, i, M);
            }
        }
        return ans;
    }

    private void backtrack(boolean[] visited, int i, int[][] M) {
        for (int j = 0; j < M.length; j++) {
            if (!visited[j] && M[i][j] == 1) {
                visited[j] = true;
                backtrack(visited, j, M);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode547 leetCode547 = new LeetCode547();
        System.out.println(leetCode547.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(leetCode547.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(leetCode547.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }
}
