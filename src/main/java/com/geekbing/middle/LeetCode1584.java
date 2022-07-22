package com.geekbing.middle;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1584 {
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, distance));
            }
        }
        edges.sort(Comparator.comparingInt(e -> e.len));
        int ans = 0, num = 0;
        DisjointSetUnion dsu = new DisjointSetUnion(points.length);
        for (Edge edge : edges) {
            if (dsu.union(edge.x, edge.y)) {
                ans += edge.len;
                num++;
                if (num == points.length) {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1584 leetCode1584 = new LeetCode1584();

        System.out.println(leetCode1584.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        System.out.println(leetCode1584.minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
        System.out.println(leetCode1584.minCostConnectPoints(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}));
        System.out.println(leetCode1584.minCostConnectPoints(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}));
        System.out.println(leetCode1584.minCostConnectPoints(new int[][]{{0, 0}}));

    }

    private static class DisjointSetUnion {
        int[] parent;
        int[] rank;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            this.rank = new int[n];
            this.parent = new int[n];
            Arrays.fill(this.rank, 1);
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        private int findRoot(int x) {
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

        private boolean union(int x, int y) {
            int rootX = findRoot(x);
            int rootY = findRoot(y);
            if (rootX == rootY) {
                return false;
            }
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    private static class Edge {
        private int x;
        private int y;
        private int len;

        public Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }
    }
}
