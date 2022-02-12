package com.geekbing.interview;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Interview0101 {
    public boolean isUnique(String astr) {
        if (astr == null || "".equals(astr)) {
            return true;
        }
        if (astr.length() > 256) {
            return false;
        }
        boolean[] arr = new boolean[256];
        for (char c : astr.toCharArray()) {
            if (arr[c]) {
                return false;
            }
            arr[c] = true;
        }
        return true;
    }

    @Test
    public void testCase1() {
        Interview0101 interview0101 = new Interview0101();
        assert !interview0101.isUnique("leetcode");
    }

    @Test
    public void testCase2() {
        Interview0101 interview0101 = new Interview0101();
        assert interview0101.isUnique("abc");
    }
}
