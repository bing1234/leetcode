package com.geekbing.interview;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode0811 {
    public int waysToChange(int n) {
        // 定义dp[n] 表示由5、10、25组成n的方法数
        // dp[n] = dp[n-5] + dp[n-10] + dp[n-25]
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {

            dp[i] = dp[i - 5] + dp[i - 10] + dp[i - 25];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode0811 leetCode0811 = new LeetCode0811();
    }
}
