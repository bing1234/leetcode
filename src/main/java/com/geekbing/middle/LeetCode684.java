package com.geekbing.middle;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/redundant-connection/
 * 684. 冗余连接
 *
 * @author bing
 */
public class LeetCode684 {
    public int[] findRedundantConnectionV2(int[][] edges) {
        int[] parent = new int[edges.length];
        int[] rank = new int[edges.length];
        Arrays.fill(parent, -1);
        for (int[] edge : edges) {
            if (union(edge[0] - 1, edge[1] - 1, parent, rank) == 0) {
                return edge;
            }
        }
        return new int[]{-1, -1};
    }

    private int union(int x, int y, int[] parent, int[] rank) {
        int rootX = findRoot(x, parent);
        int rootY = findRoot(y, parent);
        if (rootX == rootY) {
            return 0;
        }
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return 1;
    }

    private int findRoot(int x, int[] parent) {
        int root = x;
        while (parent[root] != -1) {
            root = parent[root];
        }
        return root;
    }

    public int[] findRedundantConnection(int[][] edges) {
        // 度
        Map<Integer, Integer> degree = new HashMap<>();
        for (int[] edge : edges) {
            degree.put(edge[0], degree.containsKey(edge[0]) ? degree.get(edge[0]) + 1 : 1);
            degree.put(edge[1], degree.containsKey(edge[1]) ? degree.get(edge[1]) + 1 : 1);
        }
        // 找到度为1的节点，将其度减去1，然后将与该节点相连接的节点度都减去1
        // 反复该过程，最后只剩下环节点的度都是2
        while (true) {
            boolean has = false;
            for (Integer key : degree.keySet()) {
                if (degree.get(key) == 1) {
                    has = true;
                    degree.put(key, 0);
                    for (int[] edge : edges) {
                        if (edge[0] == key) {
                            degree.put(edge[1], degree.get(edge[1]) - 1);
                        }
                        if (edge[1] == key) {
                            degree.put(edge[0], degree.get(edge[0]) - 1);
                        }
                    }
                }
            }
            if (!has) {
                break;
            }
        }
        List<Integer> nodes = new ArrayList<>();
        for (Integer key : degree.keySet()) {
            if (degree.get(key) == 2) {
                nodes.add(key);
            }
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            if (nodes.contains(edges[i][0]) && nodes.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        LeetCode684 leetCode684 = new LeetCode684();
        int[][] edges1 = new int[3][2];
        edges1[0] = new int[]{1, 2};
        edges1[1] = new int[]{1, 3};
        edges1[2] = new int[]{2, 3};
        System.out.println(Arrays.toString(leetCode684.findRedundantConnectionV2(edges1)));

        int[][] edges2 = new int[5][2];
        edges2[0] = new int[]{1, 2};
        edges2[1] = new int[]{2, 3};
        edges2[2] = new int[]{3, 4};
        edges2[3] = new int[]{1, 4};
        edges2[4] = new int[]{1, 5};
        System.out.println(Arrays.toString(leetCode684.findRedundantConnectionV2(edges2)));

        int[][] edges3 = new int[5][2];
        edges3[0] = new int[]{1, 3};
        edges3[1] = new int[]{3, 4};
        edges3[2] = new int[]{1, 5};
        edges3[3] = new int[]{3, 5};
        edges3[4] = new int[]{2, 3};
        System.out.println(Arrays.toString(leetCode684.findRedundantConnectionV2(edges3)));
    }
}
