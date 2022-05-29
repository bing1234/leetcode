package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2278 {
    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == letter) {
                cnt++;
            }
        }
        return cnt * 100 / s.length();
    }

    @Test
    public void testCase1() {
        LeetCode2278 leetCode2278 = new LeetCode2278();
        assert leetCode2278.percentageLetter("foobar", 'o') == 33;
    }

    @Test
    public void testCase2() {
        LeetCode2278 leetCode2278 = new LeetCode2278();
        assert leetCode2278.percentageLetter("jjjj", 'k') == 0;
    }
}
