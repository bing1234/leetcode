package com.geekbing.lcs;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LcsO3 {
    public int largestArea(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();

        // 统计所有0的位置
        List<Pair> zeroIndexes = new ArrayList<>();

        UnionFind unionFind = new UnionFind(row * col);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                String lineI = grid[i];
                if (lineI.charAt(j) == '0') {
                    zeroIndexes.add(new Pair(i, j));
                }
                // 左右合并
                if (j + 1 < col && lineI.charAt(j) == lineI.charAt(j + 1)) {
                    unionFind.union(i * col + j, i * col + j + 1);
                }
                // 上下合并
                if (i + 1 < row) {
                    String lineIPlus = grid[i + 1];
                    if (lineI.charAt(j) == lineIPlus.charAt(j)) {
                        unionFind.union(i * col + j, (i + 1) * col + j);
                    }
                }
            }
        }

        // 不能使用的root
        Set<Integer> unUseRoots = new HashSet<>();

        // 和0上下左右相连的不能使用
        for (Pair zeroIndex : zeroIndexes) {
            int i = zeroIndex.i, j = zeroIndex.j;
            // 0本身的位置
            unUseRoots.add(unionFind.find(i * col + j));
            // 上
            if (i - 1 >= 0) {
                unUseRoots.add(unionFind.find((i - 1) * col + j));
            }
            // 下
            if (i + 1 < row) {
                unUseRoots.add(unionFind.find((i + 1) * col + j));
            }
            // 左
            if (j - 1 >= 0) {
                unUseRoots.add(unionFind.find(i * col + j - 1));
            }
            // 右
            if (j + 1 < col) {
                unUseRoots.add(unionFind.find(i * col + j + 1));
            }
        }
        // 和四周相连的不能使用
        for (int i = 0; i < row; i++) {
            unUseRoots.add(unionFind.find(i * col));
            unUseRoots.add(unionFind.find(i * col + col - 1));
        }
        for (int j = 0; j < col; j++) {
            unUseRoots.add(unionFind.find(j));
            unUseRoots.add(unionFind.find((row - 1) * col + j));
        }

        int ans = 0;
        for (int p : unionFind.parent) {
            if (!unUseRoots.contains(p)){
                ans = Math.max(ans, unionFind.weight[p]);
            }
        }
        return ans;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        private int find(int i) {
            return i == parent[i] ? i : find(parent[i]);
        }

        private void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (weight[rootI] < weight[rootJ]) {
                    parent[rootI] = rootJ;
                    weight[rootJ] += weight[rootI];
                } else {
                    parent[rootJ] = rootI;
                    weight[rootI] += weight[rootJ];
                }
            }
        }
    }

    private static class Pair {
        private int i;
        private int j;

        public Pair() {
        }

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    @Test
    public void testCase1() {
        LcsO3 lcsO3 = new LcsO3();
        assert lcsO3.largestArea(new String[]{
                "110",
                "231",
                "221"
        }) == 1;
    }

    @Test
    public void testCase2() {
        LcsO3 lcsO3 = new LcsO3();
        assert lcsO3.largestArea(new String[]{
                "11111100000",
                "21243101111",
                "21224101221",
                "11111101111"
        }) == 3;
    }
}
