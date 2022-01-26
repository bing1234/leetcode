package com.geekbing.interview;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class Interview1619 {
    public int[] pondSizes(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        UnionFind unionFind = new UnionFind(land);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] == 0) {
                    // 向右合并
                    if (j + 1 < col && land[i][j + 1] == 0) {
                        unionFind.union(i * col + j, i * col + j + 1);
                    }
                    // 向下合并
                    if (i + 1 < row && land[i + 1][j] == 0) {
                        unionFind.union(i * col + j, (i + 1) * col + j);
                    }
                    // 向左下合并
                    if (i + 1 < row && j - 1 >= 0 && land[i + 1][j - 1] == 0) {
                        unionFind.union(i * col + j, (i + 1) * col + j - 1);
                    }
                    // 向右下合并
                    if (i + 1 < row && j + 1 < col && land[i + 1][j + 1] == 0) {
                        unionFind.union(i * col + j, (i + 1) * col + j + 1);
                    }
                }
            }
        }
        Set<Integer> used = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] == 0) {
                    int root = unionFind.find(i * col + j);
                    if (!used.contains(root)) {
                        list.add(unionFind.weight[root]);
                        used.add(root);
                    }
                }
            }
        }
        return list.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int[][] land) {
            int row = land.length;
            int col = land[0].length;
            parent = new int[row * col];
            weight = new int[row * col];

            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[i].length; j++) {
                    if (land[i][j] == 0) {
                        weight[i * col + j] = 1;
                    }
                }
            }
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

    @Test
    public void testCase1() {
        Interview1619 interview1619 = new Interview1619();

        int[] ans = interview1619.pondSizes(new int[][]{{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}});

        int[] expert = new int[]{1, 2, 4};

        assert Arrays.equals(expert, ans);
    }
}
