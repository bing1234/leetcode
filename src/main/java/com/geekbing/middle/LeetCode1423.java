package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1423 {
    public int maxScore(int[] cardPoints, int k) {
        // // 维持一个滑动窗口，保持窗口中的值最小
        int sum = Arrays.stream(cardPoints).reduce(Integer::sum).orElse(0);
        int temp = 0, min = Integer.MAX_VALUE;
        int len = cardPoints.length - k;
        for (int i = 0; i < cardPoints.length; i++) {
            temp = temp + cardPoints[i];
            if (i >= len) {
                temp = temp - cardPoints[i - len];
            }
            if (i >= len - 1) {
                min = Math.min(min, temp);
            }
        }
        return sum - min;
    }

    public int maxScoreV2(int[] cardPoints, int k) {
        // dp[i][j][k] 表示 cardPoints[i...j]拿k张牌可以获得的最大分数
        // dp[i][j][k] = Math.max(dp[i+1][j][k-1] + cardPoints[i], dp[i][j-1][k-1] + cardPoints[j])
        int[][][] dp = new int[cardPoints.length][cardPoints.length][k + 1];

        for (int i = 0; i < cardPoints.length; i++) {
            for (int num = 1; num <= k; num++) {
                dp[i][i][num] = cardPoints[i];
            }
        }

        for (int i = 0; i < cardPoints.length; i++) {
            for (int j = i; j < cardPoints.length; j++) {
                dp[i][j][1] = Math.max(cardPoints[i], cardPoints[j]);
            }
        }

        for (int i = 0; i < cardPoints.length; i++) {
            for (int j = i; j < cardPoints.length; j++) {
                for (int num = 1; num <= k && num <= j - i + 1; num++) {
                    if (i + 1 < cardPoints.length && j >= 1) {
                        dp[i][j][num] = Math.max(dp[i + 1][j][num - 1] + cardPoints[i], dp[i][j - 1][num - 1] + cardPoints[j]);
                    }
                }
            }
        }
        return dp[0][cardPoints.length - 1][k];
    }

    public static void main(String[] args) {
        LeetCode1423 leetCode1423 = new LeetCode1423();
        System.out.println(leetCode1423.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(leetCode1423.maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(leetCode1423.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        System.out.println(leetCode1423.maxScore(new int[]{1, 1000, 1}, 1));
        System.out.println(leetCode1423.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }
}
