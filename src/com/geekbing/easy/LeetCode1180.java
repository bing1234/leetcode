package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1180 {
    public int countLetters(String s) {
        // dp[i]是表示以s[i]结尾的只含单一字母的子串个数
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int ans = 0;
        for (int num : dp) {
            ans += num;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1180 leetCode1180 = new LeetCode1180();
        assert leetCode1180.countLetters("aaaba") == 8;
    }

    @Test
    public void testCase2() {
        LeetCode1180 leetCode1180 = new LeetCode1180();
        assert leetCode1180.countLetters("aaaaaaaaaa") == 55;
    }
}
