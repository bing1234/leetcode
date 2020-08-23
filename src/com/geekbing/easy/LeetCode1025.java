package com.geekbing.easy;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode1025 {
    public boolean divisorGame(int N) {
        if (N == 1) {
            return false;
        }
        if (N == 2) {
            return true;
        }
        // dp[i]表示数字为时，爱丽丝先手是否能赢
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        LeetCode1025 leetCode1025 = new LeetCode1025();
        System.out.println(leetCode1025.divisorGame(1));
        System.out.println(leetCode1025.divisorGame(2));
        System.out.println(leetCode1025.divisorGame(3));
    }
}
