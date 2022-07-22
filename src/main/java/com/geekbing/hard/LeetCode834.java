package com.geekbing.hard;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode834 {
    // 邻接表
    private Set<Integer>[] graph;
    // 子树节点个数（包括自己）
    private int[] nodeNum;
    // 距离和
    private int[] distSum;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        init(N, edges);
        postOrder(0, -1);
        preOrder(0, -1);
        return distSum;
    }

    private void init(int N, int[][] edges) {
        distSum = new int[N];
        nodeNum = new int[N];
        for (int i = 0; i < N; i++) {
            nodeNum[i] = 1;
        }
        buildGraph(N, edges);
    }

    private void buildGraph(int N, int[][] edges) {
        graph = new Set[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }

    private void postOrder(int root, int parent) {
        Set<Integer> neighbors = graph[root];
        for (Integer neighbor : neighbors) {
            if (neighbor == parent) {
                continue;
            }
            postOrder(neighbor, root);
            nodeNum[root] += nodeNum[neighbor];
            distSum[root] += distSum[neighbor] + nodeNum[neighbor];
        }
    }

    private void preOrder(int root, int parent) {
        Set<Integer> neighbors = graph[root];
        for (Integer neighbor : neighbors) {
            if (neighbor == parent) {
                continue;
            }
            distSum[neighbor] = distSum[root] - nodeNum[neighbor] + graph.length - nodeNum[neighbor];
            preOrder(neighbor, root);
        }
    }

    public static void main(String[] args) {
        LeetCode834 leetCode834 = new LeetCode834();
        System.out.println(Arrays.toString(leetCode834.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
    }
}
