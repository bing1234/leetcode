package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2042 {
    public boolean areNumbersAscending(String s) {
        char[] chars = s.toCharArray();
        Integer pre = null, cur;
        int i = 0;
        while (i < chars.length) {
            cur = null;
            while (i < chars.length && '0' <= chars[i] && chars[i] <= '9') {
                if (cur == null) {
                    cur = 0;
                }
                cur = cur * 10 + chars[i] - '0';
                i++;
            }
            if (cur != null) {
                if (pre != null && pre >= cur) {
                    return false;
                }
                pre = cur;
            }
            i++;
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode2042 leetCode2042 = new LeetCode2042();
        assert leetCode2042.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles");
    }

    @Test
    public void testCase2() {
        LeetCode2042 leetCode2042 = new LeetCode2042();
        assert !leetCode2042.areNumbersAscending("hello world 5 x 5");
    }

    @Test
    public void testCase3() {
        LeetCode2042 leetCode2042 = new LeetCode2042();
        assert !leetCode2042.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s");
    }

    @Test
    public void testCase4() {
        LeetCode2042 leetCode2042 = new LeetCode2042();
        assert leetCode2042.areNumbersAscending("4 5 11 26");
    }
}
