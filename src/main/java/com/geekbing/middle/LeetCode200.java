package com.geekbing.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 200. 岛屿数量
 *
 * @author bing
 */
public class LeetCode200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length, len = row * col;
        int[] parent = new int[len];
        int[] rank = new int[len];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    parent[i * col + j] = i * col + j;
                } else {
                    parent[i * col + j] = -1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    // 当前点和右边的点都是1，则合并当前点和右边的点
                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        union(i * col + j, i * col + j + 1, parent, rank);
                    }
                    // 当前点和下边的点都是1，则合并当前点和下边的点
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        union(i * col + j, (i + 1) * col + j, parent, rank);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < row * col; i++) {
            if (parent[i] != -1) {
                int root = findRoot(i, parent);
                set.add(root);
            }
        }
        return set.size();
    }

    private int findRoot(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        int root = x;
        while (parent[root] != -1) {
            root = parent[root];
            if (parent[root] == root) {
                return root;
            }
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
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode200 leetCode200 = new LeetCode200();

        char[][] grid1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(leetCode200.numIslands(grid1));

        char[][] grid2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(leetCode200.numIslands(grid2));

        char[][] grid3 = new char[][]{
                {'1'},
                {'1'}
        };
        System.out.println(leetCode200.numIslands(grid3));
    }
}
