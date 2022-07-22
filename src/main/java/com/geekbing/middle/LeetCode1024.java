package com.geekbing.middle;

import java.util.Arrays;

/**
 * 1024. 视频拼接
 * https://leetcode-cn.com/problems/video-stitching/
 *
 * @author bing
 */
public class LeetCode1024 {
    public int videoStitching(int[][] clips, int T) {
        // dp[i] 表示将区间 [0,i) 覆盖所需的最少子区间的数量
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    public static void main(String[] args) {
        LeetCode1024 leetCode1024 = new LeetCode1024();
        System.out.println(leetCode1024.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
        System.out.println(leetCode1024.videoStitching(new int[][]{{0, 1}, {1, 2}}, 5));
        System.out.println(leetCode1024.videoStitching(new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}}, 9));
        System.out.println(leetCode1024.videoStitching(new int[][]{{0, 4}, {2, 8}}, 5));
    }
}
