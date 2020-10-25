package com.geekbing.middle;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/friend-circles/submissions/
 * 547. 朋友圈
 *
 * @author bing
 */
public class LeetCode547 {
    public int findCircleNumV2(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        int[] rank = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    union(i, j, parent, rank);
                }
            }
        }
        return (int) Arrays.stream(parent).filter(num -> num == -1).count();
    }

    private int findRoot(int x, int[] parent) {
        int root = x;
        while (parent[root] != -1) {
            root = parent[root];
        }
        return root;
    }

    private void union(int x, int y, int[] parent, int[] rank) {
        int rootX = findRoot(x, parent);
        int rootY = findRoot(y, parent);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }

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
        System.out.println(leetCode547.findCircleNumV2(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(leetCode547.findCircleNumV2(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(leetCode547.findCircleNumV2(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
        System.out.println(leetCode547.findCircleNumV2(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }
}
