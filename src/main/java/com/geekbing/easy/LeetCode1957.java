package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1957 {
    public String makeFancyString(String s) {
        char[] chars = s.toCharArray();
        int idx = 1, pre = chars[0], cnt = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == pre) {
                cnt++;
                if (cnt < 3) {
                    chars[idx] = chars[i];
                    idx++;
                }
            } else {
                cnt = 1;
                chars[idx] = chars[i];
                idx++;
            }
            pre = chars[i];
        }
        char[] ans = new char[idx];
        System.arraycopy(chars, 0, ans, 0, idx);
        return new String(ans);
    }

    @Test
    public void testCase1() {
        LeetCode1957 leetCode1957 = new LeetCode1957();
        assert leetCode1957.makeFancyString("leeetcode").equals("leetcode");
    }

    @Test
    public void testCase2() {
        LeetCode1957 leetCode1957 = new LeetCode1957();
        assert leetCode1957.makeFancyString("aaabaaaa").equals("aabaa");
    }

    @Test
    public void testCase3() {
        LeetCode1957 leetCode1957 = new LeetCode1957();
        assert leetCode1957.makeFancyString("aab").equals("aab");
    }
}
