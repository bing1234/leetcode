package com.geekbing.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode514 {
    public int findRotateSteps(String ring, String key) {
        // DP
        // key[i]的操作数 = key[i - 1] + 操作i需要的步数 + 1
        // 操作i的步数 = max(|x - y|, n - |x - y|)
        // 可以写出DP方程 dp[i] = dp[i - 1] + key[i - 1] -> key[i]最短操作距离 + 1

        //  key[i - 1] -> key[i]最短操作距离我举得是可以贪心的，但是 key[i] 在ring里面是重复的，你不知道当前是在哪里
        // 所以需要多加一维数组
        // dp[i][j] j 表示 i 在 ring 中的位置

        if (ring == null || ring.length() == 0) {
            return 0;
        }
        if (key == null || key.length() == 0) {
            return 1;
        }
        int n = ring.length(), m = key.length();
        ArrayList<Integer>[] lists = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            lists[ring.charAt(i) - 'a'].add(i);
        }

        // base case
        int[][] dp = new int[m][n];
        // 第一个字符在list中的所以
        int fristCaseIdx = key.charAt(0) - 'a';
        // 遍历第一个字符出席的所有位置列表
        for (int j = 0; j < lists[fristCaseIdx].size(); j++) {
            int xSuby = Math.abs(lists[fristCaseIdx].get(j) - lists[ring.charAt(0) - 'a'].get(0));
            dp[0][j] = Math.min(xSuby, n - xSuby) + 1;
        }

        // dp
        for (int i = 1; i < m; i++) {
            List<Integer> curCaseIdxs = lists[key.charAt(i) - 'a'], preCaseIdxs = lists[key.charAt(i - 1) - 'a'];
            for (int j = 0; j < curCaseIdxs.size(); j++) {
                int curCaseIdx = curCaseIdxs.get(j);

                int min = Integer.MAX_VALUE;
                for (int k = 0; k < preCaseIdxs.size(); k++) {
                    int xSuby = Math.abs(curCaseIdx - preCaseIdxs.get(k));
                    min = Math.min(min, dp[i - 1][k] + Math.min(xSuby, n - xSuby) + 1);
                }
                dp[i][j] = min;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < dp[m - 1].length; j++) {
            if (dp[m - 1][j] == 0) {
                break;
            }
            min = Math.min(min, dp[m - 1][j]);
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode514 leetCode514 = new LeetCode514();
        System.out.println(leetCode514.findRotateSteps("godding", "gd"));
    }
}
