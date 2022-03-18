package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        // dp[i]表示以chars[i]结尾的最长有效括号子串的长度
        int[] dp = new int[chars.length];
        int ans = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    int len = dp[i - 1];
                    if (i - len - 1 >= 0 && chars[i - len - 1] == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - len >= 2 ? dp[i - len - 2] : 0);
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode32 leetCode32 = new LeetCode32();
        assert leetCode32.longestValidParentheses("(()") == 2;
    }

    @Test
    public void testCase2() {
        LeetCode32 leetCode32 = new LeetCode32();
        assert leetCode32.longestValidParentheses(")()())") == 4;
    }

    @Test
    public void testCase3() {
        LeetCode32 leetCode32 = new LeetCode32();
        assert leetCode32.longestValidParentheses("") == 0;
    }

    @Test
    public void testCase4() {
        LeetCode32 leetCode32 = new LeetCode32();
        assert leetCode32.longestValidParentheses("()") == 2;
    }

    @Test
    public void testCase5() {
        LeetCode32 leetCode32 = new LeetCode32();
        assert leetCode32.longestValidParentheses("()(())") == 6;
    }
}
