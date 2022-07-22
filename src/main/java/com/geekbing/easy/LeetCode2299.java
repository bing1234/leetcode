package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode2299 {
    private final Set<Character> specials = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

    public boolean strongPasswordCheckerII(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean lowercase = false, upcase = false, hasNum = false, special = false;
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                return false;
            }
            if ('a' <= chars[i] && chars[i] <= 'z') {
                lowercase = true;
            } else if ('A' <= chars[i] && chars[i] <= 'Z') {
                upcase = true;
            } else if ('0' <= chars[i] && chars[i] <= '9') {
                hasNum = true;
            } else if (specials.contains(chars[i])) {
                special = true;
            }
        }
        return lowercase && upcase && hasNum && special;
    }

    @Test
    public void testCase1() {
        LeetCode2299 leetCode2299 = new LeetCode2299();
        assert leetCode2299.strongPasswordCheckerII("IloveLe3tcode!");
    }

    @Test
    public void testCase2() {
        LeetCode2299 leetCode2299 = new LeetCode2299();
        assert !leetCode2299.strongPasswordCheckerII("Me+You--IsMyDream");
    }

    @Test
    public void testCase3() {
        LeetCode2299 leetCode2299 = new LeetCode2299();
        assert !leetCode2299.strongPasswordCheckerII("1aB!");
    }
}
