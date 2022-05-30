package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode6083 {
    public boolean digitCount(String num) {
        int len = num.length();
        int[] arr = new int[len];
        char[] chars = num.toCharArray();
        for (char c : chars) {
            if (c - '0' >= len) {
                return false;
            }
            arr[c - '0']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[i] != chars[i] - '0') {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode6083 leetCode6083 = new LeetCode6083();
        assert leetCode6083.digitCount("1210");
    }

    @Test
    public void testCase2() {
        LeetCode6083 leetCode6083 = new LeetCode6083();
        assert !leetCode6083.digitCount("030");
    }
}
