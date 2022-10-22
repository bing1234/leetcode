package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2424 {

    public static class LUPrefix {
        private final UnionFind unionFind;

        public LUPrefix(int n) {
            unionFind = new UnionFind(n);
        }

        public void upload(int video) {
            unionFind.union(video, video + 1);
        }

        public int longest() {
            return unionFind.find(1) - 1;
        }
    }

    private static class UnionFind {
        private final int[] parent;

        public UnionFind(int n) {
            parent = new int[n + 2];
            for (int i = 1; i <= n + 1; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            parent[rootI] = rootJ;
        }
    }

    @Test
    public void testCase1() {
        LUPrefix server = new LUPrefix(4);   // 初始化 4个视频的上传流
        server.upload(3);                    // 上传视频 3 。
        int ans = server.longest();
        assert ans == 0;                     // 由于视频 1 还没有被上传，最长上传前缀是 0 。
        server.upload(1);                    // 上传视频 1 。
        ans = server.longest();
        assert ans == 1;                     // 前缀 [1] 是最长上传前缀，所以我们返回 1 。
        server.upload(2);                    // 上传视频 2 。
        ans = server.longest();
        assert ans == 3;                     // 前缀 [1,2,3] 是最长上传前缀，所以我们返回 3 。
    }
}