package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1763 {
    public String longestNiceSubstring(String s) {
        for (int len = s.length(); len > 0; len--) {
            for (int start = 0; start <= s.length() - len; start++) {
                String cur = s.substring(start, start + len);
                if (isNice(cur)) {
                    return cur;
                }
            }
        }
        return "";
    }

    /**
     * 判断字符串是否是美好字符串
     *
     * @param s 需要判断的字符串
     * @return true: 是、false: 不是
     */
    private boolean isNice(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (Character c : set) {
            // c是小写字母
            if (Character.isLowerCase(c) && !set.contains((char) (c - 32))) {
                return false;
            }
            // c是大写字母
            if (Character.isUpperCase(c) && !set.contains((char) (c + 32))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode1763 leetCode1763 = new LeetCode1763();
        assert leetCode1763.longestNiceSubstring("YazaAay").equals("aAa");
    }

    @Test
    public void testCase2() {
        LeetCode1763 leetCode1763 = new LeetCode1763();
        assert leetCode1763.longestNiceSubstring("Bb").equals("Bb");
    }

    @Test
    public void testCase3() {
        LeetCode1763 leetCode1763 = new LeetCode1763();
        assert leetCode1763.longestNiceSubstring("c").equals("");
    }

    @Test
    public void testCase4() {
        LeetCode1763 leetCode1763 = new LeetCode1763();
        assert leetCode1763.longestNiceSubstring("dDzeE").equals("dD");
    }
}
