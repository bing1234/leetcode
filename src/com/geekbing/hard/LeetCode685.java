package com.geekbing.hard;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/redundant-connection-ii/
 * 685. 冗余连接 II
 *
 * @author bing
 */
public class LeetCode685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length];
        Arrays.fill(parent, -1);

        // 找到环的一条边了
        int[] temp = new int[]{-1, -1};
        for (int[] edge : edges) {
            if (union(edge, parent) == 0) {
                temp = edge;
                System.out.println(Arrays.toString(temp));
                break;
            }
        }
        return temp;
    }

    private int findRoot(int x, int[] parent) {
        int root = x;
        while (parent[root] != -1) {
            root = parent[root];
        }
        return root;
    }

    private int union(int[] edge, int[] parent) {
        int rootX = findRoot(edge[0] - 1, parent);
        int rootY = findRoot(edge[1] - 1, parent);
        if (rootX == rootY) {
            return 0;
        }
        parent[edge[1] - 1] = edge[0] - 1;
        return 1;
    }

    public static void main(String[] args) {
        LeetCode685 leetCode685 = new LeetCode685();
        System.out.println(Arrays.toString(leetCode685.findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(leetCode685.findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})));
        System.out.println(Arrays.toString(leetCode685.findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}})));
    }
}
