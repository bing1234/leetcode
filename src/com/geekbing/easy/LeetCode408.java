package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < word.length() && idx2 < abbr.length()) {
            // 数字不能有前导0
            char c2 = abbr.charAt(idx2);
            if (c2 == '0') {
                return false;
            }

            // 是字母的话，则需要相等
            char c1 = word.charAt(idx1);
            if (!Character.isDigit(c2)) {
                if (c1 != c2) {
                    return false;
                }
                idx1++;
                idx2++;
            } else {
                // 获取当前数字
                int num = 0;
                while (idx2 < abbr.length() && '0' <= abbr.charAt(idx2) && abbr.charAt(idx2) <= '9') {
                    num = num * 10 + (abbr.charAt(idx2) - '0');
                    idx2++;
                }
                idx1 += num;
            }
        }
        return idx1 == word.length() && idx2 == abbr.length();
    }

    @Test
    public void testCase1() {
        LeetCode408 leetCode408 = new LeetCode408();
        assert leetCode408.validWordAbbreviation("internationalization", "i12iz4n");
    }

    @Test
    public void testCase2() {
        LeetCode408 leetCode408 = new LeetCode408();
        assert !leetCode408.validWordAbbreviation("apple", "a2e");
    }
}
