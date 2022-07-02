package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode647 {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                if (isValid(str)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int countSubstringsV2(String s) {
        // dp[i][j]表示子串s[i...j]是否是回文数
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            // 单个的字符都是回文子串
            dp[i][i] = true;

            // 每两相邻且相等的都是回文子串
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                if (i + 1 < s.length() && j - 1 >= 0 && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        int ans = 0;
        for (boolean[] booleans : dp) {
            for (boolean item : booleans) {
                if (item) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isValid(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode647 leetCode647 = new LeetCode647();
        assert leetCode647.countSubstrings("abc") == 3;
    }

    @Test
    public void testCase2() {
        LeetCode647 leetCode647 = new LeetCode647();
        assert leetCode647.countSubstrings("aaa") == 6;
    }

    @Test
    public void testCase3() {
        LeetCode647 leetCode647 = new LeetCode647();
        assert leetCode647.countSubstringsV2("abc") == 3;
    }

    @Test
    public void testCase4() {
        LeetCode647 leetCode647 = new LeetCode647();
        assert leetCode647.countSubstringsV2("aaa") == 6;
    }

    @Test
    public void testCase5() {
        LeetCode647 leetCode647 = new LeetCode647();
        int ans = leetCode647.countSubstringsV2("aaaaa");
        assert ans == 15;
    }
}
