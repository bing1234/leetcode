package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode694 {
    public int numDistinctIslands(int[][] grid) {
        UnionFind unionFind = new UnionFind(grid);
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 左右合并
                if (j + 1 < col && grid[i][j] == 1 && grid[i][j + 1] == 1) {
                    unionFind.union(i * col + j, i * col + j + 1);
                }
                // 上下合并
                if (i + 1 < row && grid[i][j] == 1 && grid[i + 1][j] == 1) {
                    unionFind.union(i * col + j, (i + 1) * col + j);
                }
            }
        }
        // 按照root进行分组
        Map<Integer, List<Point>> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int root = unionFind.find(i * col + j);
                    List<Point> list = map.getOrDefault(root, new ArrayList<>());
                    list.add(new Point(i, j));
                    map.put(root, list);
                }
            }
        }
        // 将岛屿平移
        Set<List<Point>> set = new HashSet<>();
        for (List<Point> points : map.values()) {
            set.add(translation(points));
        }
        return set.size();
    }

    private List<Point> translation(List<Point> points) {
        // 找到左上角的点
        Point leftTop = points.get(0);
        for (Point point : points) {
            if (point.x < leftTop.x && point.y < leftTop.y) {
                leftTop = point;
            }
        }
        // 平移
        List<Point> ans = new ArrayList<>();
        for (Point point : points) {
            ans.add(new Point(point.x - leftTop.x, point.y - leftTop.y));
        }
        return ans;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int[][] grid) {
            int row = grid.length, col = grid[0].length;
            parent = new int[row * col];
            weight = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        weight[i * col + j] = 1;
                    }
                    parent[i * col + j] = i * col + j;
                }
            }
        }

        public int find(int x) {
            return parent[x] == x ? x : find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (weight[rootX] < weight[rootY]) {
                    weight[rootY] += weight[rootX];
                    parent[rootX] = rootY;
                } else {
                    weight[rootX] += weight[rootY];
                    parent[rootY] = rootX;
                }
            }
        }
    }

    private static class Point {
        private Integer x, y;

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        public boolean equals(Object other) {
            if (!(other instanceof Point)) {
                return false;
            }
            Point otherPoint = (Point) other;
            return Objects.equals(x, otherPoint.x) && Objects.equals(y, otherPoint.y);
        }

        public int hashCode() {
            if (x == null) return (y == null) ? 0 : y.hashCode() + 1;
            else if (y == null) return x.hashCode() + 2;
            else return x.hashCode() * 17 + y.hashCode();
        }
    }

    @Test
    public void testCase1() {
        LeetCode694 leetCode694 = new LeetCode694();
        assert leetCode694.numDistinctIslands(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        }) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode694 leetCode694 = new LeetCode694();
        assert leetCode694.numDistinctIslands(new int[][]{
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        }) == 3;
    }
}
