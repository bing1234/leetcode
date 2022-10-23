package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode711 {
    public int numDistinctIslands2(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        UnionFind unionFind = new UnionFind(row * col);
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

        // root - root所对应的圈子
        Map<Integer, List<Point>> map = buildRootCircleMap(grid, unionFind);

        // 得到所有的岛屿的唯一标识ID列表
        return (int) map.values().stream().map(this::getIsLandId).distinct().count();
    }

    /**
     * 对岛屿进行归一化处理，得到唯一标识ID
     */
    private Integer getIsLandId(List<Point> points) {
        List<Integer> list = new ArrayList<>();
        list.add(getIsLandHashId(points, p -> new Point(p.x, p.y)));
        list.add(getIsLandHashId(points, p -> new Point(p.x, -p.y)));
        list.add(getIsLandHashId(points, p -> new Point(-p.x, p.y)));
        list.add(getIsLandHashId(points, p -> new Point(-p.x, -p.y)));
        list.add(getIsLandHashId(points, p -> new Point(p.y, p.x)));
        list.add(getIsLandHashId(points, p -> new Point(p.y, -p.x)));
        list.add(getIsLandHashId(points, p -> new Point(-p.y, p.x)));
        list.add(getIsLandHashId(points, p -> new Point(-p.y, -p.x)));
        // 返回最小的Hash Id
        return list.stream().min(Integer::compareTo).orElse(0);
    }

    private int getIsLandHashId(List<Point> points, Function<Point, Point> function) {
        // 转换
        List<Point> list = change(points, function);
        // 平移
        List<Point> list1 = move(list);
        // 排序
        List<Point> list2 = list1.stream().sorted(Point::compare).collect(Collectors.toList());
        // 得到Hash Id
        return Objects.hash(list2);
    }

    private List<Point> change(List<Point> points, Function<Point, Point> function) {
        List<Point> list = new ArrayList<>();
        for (Point point : points) {
            list.add(function.apply(point));
        }
        return list;
    }

    private List<Point> move(List<Point> points) {
        int minX = points.get(0).x, minY = points.get(0).y;
        for (Point point : points) {
            minX = Math.min(minX, point.x);
            minY = Math.min(minY, point.y);
        }
        // 所有的点都减去minX, minY
        List<Point> list = new ArrayList<>();
        for (Point point : points) {
            list.add(new Point(point.x - minX, point.y - minY));
        }
        return list;
    }

    private Map<Integer, List<Point>> buildRootCircleMap(int[][] grid, UnionFind unionFind) {
        int row = grid.length, col = grid[0].length;
        Map<Integer, List<Point>> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int root = unionFind.find(i * col + j);
                List<Point> list = map.getOrDefault(root, new ArrayList<>());
                list.add(new Point(i, j));
                map.put(root, list);
            }
        }
        return map;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int compare(Point p) {
            int flag = Integer.compare(this.x, p.x);
            if (flag != 0) {
                return flag;
            }
            return Integer.compare(this.y, p.y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
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

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (weight[rootX] < weight[rootY]) {
                    parent[rootX] = rootY;
                    weight[rootY] += weight[rootX];
                } else {
                    parent[rootY] = rootX;
                    weight[rootX] += weight[rootY];
                }
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode711 leetCode711 = new LeetCode711();
        int ans = leetCode711.numDistinctIslands2(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1}
        });
        assert ans == 1;
    }

    @Test
    public void testCase2() {
        LeetCode711 leetCode711 = new LeetCode711();
        int ans = leetCode711.numDistinctIslands2(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        });
        assert ans == 1;
    }

    @Test
    public void testCase3() {
        LeetCode711 leetCode711 = new LeetCode711();
        int ans = leetCode711.numDistinctIslands2(new int[][]{
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        });
        assert ans == 2;
    }
}