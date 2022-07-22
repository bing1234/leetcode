package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode959 {
    public int regionsBySlashes(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                int type1 = (i * col + j) * 4;
                int type2 = type1 + 1;
                int type3 = type1 + 2;
                int type4 = type1 + 3;

                char cur = grid[i].charAt(j);
                if (cur == ' ') {
                    // 类型1和类型2合并
                    unionFind.union(type1, type2);
                    // 类型2和类型3合并
                    unionFind.union(type2, type3);
                    // 类型3和类型4合并
                    unionFind.union(type3, type4);
                } else if (cur == '/') {
                    // 类型1和类型4合并
                    unionFind.union(type1, type4);
                    // 类型2和类型3合并
                    unionFind.union(type2, type3);
                } else if (cur == '\\') {
                    // 类型1和类型2合并
                    unionFind.union(type1, type2);
                    // 类型3和类型4合并
                    unionFind.union(type3, type4);
                }
                // 左右合并：类型2和右边的类型4合并
                if (j < col - 1) {
                    unionFind.union(type2, type1 + 7);
                }
                // 上下合并：类型3和下面的类型1合并
                if (i < row - 1) {
                    unionFind.union(type3, ((i + 1) * col + j) * 4);
                }
            }
        }
        return unionFind.numOfArea();
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(String[] grid) {
            int row = grid.length;
            int col = grid[0].length();
            parent = new int[row * col * 4];
            weight = new int[row * col * 4];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        public int find(int x) {
            return x == parent[x] ? x : find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            int weightX = weight[rootX];
            int weightY = weight[rootY];
            if (weightX <= weightY) {
                parent[rootX] = rootY;
                weight[rootY] += weight[rootX];
            } else {
                parent[rootY] = rootX;
                weight[rootX] += weight[rootY];
            }
        }

        public int numOfArea() {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < parent.length; i++) {
                set.add(find(i));
            }
            return set.size();
        }
    }

    @Test
    public void testCase1() {
        LeetCode959 leetCode959 = new LeetCode959();
        String[] grid = new String[]{" /", "/ "};
        assert leetCode959.regionsBySlashes(grid) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode959 leetCode959 = new LeetCode959();
        String[] grid = new String[]{" /", "  "};
        assert leetCode959.regionsBySlashes(grid) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode959 leetCode959 = new LeetCode959();
        String[] grid = new String[]{"\\/", "/\\"};
        assert leetCode959.regionsBySlashes(grid) == 4;
    }

    @Test
    public void testCase4() {
        LeetCode959 leetCode959 = new LeetCode959();
        String[] grid = new String[]{"/\\", "\\/"};
        assert leetCode959.regionsBySlashes(grid) == 5;
    }

    @Test
    public void testCase5() {
        LeetCode959 leetCode959 = new LeetCode959();
        String[] grid = new String[]{"//", "/ "};
        assert leetCode959.regionsBySlashes(grid) == 3;
    }
}
