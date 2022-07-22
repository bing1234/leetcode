package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int len = m * n, cnt = 0;
        int[][] board = new int[m][n];
        UnionFind unionFind = new UnionFind(len);
        for (int[] position : positions) {
            int i = position[0], j = position[1];
            if (board[i][j] == 1) {
                ans.add(cnt);
                continue;
            }
            board[i][j] = 1;
            cnt++;
            // 左右合并
            if (j - 1 >= 0 && board[i][j - 1] == 1) {
                if (unionFind.union(i * n + j, i * n + j - 1)) {
                    cnt--;
                }
            }
            if (j + 1 < n && board[i][j + 1] == 1) {
                if (unionFind.union(i * n + j, i * n + j + 1)) {
                    cnt--;
                }
            }
            // 上下合并
            if (i - 1 >= 0 && board[i - 1][j] == 1) {
                if (unionFind.union(i * n + j, (i - 1) * n + j)) {
                    cnt--;
                }
            }
            if (i + 1 < m && board[i + 1][j] == 1) {
                if (unionFind.union(i * n + j, (i + 1) * n + j)) {
                    cnt--;
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    private int countIslands(int[][] board, UnionFind unionFind) {
        int row = board.length, col = board[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1) {
                    set.add(unionFind.find(i * col + j));
                }
            }
        }
        return set.size();
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int len) {
            parent = new int[len];
            weight = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (weight[rootX] < weight[rootY]) {
                weight[rootY] += weight[rootX];
                parent[rootX] = rootY;
            } else {
                weight[rootX] += weight[rootY];
                parent[rootY] = rootX;
            }
            return true;
        }
    }

    @Test
    public void testCase1() {
        LeetCode305 leetCode305 = new LeetCode305();
        List<Integer> ans = leetCode305.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}});
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 1, 2, 3));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode305 leetCode305 = new LeetCode305();
        List<Integer> ans = leetCode305.numIslands2(1, 1, new int[][]{{0, 0}});
        List<Integer> expert = new ArrayList<>(Collections.singletonList(1));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode305 leetCode305 = new LeetCode305();
        List<Integer> ans = leetCode305.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {1, 2}});
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 1, 2, 2));
        assert expert.equals(ans);
    }
}
