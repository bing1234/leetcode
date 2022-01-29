package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2124 {
    public boolean checkString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < chars.length && chars[left] != 'b') {
            left++;
        }
        while (right >= 0 && chars[right] != 'a') {
            right--;
        }
        if (left == chars.length || right == -1) {
            return true;
        }
        if (chars[left] == 'b' && chars[right] == 'a') {
            return left > right;
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode2124 leetCode2124 = new LeetCode2124();
        assert leetCode2124.checkString("aaabbb");
    }

    @Test
    public void testCase2() {
        LeetCode2124 leetCode2124 = new LeetCode2124();
        assert !leetCode2124.checkString("abab");
    }

    @Test
    public void testCase3() {
        LeetCode2124 leetCode2124 = new LeetCode2124();
        assert leetCode2124.checkString("bbb");
    }
}
